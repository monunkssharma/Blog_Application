package com.codewithmonu.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithmonu.blog.entities.Category;
import com.codewithmonu.blog.entities.Post;
import com.codewithmonu.blog.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
  List<Post> findByUser(User user);
  List<Post> findByCategory(Category category);
}
