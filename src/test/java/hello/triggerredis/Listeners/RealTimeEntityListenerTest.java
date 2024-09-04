package hello.triggerredis.Listeners;

import hello.triggerredis.enticy.RealtimeEntity;
import hello.triggerredis.repository.RealTimeEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static hello.triggerredis.common.Constant.testGameName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : RealTimeEntityListenerTest
 * author         : 이광호
 * date           : 2024-09-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-09-04        이광호       최초 생성
 */
@SpringBootTest
@Slf4j
class RealTimeEntityListenerTest {

    @Autowired
    RealTimeEntityRepository repository;


    @Test
    void postPersistTest() {
        RealtimeEntity realtimeEntity =
                new RealtimeEntity("2024", "1", "10", "경기명 없음");
        repository.save(realtimeEntity);


        log.info("실시간 중계 경기 명 : {}", realtimeEntity.getGameName());

        assertThat(realtimeEntity.getGameName()).isEqualTo(testGameName);

    }
}