package com.jumore.zhxf.service.oa;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.apache.lucene.search.spans.SpanPositionRangeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.User;
import com.jumore.zhxf.domain.oa.CheckConfig;
import com.jumore.zhxf.repository.UserRepository;
import com.jumore.zhxf.repository.oa.CheckConfigRepository;
import com.jumore.zhxf.security.SecurityUtils;
import com.jumore.zhxf.service.MailService;
import com.jumore.zhxf.web.rest.dto.oa.CheckConfigDTO;
import com.jumore.zhxf.web.rest.dto.oa.CheckConfigDTO.EStatus;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class CheckConfigService {

	
	
	@Resource
	private MailService mailService;
	@Resource
	private CheckConfigRepository checkConfigRepository;

	@Resource
	private UserRepository userRepository;

	private final Logger log = LoggerFactory.getLogger(CheckConfigService.class);

	public CheckConfig create(CheckConfigDTO checkConfigDTO) {

		Optional<User> user = userRepository.findOneByLogin(SecurityUtils.getCurrentUser().getUsername());
		CheckConfig checkConfig = checkConfigRepository.findOne(user.get().getId());
		if (checkConfig == null) {
			checkConfig = new CheckConfig();
			checkConfig.setUserId(user.get().getId());
		}
		try {
			
			checkConfig.setStatus(checkConfigDTO.getStatus().ordinal());
			checkConfig.setOaAcc(checkConfigDTO.getOaAcc());
			//checkConfig.setOaPwd(des.encode(checkConfigDTO.getNewPwd()));
			
			checkConfig.setOaPlatform(checkConfigDTO.getOaPlatform());
			checkConfig.setReceiveEmail(checkConfigDTO.isReceiveEmail());
			checkConfig.setRemark("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		checkConfigRepository.save(checkConfig);

		log.debug("Created Information for CheckConfig: {}", checkConfig);
		return checkConfig;
	}

	public CheckConfig modify(CheckConfigDTO checkConfigDTO) {
		Optional<User> user = userRepository.findOneByLogin(SecurityUtils.getCurrentUser().getUsername());

		CheckConfig checkConfig = checkConfigRepository.findOne(user.get().getId());
		if (checkConfig == null) {
			throw new RuntimeException("system error...");
		}

		checkConfig.setStatus(checkConfigDTO.getStatus().ordinal());
		checkConfig.setOaAcc(checkConfigDTO.getOaAcc());
//		if(!checkConfigDTO.getNewPwd().equals(checkConfig.getOaPwd())){
//			CryptoTools des;
//			try {
//				des = new CryptoTools();
//				checkConfig.setOaPwd(des.encode(checkConfigDTO.getNewPwd()));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		checkConfig.setOaPlatform(checkConfigDTO.getOaPlatform());
		checkConfig.setReceiveEmail(checkConfigDTO.isReceiveEmail());
		checkConfig.setRemark("");
		log.debug("Modify Information for CheckConfig: {}", checkConfig);
		checkConfigRepository.save(checkConfig);
		return checkConfig;
	}

	public List<CheckConfig> findByStatus(EStatus enabled) {

		return checkConfigRepository.findByStatus(enabled.ordinal());
	}
	
	public CheckConfigDTO findCheckConfig(){
		Optional<User> user = userRepository.findOneByLogin(SecurityUtils.getCurrentUser().getUsername());

		CheckConfig checkConfig = checkConfigRepository.findOne(user.get().getId());
		if(checkConfig ==null){
			checkConfig=new CheckConfig();
		}
		CheckConfigDTO checkConfigDTO=new CheckConfigDTO();
		
		BeanUtils.copyProperties(checkConfig, checkConfigDTO);
		checkConfigDTO.setNewPwd(checkConfig.getOaPwd());
		if(checkConfig.getStatus()==EStatus.disabled.ordinal()){
			checkConfigDTO.setStatus(EStatus.disabled);
		}else{
			checkConfigDTO.setStatus(EStatus.enabled);
		}
		//checkConfigDTO.setStatus(EStatus.disabled);
		return checkConfigDTO;
	}
	
	public void save(CheckConfig checkConfig) {
		 checkConfigRepository.save(checkConfig);
		
	}

	/**
	 * 签退成功或失败发送电子邮件
	 * @param checkConfig
	 */
	public void sendEmail(Long userId ,String result) {
		Optional<User> user = userRepository.findOneById(userId);
		mailService.sendCheckMail(user.get(),result);
	}
}
