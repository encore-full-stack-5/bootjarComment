package com.example.bootjar_comment.global;

import com.example.bootjar_comment.dto.UpdateCommentDto;
import com.example.bootjar_comment.service.CommentCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DeleteCommandHandler {
    private final CommentCommandService commentCommandService;

    public Mono<Void> deleteHandle(Long commentId){
        return commentCommandService.deleteComment(commentId);
    }

    // user-delete
    public Mono<Void> processUserDelete(Long userId) {
        return commentCommandService.processUserDelete(userId);
    }
    // todo-delete
    public Mono<Void> processTodoDelete(Long todoId) {
        return commentCommandService.processTodoDelete(todoId);
    }
}
