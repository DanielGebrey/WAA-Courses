package Lab1.Lab1;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Lab1.Lab1.repo.PostRepo;

@SpringBootApplication
public class Lab1Application {
	@Autowired
	private PostRepo postRepo;

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}

	@Bean
	public ModelMapper moduleMapper() {
		return new ModelMapper();
	}
}
