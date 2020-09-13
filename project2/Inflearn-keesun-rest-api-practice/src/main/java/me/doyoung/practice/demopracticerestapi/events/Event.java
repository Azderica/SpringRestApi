package me.doyoung.practice.demopracticerestapi.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// 나중에 객체 간 연관관계를 지을 때 모든 필드를 equal(), hashcode()를 하면
// 코드 내에서 stack overflow가 발생할 수 있다.
// 따라서, id만 equal and hashcode를 하여 이를 방지한다.
@EqualsAndHashCode(of = "id")
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Integer id;            // 기본 키
    private String name;        // 경매 이름
    private String description; // 경매에 대한 설명
    private LocalDateTime beginEnrollmentDateTime;      // 경매 등록 날짜
    private LocalDateTime closeEnrollmentDateTime;      // 경매 종료 날짜
    private LocalDateTime beginEventDateTime;   // 경매 시작
    private LocalDateTime endEventDateTime;     // 경매 종료
    private String location;            // 경매 장소 (if location == null then (online))
    private int basePrice;              // 최소 가격
    private int maxPrice;               // 최대 가격 (경매가가 최대 가격과 같으면 바로 낙찰)
    private int limitOfEnrollment;      // 최대 등록 횟수
    private boolean free;               // 무료
    private boolean offline;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;    // 경매 물품에 대한 진행 상태(draft -> published -> begin_enrollment -> ..)

    public void update() {
        // Update Free
        if(this.basePrice == 0 && this.maxPrice == 0){
            this.free = true;
        } else {
            this.free = false;
        }

        // Update offline
        if(this.location == null || this.location.isBlank()) {
            this.offline = false;
        } else {
            this.offline = true;
        }
    }
}
