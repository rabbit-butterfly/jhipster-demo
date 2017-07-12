package com.jumore.zhxf.service.buddha;

import java.time.ZonedDateTime;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.News;
import com.jumore.zhxf.repository.NewsRepository;
import com.jumore.zhxf.service.dto.NewsDTO;
import com.jumore.zhxf.service.mapper.NewsMapper;

/**
 * 学佛 资讯查询
 */
@Service
@Transactional
public class NewsService {

	@Resource
	private NewsRepository newsRepository;

	@Inject
	private NewsMapper newsMapper;

	public Page<News> findByCategoryId(Long categoryId, PageRequest pageRequest) {
		if (categoryId != null) {
			return newsRepository.findByCategoryIdAndStatus(categoryId,1, pageRequest);
		} else {
			return newsRepository.findAllByStatus(1,pageRequest);
		}
	}

	public News save(NewsDTO newsDTO) {
		News news = newsMapper.newsDTOToNews(newsDTO);
		news.setCreatedTime(ZonedDateTime.now());
		news.setModifyTime(ZonedDateTime.now());
		news.setStatus(1);
		newsRepository.save(news);
		return news;
	}

	public News update(NewsDTO newsDTO) {
		News news = newsRepository.findOne(newsDTO.getId());
		if (StringUtils.isNotEmpty(newsDTO.getPicPath())) {
			news.picPath(newsDTO.getPicPath());
		}

		news.setTitle(newsDTO.getTitle());
		news.setSummary(newsDTO.getSummary());
		news.setContentUrl(newsDTO.getContentUrl());
		news.setModifyTime(ZonedDateTime.now());
		newsRepository.save(news);
		return news;
	}

	public void verify(NewsDTO newsDTO) {
		News news = newsRepository.findOne(newsDTO.getId());
		news.setStatus(newsDTO.getStatus());
		newsRepository.save(news);
	}

}
