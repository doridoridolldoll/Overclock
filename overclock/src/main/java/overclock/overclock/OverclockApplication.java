package overclock.overclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OverclockApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverclockApplication.class, args);
	}

}
