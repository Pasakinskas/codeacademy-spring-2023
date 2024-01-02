package lt.codeacademy.config;

import lt.codeacademy.GradeService;
import lt.codeacademy.InternalMarksDao;
import lt.codeacademy.MarksDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringContextConfig {

	@Bean
	public MarksDao getMarksDao() {
		return new InternalMarksDao();
	}

	@Bean
	public GradeService getGradeService() {
		return new GradeService(this.getMarksDao());
	}
}
