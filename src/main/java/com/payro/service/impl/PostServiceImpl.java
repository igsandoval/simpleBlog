package com.payro.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.payro.dto.PostDTO;
import com.payro.model.Post;
import com.payro.repository.PostRepository;
import com.payro.service.AuthService;
import com.payro.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private PostRepository postRepository;
	
	public void createPost(PostDTO postDTO) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());
		User username=	authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("No user logged in "));
		post.setUsername(username.getUsername());
		post.setCreateOn(Instant.now());
		postRepository.save(post);
	}

}
