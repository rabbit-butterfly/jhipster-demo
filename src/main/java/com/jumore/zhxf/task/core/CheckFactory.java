package com.jumore.zhxf.task.core;

import com.jumore.zhxf.task.SpringUtils;

/**
 * 资讯工厂类
 * 
 * @author 0338 create by 2017-01-16
 *
 */
public class CheckFactory {

	public static IWorker createWorker(PlatformCode platformCode) {

		IWorker work = null;
		
		switch (platformCode) {
		case YNWEI2:
			//work=SpringUtils.getBean("yunWeoCheckWorker",IWorker.class);
			break;

		default:
			break;
		}
		
		

		return work;
	}

	public enum PlatformCode {

		YNWEI2
	}

}
