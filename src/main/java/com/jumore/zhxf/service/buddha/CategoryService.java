package com.jumore.zhxf.service.buddha;


import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumore.zhxf.domain.Category;
import com.jumore.zhxf.repository.CategoryRepository;

/**
 * 学佛 资讯查询
 */
@Service
@Transactional
public class CategoryService {

	
	@Inject
    private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public Page<Category> getCategoryByParentIdAndStatus(Long parentId,Integer status,PageRequest pageRequest) {
        return categoryRepository.findAllByParentIdAndStatus(parentId,status,pageRequest);
    }
	
	@Transactional(readOnly = true)
	public Page<Category> getCategoryByParentId(Long parentId,PageRequest pageRequest) {
        return categoryRepository.findAllByParentId(parentId,pageRequest);
    }
	
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}
}
