/**
 * 公司表：存放公司的基本信息
 * CompanyMapper.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-23 Created
 */
package java;

import java.Company;
import java.CompanyQueryHelper;
import org.mybatis.generator.base.mapper.single.BaseMapper;

public interface CompanyMapper extends BaseMapper<Company, CompanyQueryHelper> {
}