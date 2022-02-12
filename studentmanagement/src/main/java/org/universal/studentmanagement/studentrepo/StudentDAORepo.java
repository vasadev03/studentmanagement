package org.universal.studentmanagement.studentrepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.universal.studentmanagement.model.Student;

@Repository
public class StudentDAORepo {

	public List<Student> listStudent = new ArrayList<Student>(
			Arrays.asList(new Student("JohnDurairaj", "English", "Male", "12-01-1978", "Chennai"),
					new Student("JackSparrow", "Maths", "Male", "15-01-1969", "US")));

	public List<Student> getStudents() {
		return listStudent;
	}

}
