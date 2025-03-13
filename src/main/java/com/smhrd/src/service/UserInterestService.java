package com.smhrd.src.service;

import com.smhrd.src.entity.UserInterest;
import com.smhrd.src.entity.UserInterestId;
import com.smhrd.src.repository.UserInterestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInterestService {

    private final UserInterestRepository userInterestRepository;

    /**
     * 관심 지원금 등록
     * @param userId   사용자 ID
     * @param grantId  지원금 ID
     * @param applEdDt 지원금 마감일 (String → LocalDate 변환)
     */
    @Transactional
    public void addInterest(String userId, String grantId, String applEdDt) {
        UserInterestId id = new UserInterestId(userId, grantId);

        // String → LocalDate 변환
        LocalDate parsedDate = LocalDate.parse(applEdDt, DateTimeFormatter.ISO_DATE);

        // 관심 등록 객체 생성 및 저장
        UserInterest interest = new UserInterest(id, parsedDate, true);
        userInterestRepository.save(interest);
    }

    /**
     * 관심 지원금 삭제 (사용자가 관심 등록 해제)
     * @param userId  사용자 ID
     * @param grantId 지원금 ID
     */
    @Transactional
    public void removeInterest(String userId, String grantId) {
        UserInterestId id = new UserInterestId(userId, grantId);
        userInterestRepository.deleteById(id);
    }

    /**
     * 특정 지원금이 관심 등록되어 있는지 확인
     * @param userId  사용자 ID
     * @param grantId 지원금 ID
     * @return 존재 여부 (true: 등록됨, false: 등록되지 않음)
     */
    public boolean isInterestRegistered(String userId, String grantId) {
        UserInterestId id = new UserInterestId(userId, grantId);
        return userInterestRepository.existsById(id);
    }

    /**
     * 특정 관심 지원금 정보 조회
     * @param userId  사용자 ID
     * @param grantId 지원금 ID
     * @return 관심 등록 정보 (Optional<UserInterest>)
     */
    public Optional<UserInterest> getInterest(String userId, String grantId) {
        UserInterestId id = new UserInterestId(userId, grantId);
        return userInterestRepository.findById(id);
    }
}
