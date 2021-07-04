package cleiton.duarte.api.person;

import cleiton.duarte.api.person.domain.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ApiPersonApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiPersonApplication.class, args);
	}

}
