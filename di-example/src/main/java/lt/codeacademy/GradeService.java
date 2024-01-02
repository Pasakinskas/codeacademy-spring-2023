package lt.codeacademy;

public class GradeService {

	private final MarksDao marksDao;

	public GradeService(MarksDao marksDao) {
		this.marksDao = marksDao;
	}

	public Double avarageGrade() {
		double sum = 0.0;

		for (Integer grade: marksDao.getMarks()) {
			sum += grade;
		}

		return sum / marksDao.getMarks().size();
	}
}
