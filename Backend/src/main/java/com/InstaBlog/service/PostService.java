package com.InstaBlog.service;

import com.InstaBlog.entity.Post;
import com.InstaBlog.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    Post updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    List<Post> getAllPosts();
    Post getPostById(Integer postId);
    List<PostDto> getPostsByCategory(Integer categoryId);
    List<PostDto> getPostsByUser(Integer userId);
    List<Post> searchPost(String keyword);

}
