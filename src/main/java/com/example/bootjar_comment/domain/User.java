package com.example.bootjar_comment.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("USERS")
public class User {
    @Id
    @Column(value = "user_id")
    private Long id;

    @Column(value = "user_nickname")
    private String nickname;

    @Column(value = "user_image")
    private String image;

}
