package com.iblogv.iblogvmanager.serviceimpl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iblogv.iblogvmanager.domain.Blog;
import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.exception.IblogvException;
import com.iblogv.iblogvmanager.model.BlogEntity;
import com.iblogv.iblogvmanager.model.UserEntity;
import com.iblogv.iblogvmanager.repository.BlogJpaRepository;
import com.iblogv.iblogvmanager.repository.UserJpaRepository;
import com.iblogv.iblogvmanager.service.BlogService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Amit Pandey
 *
 */
@Slf4j
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	UserJpaRepository userJpaRepository;

	@Autowired
	BlogJpaRepository blogJpaRepository;

	@Override
	public ResponseCode createBlog(Blog blog) throws IblogvException {

		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setBlogId("BG-".concat(UUID.randomUUID().toString()));
		blogEntity.setBlog(blog.getBlogContent());
		UserEntity userEntity = userJpaRepository.findUserById(blog.getUserId());
		
		if (userEntity == null) {
			log.debug("Error creating blog user does not exist ".concat(blog.getUserId()));
			throw new IblogvException("IM-400", "User does not exist ".concat(blog.getUserId()));
		}

		blogEntity.setAuthorId(userEntity);
		blogEntity.setCreatedDate(new Date());
		blogEntity.setLastUpdateDate(new Date());
		blogJpaRepository.save(blogEntity);

		return new ResponseCode("IM-200", "Blog created successfuly");

	}

}
