package com.suman.linkedin.posts_service.controller;

import com.suman.linkedin.posts_service.service.PostLikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@AllArgsConstructor
public class LikesController {
    private final PostLikeService postLikeService;

    //Like a post with PostId and UserId
    @PostMapping("/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable Long postId){
        postLikeService.likePost(1L, postId);
        return ResponseEntity.noContent().build();
    }

    //Unlike a post with UserId and PostId which is already liked
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> unlikePost(@PathVariable Long postId){
        postLikeService.unLikePost(1L, postId);
        return ResponseEntity.noContent().build();
    }
}
