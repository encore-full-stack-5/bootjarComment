package com.example.bootjar_comment.service;

import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.dto.CreateCommentDto;
import reactor.core.publisher.Mono;

public interface CommentCommandService {
    Mono<Comment> createComment(Long todoId, CreateCommentDto commentDto);
    Mono<Void> updateComment(Long commentId, String content);
    Mono<Void> deleteComment(Long commentId);
}
