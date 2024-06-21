package com.example.bootjar_comment.service;

import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.dto.UpdateCommentDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CommentCommandService {
    public Mono<Void> createComment(CreateCommentDto createCommentDto) {
    return null;
    }

    public Mono<Void> updateComment(UpdateCommentDto updateCommentDto) {
        return null;
    }

    public Mono<Void> deleteComment() {
        return null;
    }
}
