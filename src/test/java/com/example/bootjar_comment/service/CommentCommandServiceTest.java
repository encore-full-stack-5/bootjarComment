package com.example.bootjar_comment.service;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.dto.CommentDto;
import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.dto.UpdateCommentDto;
import com.example.bootjar_comment.repository.CommandRepository;
import com.example.bootjar_comment.repository.QueryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentCommandServiceTest {

    @InjectMocks
    private CommentCommandServiceImpl commentCommandService;
    @InjectMocks
    private CommentQueryServiceImpl commentQueryService;
    @Mock
    CommandRepository commandRepository;
    @Mock
    QueryRepository queryRepository;

    @Test
    void 댓글_조회 () {
        // given
        CommentDto commentDto = new CommentDto(1L, 1L, "Test comment", 1L, "별명", "image", LocalDateTime.now(), LocalDateTime.now());
        when(queryRepository.findByTodoId(1L)).thenReturn(Flux.just(commentDto));
        // whenll
        Flux<CommentDto> commentFlux = commentQueryService.getCommentList(1L);
        // then
        StepVerifier.create(commentFlux)
                .expectNextMatches(comment -> comment.getContent().equals("Test comment"))
                .verifyComplete();
    }

    @Test
    void 댓글_생성 () {
        // given
        CreateCommentDto commentDto = new CreateCommentDto(1L, 1L, "Test comment", LocalDateTime.now(), LocalDateTime.now());
        when(commandRepository.save(any(CommentCommand.class))).thenReturn(Mono.empty());
        // when
        Mono<Void> comment = commentCommandService.createComment(1L, commentDto).then();
        // then
        StepVerifier.create(comment)
                .expectComplete()
                .verify();
    }

    @Test
    void 댓글_수정 () {
        // given
        UpdateCommentDto commentDto = new UpdateCommentDto("Test comment Update");
        CommentCommand existingComment = CommentCommand.builder()
                .id(1L)
                .userId(1L)
                .todoId(1L)
                .content("Initial content")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        when(commandRepository.findById(1L)).thenReturn(Mono.just(existingComment));
        when(commandRepository.save(any(CommentCommand.class))).thenAnswer(invocation -> {
            CommentCommand updatedComment = invocation.getArgument(0);
            return Mono.just(updatedComment);
        });
        // when
        Mono<Void> updateComment = commentCommandService.updateComment(1L, commentDto.getContent());
        // then
        StepVerifier.create(updateComment)
                .expectComplete()
                .verify();
    }

    @Test
    void 댓글_삭제 () {
        // given
        CommentCommand comment = new CommentCommand(1L, 1L, 1L, "Test comment", LocalDateTime.now(), LocalDateTime.now());
        when(commandRepository.deleteById(1L)).thenReturn(Mono.empty());
        // when
        Mono<Void> deleteComment = commentCommandService.deleteComment(1L);
        // then
        StepVerifier.create(deleteComment)
                .verifyComplete();
    }
}