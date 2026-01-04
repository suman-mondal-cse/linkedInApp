package com.suman.linkedin.posts_service.service;

import com.suman.linkedin.posts_service.dto.PostCreateRequestDto;
import com.suman.linkedin.posts_service.dto.PostDto;
import com.suman.linkedin.posts_service.entity.PostEntity;
import com.suman.linkedin.posts_service.entity.PostLikeEntity;
import com.suman.linkedin.posts_service.exception.ResourceNotFoundException;
import com.suman.linkedin.posts_service.repository.PostsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PostsServiceImpl implements PostsService{

    private final PostsRepository postsRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostCreateRequestDto postCreateRequestDto, Long userId) {
        PostEntity post = modelMapper.map(postCreateRequestDto,PostEntity.class);
        post.setUserId(userId);
        PostEntity savedPost = postsRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        log.debug("Retriving post with ID: {}", postId);
       PostEntity postEntity = postsRepository.findById(postId)
               .orElseThrow(()->
                       new ResourceNotFoundException("post not found with id: "+ postId));

       return modelMapper.map(postEntity , PostDto.class);
    }

    @Override
    public List<PostDto> getAllPostsOfUser(Long userId) {
        List<PostEntity> allPosts = postsRepository.findByUserId(userId);
        return allPosts.stream().map(post -> modelMapper.map(post, PostDto.class)).toList();
    }
}
