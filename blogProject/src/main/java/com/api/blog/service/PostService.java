package com.api.blog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.blog.model.PostModel;
import com.api.blog.model.UserModel;
import com.api.blog.repositories.PostRepository;
import com.api.blog.repositories.UserRepository;

@Service

public class PostService {
	
	@Autowired 
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public PostModel createPost(PostModel postModel,  Long userId) {
		UserModel userModel = userRepository.findById(userId).orElseThrow();
		postModel.setUserModel(userModel);
		postModel.setCreatedAt(LocalDateTime.now());
		postModel.setStatus("Draft");
		return postRepository.save(postModel);	
	}
	
	public PostModel updatePost(Long id ,PostModel postDetails) {
		PostModel postModel = postRepository.findById(id).orElseThrow();
		postModel.setTitle(postDetails.getTitle());
		postModel.setContent(postDetails.getContent());
		postModel.setStatus(postDetails.getStatus());
		postModel.setUpdatedAt(LocalDateTime.now());
		return postRepository.save(postModel);
	}
	
	public List<PostModel> getPublishedByPosts(String tag){
		return tag != null ? postRepository.findByStatusAndTagsContaining("Published" , tag)
						   : postRepository.findByStatus("Published");		
	}
	
	public PostModel getPostById(Long id) {
		return postRepository.findById(id).orElseThrow();
	}
}
