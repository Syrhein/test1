package com.smhrd.src.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER_INTEREST")
@Getter
@Setter
@NoArgsConstructor
public class UserInterest {

    @EmbeddedId
    private UserInterestId id;

    @Column(name = "APPL_ED_DT", nullable = false)
    private LocalDate applEdDt;  // ✅ `String` → `LocalDate`로 변경

    @Column(name = "ALARM_ENABLED", nullable = false)
    private boolean alarmEnabled = true;

    @Column(name = "ADDED_AT", nullable = false, updatable = false)
    private LocalDateTime addedAt = LocalDateTime.now();

    // ✅ 필요한 필드만 받는 생성자 추가
    public UserInterest(UserInterestId id, LocalDate applEdDt, boolean alarmEnabled) {
        this.id = id;
        this.applEdDt = applEdDt;
        this.alarmEnabled = alarmEnabled;
        this.addedAt = LocalDateTime.now();  // 자동으로 현재 시간 설정
    }
}
