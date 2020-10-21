package com.payro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payro.dto.PostDTO;
import com.payro.service.PostService;

@RestController
@RequestMapping("api/posts/")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity createPost(@RequestBody PostDTO postDTO) {
				postService.createPost(postDTO);
				return new ResponseEntity(HttpStatus.OK);
	}
	
}
