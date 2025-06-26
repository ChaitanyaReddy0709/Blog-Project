package com.api.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.model.PostModel;

public interface PostRepository extends JpaRepository<PostModel , Long > {
	List<PostModel> findByStatus(String status);
	List<PostModel> findByStatusAndTagsContaining(String status , String tag);

}
