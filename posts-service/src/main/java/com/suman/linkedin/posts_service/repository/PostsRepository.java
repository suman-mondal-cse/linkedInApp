package com.suman.linkedin.posts_service.repository;

import com.suman.linkedin.posts_service.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<PostEntity,Long> {
    List<PostEntity> findByUserId(Long userId);
}
