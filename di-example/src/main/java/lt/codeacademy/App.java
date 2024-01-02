package lt.codeacademy;

import lt.codeacademy.config.SpringContextConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
//		diExampleUsingSimpleJava();
		diExampleUsingSpringContext();
	}

	private static void diExampleUsingSpringContext() {
		ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringContextConfig.class);
		GradeService gradeService = springContext.getBean(GradeService.class);
		System.out.println("Vidurkis: " + gradeService.avarageGrade());
	}

	private static void diExampleUsingSimpleJava() {
		final GradeService gradeService = new GradeService(new ExternalMarksDao());
		System.out.println("Pazymiu vidurkis: " + gradeService.avarageGrade());
	}
}
