package me.doyoung.practice.demopracticerestapi.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class EventDto {

    @NotEmpty
    private String name;        // 경매 이름

    @NotEmpty
    private String description; // 경매에 대한 설명

    @NotNull
    private LocalDateTime beginEnrollmentDateTime;      // 경매 등록 날짜

    @NotNull
    private LocalDateTime closeEnrollmentDateTime;      // 경매 종료 날짜

    @NotNull
    private LocalDateTime beginEventDateTime;   // 경매 시작

    @NotNull
    private LocalDateTime endEventDateTime;     // 경매 종료
    private String location;            // 경매 장소 (if location == null then (online))

    @Min(0)
    private int basePrice;              // 최소 가격

    @Min(0)
    private int maxPrice;               // 최대 가격 (경매가가 최대 가격과 같으면 바로 낙찰)

    @Min(0)
    private int limitOfEnrollment;      // 최대 등록 횟수
}
