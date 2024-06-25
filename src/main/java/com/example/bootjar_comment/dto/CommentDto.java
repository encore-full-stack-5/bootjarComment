package com.example.bootjar_comment.dto;

import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private String content;
    private Long userId;
    private String nickname;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommentDto from(Comment comment, User user) {
        return CommentDto.builder()
                .content(comment.getContent())
                .userId(user.getId())
                .nickname(user.getNickname())
                .image(user.getImage())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
