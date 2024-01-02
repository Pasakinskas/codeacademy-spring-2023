package lt.codeacademy;

import java.util.List;

public class InternalMarksDao implements MarksDao {

	@Override
	public List<Integer> getMarks() {
		return List.of(5, 8, 10, 8, 3, 5, 6, 7);
	}
}
