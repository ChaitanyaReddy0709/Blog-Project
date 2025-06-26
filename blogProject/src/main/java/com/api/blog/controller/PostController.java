package com.api.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.blog.model.Comment;
import com.api.blog.model.PostModel;
import com.api.blog.service.CommentService;
import com.api.blog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<PostModel> createPost(@RequestBody PostModel postModel , @RequestParam Long userId) {
		return ResponseEntity.ok
				(postService.createPost(postModel, userId));	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostModel> updatePost(@PathVariable Long id , @RequestBody PostModel postDetails ){
		return ResponseEntity.ok
				(postService.updatePost(id , postDetails));
	}
	
	@GetMapping
	public ResponseEntity <List<PostModel>> getPublishedPosts(
			@RequestParam(required = false) String tag){
		return ResponseEntity.ok
				(postService.getPublishedByPosts(tag));
	}
	
	@Autowired 
	private CommentService commentService;
	@GetMapping("/{id}")
	public ResponseEntity<Map<String ,Object>> getPostWithComments(
			@PathVariable Long id ){
		PostModel postModel = postService.getPostById(id);
		List<Comment> comment = commentService.getCommentsByPost(id);
		Map<String , Object> response = new HashMap<>();
		response.put("post", postModel);
		response.put("comments", comment);
		return ResponseEntity.ok(response);
	}
}
