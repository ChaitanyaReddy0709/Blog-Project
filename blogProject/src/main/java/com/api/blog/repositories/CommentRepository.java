package com.api.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.model.Comment;
import com.api.blog.model.PostModel;

public interface CommentRepository extends JpaRepository<Comment ,Long> {
	List<Comment> findByPostModel(PostModel postModel);

}
