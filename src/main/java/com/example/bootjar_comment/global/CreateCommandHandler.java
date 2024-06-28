package com.example.bootjar_comment.global;

import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.dto.UserDto;
import com.example.bootjar_comment.service.CommentCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateCommandHandler {
    private final CommentCommandService commentCommandService;

    public Mono<Comment> createHandle(Long todoId, CreateCommentDto commentDto, Long userId){
        return commentCommandService.createComment(todoId, commentDto, userId);
    }

    // user-insert
    public Mono<Void> processUserSignup(UserDto userDto) {
        return commentCommandService.processUserSignup(userDto);
    }

    // todo-insert
    public Mono<Void> processTodoInsert(Long todoId) {
        return commentCommandService.processTodoInsert(todoId);
    }
}
