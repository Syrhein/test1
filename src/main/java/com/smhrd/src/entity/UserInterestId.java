package com.smhrd.src.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UserInterestId implements Serializable {

    private String userId;
    private String grantId;

    public UserInterestId(String userId, String grantId) {
        this.userId = userId;
        this.grantId = grantId;
    }
}
