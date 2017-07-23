/**
 * 存放项目的基本信息:开始时间，结束时间，是否停工等
 * ProjectMapper.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-23 Created
 */
package java;

import java.Project;
import java.ProjectQueryHelper;
import org.mybatis.generator.base.mapper.single.BaseMapper;

public interface ProjectMapper extends BaseMapper<Project, ProjectQueryHelper> {
}