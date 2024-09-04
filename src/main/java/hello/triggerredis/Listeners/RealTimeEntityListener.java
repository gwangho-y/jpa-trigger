package hello.triggerredis.Listeners;

import hello.triggerredis.enticy.RealtimeEntity;
import hello.triggerredis.repository.RealTimeEntityRepository;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static hello.triggerredis.common.Constant.testGameName;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : RealTimeEntityListener
 * author         : 이광호
 * date           : 2024-09-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-09-04        이광호       최초 생성
 */
@Component
@Slf4j
public class RealTimeEntityListener {


    @Lazy
    @Autowired
    private RealTimeEntityRepository repository;

    @PrePersist
    public void prePersist(RealtimeEntity realtimeEntity) {
        log.info("prePersist : {}", repository);
        log.info("realtimeEntity : {}", realtimeEntity.getId());
        realtimeEntity.setGameName(testGameName);
    }

    @PostPersist
    public void postPersist(RealtimeEntity realtimeEntity) {
        log.info("PostPersist : {}", repository);
        log.info("realtimeEntity : {}", realtimeEntity.getId());
    }


}
