package com.example.bootjar_comment.global;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.domain.User;
import com.example.bootjar_comment.dto.UserDto;
import com.example.bootjar_comment.service.CommentQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class QueryHandler {
    private final CommentQueryService commentQueryService;

    public Flux<CommentCommand> getComments(Long todoId) {
        return commentQueryService.getCommentList(todoId);
    }
}
