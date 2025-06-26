package com.api.blog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.blog.model.Comment;
import com.api.blog.model.PostModel;
import com.api.blog.model.UserModel;
import com.api.blog.repositories.*;
import com.api.blog.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Comment addComment(Long postId, Long userId, String text) {
        PostModel postModel = postRepository.findById(postId).orElseThrow();
        UserModel userModel = userRepository.findById(userId).orElseThrow();
        Comment comment = new Comment();
        comment.setPostModel(postModel);
        comment.setUserModel(userModel);
        comment.setText(text);
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);  
    }
	
	public List<Comment> getCommentsByPost(Long id){
		PostModel postModel = postRepository.findById(id).orElseThrow();
		return commentRepository.findByPostModel(postModel);
	}

}
