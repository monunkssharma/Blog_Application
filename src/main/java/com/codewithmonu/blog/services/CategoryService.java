package com.codewithmonu.blog.services;

import java.util.List;

import com.codewithmonu.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//Create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//Update 
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//Delete
	void deleteCategory(Integer categoryId);
	
	//Get
	CategoryDto getCategory(Integer categoryId);
	
	//GetAll
	List<CategoryDto>getCategory();

}
