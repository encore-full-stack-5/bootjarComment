package com.example.bootjar_comment.service;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.dto.CommentDto;
import reactor.core.publisher.Flux;

public interface CommentQueryService {
    Flux<CommentDto> getCommentList(Long todoId);
}