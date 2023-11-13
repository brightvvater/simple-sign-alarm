package bitedu.bipa.simplesignalarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@EnableScheduling
@SpringBootApplication
public class SimplesignalarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplesignalarmApplication.class, args);
	}

}
