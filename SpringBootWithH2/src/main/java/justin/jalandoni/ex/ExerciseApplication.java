package justin.jalandoni.ex;

import justin.jalandoni.ex.controller.ControllerMarker;
import justin.jalandoni.ex.repository.RepositoryMarker;
import justin.jalandoni.ex.service.ServiceMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackageClasses = {ControllerMarker.class, ServiceMarker.class, RepositoryMarker.class})
@Configuration()
public class ExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

}
