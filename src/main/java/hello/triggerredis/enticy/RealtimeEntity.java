package hello.triggerredis.enticy;

import hello.triggerredis.Listeners.RealTimeEntityListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : KovoRealsms
 * author         : 이광호
 * date           : 2024-09-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-09-04        이광호       최초 생성
 */
@Entity
@Getter
@EntityListeners(RealTimeEntityListener.class)
@NoArgsConstructor
public class RealtimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String season;

    private String gameNumber;

    private String teamCode;

    private String gameName;

    public RealtimeEntity(String season, String gameNumber, String teamCode, String gameName) {
        this.season = season;
        this.gameNumber = gameNumber;
        this.teamCode = teamCode;
        this.gameName = gameName;
    }


    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

}
