package com.InstaBlog.repository;

import com.InstaBlog.entity.Category;
import com.InstaBlog.entity.Post;
import com.InstaBlog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
