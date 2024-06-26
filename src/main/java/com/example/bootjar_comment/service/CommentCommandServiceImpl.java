package com.example.bootjar_comment.service;

import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.dto.UserDto;
import com.example.bootjar_comment.repository.CommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentCommandServiceImpl implements CommentCommandService {
    private final CommandRepository commandRepository;

    @Override
    public Mono<Comment> createComment(Long todoId, CreateCommentDto commentDto, Long userId) {

        return commandRepository.findByTodoId(todoId)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("존재하지 않은 투두입니다.")))
                .flatMap(todo -> {
                    Comment comment = commentDto.toEntity(todoId, userId);
                    return commandRepository.save(comment);
                });
    }

    @Override
    public Mono<Void> updateComment(Long commentId, String content) {
        return commandRepository.findById(commentId)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("존재하지 않은 댓글입니다.")))
                .flatMap(comment -> {
                    comment.setContent(content);
                    comment.setUpdatedAt(LocalDateTime.now());
                    return commandRepository.save(comment).then();
                });
    }

    @Override
    public Mono<Void> deleteComment(Long commentId) {
        return commandRepository.deleteById(commentId);
    }

    // user-insert
    @Override
    public Mono<Void> processUserSignup(UserDto userDto) {
        return commandRepository.createByUserId(userDto.getUserId(), userDto.getNickname(), userDto.getImage());
    }
    // user-update
    @Override
    public Mono<Void> processUserUpdate(UserDto userDto) {
        return commandRepository.updateByUserId(userDto.getUserId(), userDto.getNickname(), userDto.getImage());
    }
    // user-delete
    @Override
    public Mono<Void> processUserDelete(Long userId) {
        return commandRepository.deleteByUserId(userId);
    }
    // todo-insert
    @Override
    public Mono<Void> processTodoInsert(Long todoId) {
        return commandRepository.createByTodoId(todoId);
    }
    // todo-delete
    @Override
    public Mono<Void> processTodoDelete(Long todoId) {
        return commandRepository.deleteByTodoId(todoId);
    }
}