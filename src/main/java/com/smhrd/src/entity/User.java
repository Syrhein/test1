package com.smhrd.src.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "TB_USER")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "USER_PW", nullable = false)
    private String userPw;

    @Column(name = "USER_EMAIL", nullable = false)
    private String userEmail;

    @Column(name = "USER_NICKNAME", nullable = false)
    private String userNickname;

    @Column(name = "USER_BIRTH", nullable = false)
    private LocalDate userBirth;

    @Column(name = "USER_GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender userGender;

    @Column(name = "USER_LOCATE", nullable = false)
    private String userLocate;

    @Column(name = "KAKAO_ID")
    private Long kakaoId;

    @Column(name = "USER_CROP")
    private String userCrop;

    @Column(name = "JOINED_AT", nullable = false, updatable = false)
    private LocalDate joinedAt = LocalDate.now();

    public enum Gender {
        M, F
    }
}
