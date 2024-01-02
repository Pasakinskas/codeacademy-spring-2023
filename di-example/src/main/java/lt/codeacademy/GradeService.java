package lt.codeacademy;

public class GradeService {

	private MarksDao marksDao = new InternalMarksDao();

	public Double avarageGrade() {
		double sum = 0.0;

		for (Integer grade: marksDao.getMarks()) {
			sum += grade;
		}

		return sum / marksDao.getMarks().size();
	}
}
