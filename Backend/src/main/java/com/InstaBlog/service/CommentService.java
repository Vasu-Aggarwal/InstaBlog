package com.InstaBlog.service;

import com.InstaBlog.payload.CommentDto;
import com.InstaBlog.service.impl.CommentServiceImpl;
import org.springframework.stereotype.Service;

public interface CommentService{
    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
}
