package com.jumore.zhxf.front.rest;

import java.net.URISyntaxException;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.jumore.zhxf.domain.Regist;
import com.jumore.zhxf.repository.RegistRepository;
import com.jumore.zhxf.service.buddha.RegistService;
import com.jumore.zhxf.service.dto.RegistDTO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * REST controller for managing Regist.
 */
@RestController
@RequestMapping("/api/front")
public class RegistRest {

    private final Logger log = LoggerFactory.getLogger(RegistRest.class);
        
    
    @Inject
    private RegistService registService;
    
    @Inject
    private RegistRepository registRepository;
    
    

    /**
	 * GET /regists/:id : get the "id" regist.
	 *
	 * @param id
	 *            the id of the registDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         registDTO, or with status 404 (Not Found)
	 */
	@PostMapping("/regist")
	@Timed
	@ApiOperation(value="活动报名", notes="单个活动报名")
	@ApiImplicitParams({
	        @ApiImplicitParam(name = "userId", value = "用户",  paramType = "body", dataType = "int"),
	        @ApiImplicitParam(name = "personName", value = "姓名",  paramType = "body", dataType = "String"),
	        @ApiImplicitParam(name = "eventId", value = "活动id",  paramType = "body", dataType = "int"),
	        @ApiImplicitParam(name = "persionMobile", value = "手机号", paramType = "body", dataType = "String"),
	        @ApiImplicitParam(name = "targetNum", value = "发愿数量",  paramType = "body", dataType = "Long"),
	        @ApiImplicitParam(name = "remark", value = "备注",  paramType = "body", dataType = "String")
	})
	public ResponseEntity<RegistDTO> appendRegist(@RequestBody RegistDTO registDTO)	throws URISyntaxException {
		log.debug("REST request to get Regist : {}", registDTO);
		//Regist regist = registRepository.findOne(id);
		//registDTO =registService.regist(registDTO);
		registDTO =registService.regist(registDTO);
		 //同时启动1000个线程，去进行i++计算，看看实际结果  
		/*CountDownLatch c = new CountDownLatch(1);
        for (int i = 0; i < 20; i++) {  
            new Thread(new Runnable() {  
                @Override  
                public void run() { 
                	try {
						c.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                	registService.regist(registDTO);  
                }  
            }).start();  
        }  
        c.countDown();*/
		
		
		return Optional.ofNullable(registDTO).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	


	@GetMapping("/regist")
	@Timed
	public ResponseEntity<Regist> getRegist()	throws URISyntaxException {
		log.debug("REST request to get Regist : {}");
		//Regist regist = registRepository.findOne(id);
		Regist r  =registRepository.findOne(1L);
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

}
