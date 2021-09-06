package social.Network.projectsocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import social.Network.projectsocial.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ProjectsocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsocialApplication.class, args);
	}

}
