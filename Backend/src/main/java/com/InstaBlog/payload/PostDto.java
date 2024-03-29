package com.InstaBlog.payload;

import com.InstaBlog.entity.Category;
import com.InstaBlog.entity.Comment;
import com.InstaBlog.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class PostDto {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private List<CommentDto> comments = new ArrayList<>();
}
