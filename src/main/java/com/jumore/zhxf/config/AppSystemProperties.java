package com.jumore.zhxf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 文件上传的配置信息
 * @author Administrator
 *
 */
@ConfigurationProperties(prefix = "system.upload")
public class AppSystemProperties {
	
	//上传文图片大最大5M
	private int maxsize = 5;

    private String root = "\\resource";

	public int getMaxsize() {
		return maxsize;
	}

	public void setMaxsize(int maxsize) {
		this.maxsize = maxsize;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}
    
    

}
