package lt.codeacademy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

	private final MarksDao marksDao;

	public GradeService(@Qualifier("externalMarksDao") MarksDao marksDao) {
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
