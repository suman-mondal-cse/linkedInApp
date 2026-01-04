package com.suman.linkedin.posts_service.repository;

import com.suman.linkedin.posts_service.entity.PostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PostLikeRepository extends JpaRepository<PostLikeEntity, Long> {
    boolean existsByUserIdAndPostId(Long userId, Long postID);

    @Transactional
    void deleteByUserIdAndPostId(Long userId, Long postId);
}