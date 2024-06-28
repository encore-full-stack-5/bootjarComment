package com.example.bootjar_comment.service;

import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.dto.UserDto;
import reactor.core.publisher.Mono;

public interface CommentCommandService {
    Mono<Comment> createComment(Long todoId, CreateCommentDto commentDto, Long userId);
    Mono<Void> updateComment(Long commentId, String content);
    Mono<Void> deleteComment(Long commentId);
    // user-insert
    Mono<Void> processUserSignup(UserDto userDto);
    // user-update
    Mono<Void> processUserUpdate(UserDto userDto);
    // user-delete
    Mono<Void> processUserDelete(Long userId);
    // todo-insert
    Mono<Void> processTodoInsert(Long todoId);
    // todo-delete
    Mono<Void> processTodoDelete(Long todoId);
}
