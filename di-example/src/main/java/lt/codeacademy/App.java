package lt.codeacademy;

public class App {

	public static void main(String[] args) {
		final GradeService gradeService = new GradeService(new InternalMarksDao());
		System.out.println("Pazymiu vidurkis: " + gradeService.avarageGrade());
	}
}
