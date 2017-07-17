package com.jumore.zhxf.task.core;

import com.jumore.zhxf.task.IAttendanceHelpper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestOperations;

public class YunWeoCheckWorker implements IWorker {

	private final Logger log = LoggerFactory.getLogger(IAttendanceHelpper.class);

	// private final static String HOST = "http://www.jumoreoa.com";

	private final static String LOGIN = "http://www.jumoreoa.com/oa/login.do?action=check";

	private final static String LOGINOUT = "http://www.jumoreoa.com/oa/checkinoutOa.do?action=checkout";

	// private final static String QUERY_LIST =
	// "http://www.jumoreoa.com/oa/checkinoutOa.do?action=listCheckInOut";

	private final RestOperations restOperations;

	public YunWeoCheckWorker(RestTemplateBuilder restTemplateBuilder) {
		this.restOperations = restTemplateBuilder.build();
	}

    @Override
    public void excute() {

    }

/*	@Inject
	private CheckConfigService checkConfigService;*/

	/*public void excute() {

		log.info("auto check start..");
		List<CheckConfig> list = checkConfigService.findByStatus(CheckConfigDTO.EStatus.enabled);
		for (CheckConfig checkConfig : list) {
			// 登录
			String sid = login(checkConfig);
			//
			singBack(sid, checkConfig);

		}
	}*/

	/*private String login(CheckConfig checkConfig) {
		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();

		*//*try {
			CryptoTools des = new CryptoTools();
			mvm.add("userId", "fanwengang");
			mvm.add("pwd", des.decode(checkConfig.getOaPwd()));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}*//*

		ResponseEntity<String> resp = restOperations.postForEntity(LOGIN, mvm, String.class);

		if (resp.getStatusCode() == HttpStatus.OK) {
			JsonObject json = new JsonParser().parse(resp.getBody()).getAsJsonObject();

			if (!json.get("success").getAsBoolean()) {
				checkConfig.setStatus(EStatus.disabled.ordinal());
				checkConfig.setRemark(json.get("message").toString());
				checkConfigService.save(checkConfig);
				throw new RuntimeException(checkConfig.getRemark());
			}

			// 获取返回的header
			List<String> val = resp.getHeaders().get("Set-Cookie");
			String sid = null;
			for (String string : val) {
				if (string.startsWith("JSESSIONID=")) {
					int index = string.indexOf(";");
					sid = string.substring("JSESSIONID=".length(), index);
					break;
				}
			}
			if (sid == null) {
				log.error("header＝{}", resp.getHeaders());
				// throw new RuntimeException("login success,but not get sid of
				// header");

			}
			return sid;
		} else {
			checkConfig.setStatus(EStatus.disabled.ordinal());
			checkConfig.setRemark("登录失败");
			checkConfigService.save(checkConfig);
			log.error("header＝{}", resp.getHeaders());
			log.error("body＝{}", resp.getBody());
			throw new RuntimeException("login oa system error,");
		}
	}

	private void singBack(String sessionId, CheckConfig checkConfig) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Cookie", sessionId);

		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();

		String checkTime = getCheckTime();
		param.add("check_time", checkTime);
		param.add("check_sys", "0");
		// 备注 三位随机字符串
		param.add("remark", RandomStringUtils.randomNumeric(3));

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(param,
				headers);
		ResponseEntity<String> resp = restOperations.postForEntity(LOGINOUT, requestEntity, String.class);

		String result = "";
		if (resp.getStatusCode() == HttpStatus.OK) {
			JsonObject json = new JsonParser().parse(resp.getBody()).getAsJsonObject();

			if (json.get("success").getAsBoolean()) {
				checkConfig.setStatus(EStatus.disabled.ordinal());
				checkConfig.setRemark("ok");
				checkConfig.setLastModifyTime(new Date());
				result = "success";
			} else {
				checkConfig.setRemark("error");
			}
			result = json.get("message").toString();
			checkConfigService.save(checkConfig);
		} else {
			checkConfig.setRemark("签退接口调用失败..");
			checkConfigService.save(checkConfig);
			log.error("header＝{}", resp.getHeaders());
			log.error("body＝{}", resp.getBody());
			result = "接口调用失败";
		}

		if (checkConfig.isReceiveEmail()) {
			checkConfigService.sendEmail(checkConfig.getUserId(), result);
		}

	}

	*//**
	 * 随机获取一个下班时间
	 *
	 * @return
	 *//*
	private String getCheckTime() {
		// 随机取个下班时间
		// 前后半小时
		int minutes = 0;
		// 前后30秒
		int seconds = 0;
		minutes = RandomUtils.nextInt(0, 60) - 30;
		seconds = RandomUtils.nextInt(0, 60) - 30;
		minutes = RandomUtils.nextInt(0, 3) - 3;
		seconds = RandomUtils.nextInt(0, 2) - 2;

		String checkTime = new DateTime().plusMinutes(minutes).plusSeconds(-seconds).toString("yyyy-MM-dd HH:mm:ss");
		return checkTime;
	}

	@Override
	public String getList(CheckConfig checkConfig) throws JSONException {

		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
		mvm.add("userId", "fanwengang");
		mvm.add("pwd", "123456");
		ResponseEntity<String> resp = restOperations.postForEntity(LOGIN, mvm, String.class);

		// 获取返回的header
		List<String> val = resp.getHeaders().get("Set-Cookie");
		String sid = null;
		for (String string : val) {
			if (string.startsWith("JSESSIONID=")) {
				int index = string.indexOf(";");
				sid = string.substring("JSESSIONID=".length(), index);
				break;
			}
		}
		if (sid == null) {

		}
		return sid;
	}*/
}
