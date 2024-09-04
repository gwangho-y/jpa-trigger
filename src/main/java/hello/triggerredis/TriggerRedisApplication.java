package hello.triggerredis;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

import java.util.TimeZone;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(bootstrapMode = BootstrapMode.DEFERRED)

public class TriggerRedisApplication {

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        SpringApplication.run(TriggerRedisApplication.class, args);
    }

}
