package lt.codeacademy;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ExternalMarksDao implements MarksDao {

	@Override
	public List<Integer> getMarks() {
		return List.of(2, 2, 2, 2, 5, 5);
	}
}
