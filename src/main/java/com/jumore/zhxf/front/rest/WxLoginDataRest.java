package com.jumore.zhxf.front.rest;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import io.swagger.annotations.ApiOperation;

/**
 * REST controller for managing wxlogin.
 */
@RestController
@RequestMapping("/wx")
public class WxLoginDataRest {
	private final Logger log = LoggerFactory.getLogger(WxLoginDataRest.class);

	/**
	 * GET /regists : get all the regists.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of regists
	 *         in body
	 * @throws URISyntaxException
	 *             if there is an error to generate the pagination HTTP headers
	 * @throws UnsupportedEncodingException
	 */
	@PostMapping("/login")
	@Timed
	@ApiOperation(value = "微信登录相关数据", notes = "微信登录相关数据接口{参数说明：" + "\n\r APP_ID:公众号appid," + "\r\n redirect_uri:微信回调参数"
			+ "\n\r 登录url:"
			+ "\n\r        https://open.weixin.qq.com/connect/oauth2/authorize?appid=${APPID_WECHAT}&redirect_uri=${redirect_uri}&response_type=code&scope=snsapi_userinfo&state=state#wechat_redirect }")
	public ResponseEntity<Map<String, String>> getWxLoinData() throws URISyntaxException, UnsupportedEncodingException {
		log.debug("REST request to get a page of Regists");
		Map<String, String> param = new HashMap<String, String>();

		// app id
	//	param.put("APP_ID", WxCallbackHandle.APP_ID);

		// 回调地址
		String redirect_uri = java.net.URLDecoder.decode("http://wxdev02.jumore.com/wx/call", "utf-8");
		param.put("redirect_uri", redirect_uri);

		return new ResponseEntity<>(param, HttpStatus.OK);
	}
}
