package com.noriental.modules.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noriental.modules.project.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:25
 */
@Mapper
public interface ProjectMapper extends BaseMapper<ProjectEntity> {

}
