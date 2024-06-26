package com.example.bootjar_comment.controller;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.dto.UpdateCommentDto;
import com.example.bootjar_comment.global.CreateCommandHandler;
import com.example.bootjar_comment.global.DeleteCommandHandler;
import com.example.bootjar_comment.global.QueryHandler;
import com.example.bootjar_comment.global.UpdateCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class CommentController {

    private final CreateCommandHandler commandHandler;
    private final QueryHandler queryHandler;
    private final UpdateCommandHandler updateCommandHandler;
    private final DeleteCommandHandler deleteCommandHandler;

    @GetMapping("/{todoId}/comments")
    public Flux<CommentCommand> getComments(
            @PathVariable Long todoId
    ) {
        return queryHandler.getComments(todoId);
    }

    @PostMapping("/{todoId}/comments")
    public Mono<Comment> createComment(
            @PathVariable Long todoId,
            @RequestBody CreateCommentDto commentDto
    ) {
        return commandHandler.createHandle(todoId, commentDto);
    }

    @PutMapping("/{todoId}/comments/{commentId}")
    public Mono<Void> updateComment(
            @PathVariable Long commentId,
            @RequestBody UpdateCommentDto comment
    ) {
        return updateCommandHandler.updateHandle(commentId, comment.getContent());
    }

    @DeleteMapping("/{todoId}/comments/{commentId}")
    public Mono<Void> deleteComment(
            @PathVariable Long commentId
    ) {
        return deleteCommandHandler.deleteHandle(commentId);
    }

}
