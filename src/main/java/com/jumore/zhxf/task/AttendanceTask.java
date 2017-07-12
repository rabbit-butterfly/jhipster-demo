package com.jumore.zhxf.task;

import javax.annotation.Resource;

import org.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jumore.zhxf.task.core.CheckFactory;
import com.jumore.zhxf.task.core.CheckFactory.PlatformCode;

/**
 * 考勤定时任务
 * 
 * @author Administrator
 *
 */

@Component
public class AttendanceTask {


	@Scheduled(cron="0 36 16,20 * * ?")
	//@Scheduled(fixedRate = 5000)
	//0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
	public void reportCurrentTime() throws JSONException {
		//System.out.println("The time is now " + dateFormat.format(new Date()));
		//CheckFactory.createWorker(PlatformCode.YNWEI2).excute();
	}
}