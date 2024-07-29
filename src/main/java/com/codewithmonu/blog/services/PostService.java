package com.codewithmonu.blog.services;

import java.util.List;

import com.codewithmonu.blog.entities.Post;
import com.codewithmonu.blog.payloads.PostDto;

public interface PostService {
	
	//Create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete 
	void deletePost(Integer postId);
	
	//get all posts
	List<PostDto>getAllPost();
	
	//get single posts
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<Post>getPostByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto>getPostByUser(Integer userId);
	
	//search posts
	List<PostDto> searchPosts(String keywords); 

	
}
