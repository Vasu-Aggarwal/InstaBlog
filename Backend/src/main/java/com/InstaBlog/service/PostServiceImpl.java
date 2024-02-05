package com.InstaBlog.service;

import com.InstaBlog.entity.Category;
import com.InstaBlog.entity.Post;
import com.InstaBlog.entity.User;
import com.InstaBlog.exception.ResourceNotFoundException;
import com.InstaBlog.payload.PostDto;
import com.InstaBlog.repository.CategoryRepo;
import com.InstaBlog.repository.PostRepo;
import com.InstaBlog.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Post updatedPOst = this.postRepo.save(post);
        return this.modelMapper.map(updatedPOst, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPost =  this.postRepo.findAll();
        return allPost.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Integer postId) {
         Post post =  this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        List<Post> post = this.postRepo.findByCategory(cat);
        return post.stream().map((p -> this.modelMapper.map(p, PostDto.class))).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        List<Post> post = this.postRepo.findByUser(user);
        return post.stream().map((p -> this.modelMapper.map(p, PostDto.class))).collect(Collectors.toList());
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
