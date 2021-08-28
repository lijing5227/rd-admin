package com.noriental.modules.ds.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noriental.common.datasource.support.DataSourceConstants;
import com.noriental.common.util.SpringContextHolder;
import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.Query;
import com.noriental.modules.ds.dao.DataSourceDao;
import com.noriental.modules.ds.entity.DataSourceEntity;
import com.noriental.modules.ds.service.DataSourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service("dataSourceService")
public class DataSourceServiceImpl extends ServiceImpl<DataSourceDao, DataSourceEntity> implements DataSourceService {
    private final StringEncryptor stringEncryptor;
    private final DataSourceCreator dataSourceCreator;
    private final DataSource dataSource;

    @Override
    public PageResult queryPage(Map<String, Object> params) {
        IPage<DataSourceEntity> page = this.page(
                new Query<DataSourceEntity>().getPage(params),
                new QueryWrapper<DataSourceEntity>()
        );

        return new PageResult(page);
    }

    @Override
    public boolean save(DataSourceEntity entity) {
        initEntity(entity);
        // 校验配置合法性
        if (!checkDataSource(entity)) {
            return Boolean.FALSE;
        }
        //添加动态数据源
        addDynamicDataSource(entity);
        // 更新数据库配置
        entity.setPassword(stringEncryptor.encrypt(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public boolean updateById(DataSourceEntity entity) {
        if (!checkDataSource(entity)) {
            return Boolean.FALSE;
        }
        //先移除
        SpringContextHolder.getBean(DynamicRoutingDataSource.class)
                .removeDataSource(baseMapper.selectById(entity.getId()).getName());

        //再添加
        addDynamicDataSource(entity);

        // 更新数据库配置
        if (StrUtil.isNotBlank(entity.getPassword())) {
            entity.setPassword(stringEncryptor.encrypt(entity.getPassword()));
        }
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        SpringContextHolder.getBean(DynamicRoutingDataSource.class)
                .removeDataSource(baseMapper.selectById(id).getName());
        return super.removeById(id);
    }

    /**
     * 初始化数据
     *
     * @param entity
     */
    private void initEntity(DataSourceEntity entity) {
        entity.setCreateTime(new Date());
        entity.setDelFlag(0);
    }

    /**
     * 校验数据源配置是否有效
     *
     * @param conf 数据源信息
     * @return 有效/无效
     */
    public Boolean checkDataSource(DataSourceEntity conf) {
        try {
            DriverManager.getConnection(conf.getUrl(), conf.getUsername(), conf.getPassword());
        } catch (SQLException e) {
            log.error("数据源配置 {} , 获取链接失败", conf.getName(), e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 添加动态数据源
     *
     * @param conf 数据源信息
     */
    public void addDynamicDataSource(DataSourceEntity conf) {
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setPollName(conf.getName());
        dataSourceProperty.setUrl(conf.getUrl());
        dataSourceProperty.setUsername(conf.getUsername());
        dataSourceProperty.setPassword(conf.getPassword());
        dataSourceProperty.setDriverClassName(DataSourceConstants.DS_DRIVER);
        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
        SpringContextHolder.getBean(DynamicRoutingDataSource.class)
                .addDataSource(dataSourceProperty.getPollName(), dataSource);
    }

    @Override
    public List listAll() {
        return baseMapper.selectList(null);
    }
}