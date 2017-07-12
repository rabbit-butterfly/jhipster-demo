package com.jumore.zhxf.task.core;

import org.json.JSONException;

import com.jumore.zhxf.domain.oa.CheckConfig;

/**
 * 资讯信息获取总接口
 * 
 * @author 0338 create by 2017-01-16
 *
 */
public interface IWorker {

	void excute();
	
	String getList(CheckConfig checkConfig) throws JSONException;
}
