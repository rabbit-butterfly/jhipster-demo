package com.jumore.zhxf.service.oa;

import java.time.ZonedDateTime;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.User;
import com.jumore.zhxf.domain.oa.TakeVacation;
import com.jumore.zhxf.repository.UserRepository;
import com.jumore.zhxf.repository.oa.TakeVacationRepository;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class TakeVacationService {

	@Inject
	private TakeVacationRepository takeVacationRepository;
	@Inject
	private UserRepository userRepository;

	private final Logger log = LoggerFactory.getLogger(TakeVacationService.class);

	public TakeVacation create(TakeVacation takeVacation) {

		TakeVacation oldTakeVacation = findTakeVacationlByUserId(takeVacation.getUserId());

		if (oldTakeVacation == null) {
			takeVacationRepository.save(takeVacation);
		} else {
			log.error("Created Information for takeVacation: error", takeVacation);
			throw new RuntimeException("create object error ,object exists..");
		}

		log.debug("Created Information for takeVacation: {}", takeVacation);
		return takeVacation;
	}

	@Transactional(readOnly = true)
	public TakeVacation findTakeVacationlByUserId(Long userId) {
		TakeVacation takeVacation = takeVacationRepository.findOne(userId);
		return takeVacation;
	}

	@Transactional(readOnly = true)
	public void updateById4TakeVacation(String username, Integer timeLength) {
		Optional<User> user = userRepository.findOneByLogin(username);
		TakeVacation t = takeVacationRepository.findOneByUserId(user.get().getId());
		if (t.getUsable() < timeLength) {
			throw new RuntimeException("no userable time..");
		}
		int row = takeVacationRepository.update(-timeLength, 0, timeLength, t.getUserId());
		if (row == 0)
			throw new RuntimeException(" this user data error..");

	}

	@Transactional(readOnly = true)
	public void updateById4WorkOvertime(String username, Integer timeLength) {
		Optional<User> user = userRepository.findOneByLogin(username);
		//TakeVacation t = takeVacationRepository.findOneByUserId(user.get().getId());
		updateById4WorkOvertime(user.get().getId(),timeLength);

	}
	
	@Transactional(readOnly = true)
	public void updateById4WorkOvertime(Long  userId, Integer timeLength) {
		TakeVacation t = takeVacationRepository.findOneByUserId(userId);
		if (t == null) {
			t = new TakeVacation();
			t.setTotalHour(timeLength);
			t.setUsable(timeLength);
			t.setUserId(userId);
			t.setUsed(0);
			t.setCreatedBy(ZonedDateTime.now());
			t.setLastMidfyDate(ZonedDateTime.now());
			takeVacationRepository.save(t);
		} else {
			int row = takeVacationRepository.update(timeLength, timeLength, 0, userId);
			if (row == 0)
				throw new RuntimeException(" this user data error..");
		}

	}
	public Page<TakeVacation> findAll(Pageable pageable) {

		return takeVacationRepository.findAll(pageable);
	}
	
	public Page<TakeVacation> findByCreatedBy(String createdBy,Pageable pageable) {
		
		return takeVacationRepository.findByCreatedBy(createdBy,pageable);
	}
	public int checkUsableTimeByUserNmae(String username) {
		Optional<User> user = userRepository.findOneByLogin(username);
		TakeVacation t = takeVacationRepository.findOneByUserId(user.get().getId());
		if (t == null)
			return 0;
		return t.getUsable().intValue();
	}

	public TakeVacation findOneByLogin(String currentUserLogin) {
		Optional<User> user = userRepository.findOneByLogin(currentUserLogin);
		TakeVacation t = takeVacationRepository.findOneByUserId(user.get().getId());
		return t;
	}

	public TakeVacation findAllOne() {
		TakeVacation t = takeVacationRepository.findAllOne();
		return t;
	}
	
}
