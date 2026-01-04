package com.suman.linkedin.posts_service.controller;

import com.suman.linkedin.posts_service.dto.PostCreateRequestDto;
import com.suman.linkedin.posts_service.dto.PostDto;
import com.suman.linkedin.posts_service.entity.PostEntity;
import com.suman.linkedin.posts_service.service.PostsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;
    private final ModelMapper modelMapper;

    //Create a post
    @PostMapping
    public ResponseEntity<@NonNull PostDto> createPost(@RequestBody PostCreateRequestDto postCreateRequestDto, HttpServletRequest httpServletRequest){
        PostDto createdPost = postsService.createPost(postCreateRequestDto, 1L);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    //Get post by ID
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId) {
        PostDto postDto = postsService.getPostById(postId);
        return ResponseEntity.ok(postDto);
    }

    // Get all post of a user
    @GetMapping("/users/{userId}/allPosts")
    public ResponseEntity<List<PostDto>> getAllPostsOfUser(@PathVariable Long userId){
        List<PostDto> allPostsOfUser = postsService.getAllPostsOfUser(userId);
        return ResponseEntity.ok(allPostsOfUser);
    }

}
