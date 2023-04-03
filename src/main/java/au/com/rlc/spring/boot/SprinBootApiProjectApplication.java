package au.com.rlc.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SprinBootApiProjectApplication {
	private static final Logger logger = LoggerFactory.getLogger(SprinBootApiProjectApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SprinBootApiProjectApplication.class, args);
	}

}
