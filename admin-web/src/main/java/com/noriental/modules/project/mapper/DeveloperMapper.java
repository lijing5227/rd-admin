package com.noriental.modules.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noriental.modules.project.entity.DeveloperEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目开发人员表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:31
 */
@Mapper
public interface DeveloperMapper extends BaseMapper<DeveloperEntity> {

}
