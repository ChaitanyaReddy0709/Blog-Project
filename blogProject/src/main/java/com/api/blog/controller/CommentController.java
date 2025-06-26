package com.api.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.blog.model.Comment;
import com.api.blog.service.CommentService;

@RestController
@RequestMapping("/api/posts")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/{id}/comments")
	public ResponseEntity<Comment> addComment(@PathVariable Long id ,
			@RequestParam Long userId , @RequestBody Map<String , String> payload){
		return ResponseEntity.ok
				(commentService.addComment(id , userId, payload.get("text")));
	}
}
