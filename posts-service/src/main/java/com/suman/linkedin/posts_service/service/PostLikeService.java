package com.suman.linkedin.posts_service.service;

public interface PostLikeService {
    void likePost(Long userId, Long postId);
    void unLikePost(Long userId, Long postId);
}
