package lt.codeacademy;

import java.util.List;

public class ExternalMarksDao implements MarksDao {

	@Override
	public List<Integer> getMarks() {
		return List.of(2, 2, 2, 2, 5, 5);
	}
}
