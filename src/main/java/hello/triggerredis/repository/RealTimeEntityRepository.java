package hello.triggerredis.repository;

import hello.triggerredis.enticy.RealtimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : RealTimeEntityRepository
 * author         : 이광호
 * date           : 2024-09-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-09-04        이광호       최초 생성
 */
public interface RealTimeEntityRepository extends JpaRepository<RealtimeEntity, Long> {
}
