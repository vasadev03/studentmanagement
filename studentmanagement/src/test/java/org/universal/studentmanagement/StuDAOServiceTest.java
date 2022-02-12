package org.universal.studentmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.universal.studentmanagement.model.Student;
import org.universal.studentmanagement.studentrepo.StudentDAORepo;
import org.universal.studentmanagement.stuservice.StudentService;

@SpringBootTest
public class StuDAOServiceTest {

	@Autowired
	private StudentService stuService;

	@MockBean
	private StudentDAORepo studentRepo;

	@BeforeEach
	public void setUp() {
		List<Student> listStudent = new ArrayList<Student>(
				Arrays.asList(new Student("JohnDurairaj", "English", "Male", "12-01-1978", "Chennai"),
						new Student("JackSparrow", "Maths", "Male", "15-01-1969", "US")));
		Mockito.when(studentRepo.getStudents()).thenReturn(listStudent);
		studentRepo.listStudent=listStudent;
		//Mockito.
	}

	@Test
	public void checkNewUserAddedOrNot() {
		System.out.println("Entered into checkNewUserAddedOrNot");
		Student student = new Student("Vijay", "actor", "male", "21-08-1997", "Chennai");
		Student addedEmployee = stuService.addStudent(student);
		assertEquals(student.getName(), stuService.getStudentByName(addedEmployee.getName()).get(0).getName());
		System.out.println("Exited from checkNewUserAddedOrNot");
	}

	@Test
	public void checkStudentCount() {
		System.out.println("Entered into checkStudentCount");
		assertEquals(2, stuService.getAllStudent().size());
		System.out.println("Exited from checkStudentCount");
	}

	@Test
	public void checkGetStudentByName() {
		System.out.println("Entered into checkGetStudentName");
		String stuName = "JackSparrow";
		assertEquals(stuName, stuService.getStudentByName(stuName).get(0).getName());
		System.out.println("Exited from checkGetStudentName");
	}

	@Test
	public void checkDeleteStudentByName() {
		System.out.println("Entered into checkDeleteStudentByName");
		String empName = "JackSparrow";
		assertEquals(empName, stuService.getStudentByName(empName).get(0).getName());
		System.out.println("Exited from checkDeleteStudentByName");
	}
}
