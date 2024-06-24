package com.example.bootjar_comment.domain;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table("COMMENTS")
public class Comment {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "user_id")
    private Long userId;

    @Column(value = "todo_id")
    private Long todoId;

    @Column(value = "content")
    private String content;

    @CreatedDate
    @Column(value = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(value = "updated_at")
    private LocalDateTime updatedAt;

}
