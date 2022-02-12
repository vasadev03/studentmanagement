package org.universal.studentmanagement.stuservice;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universal.studentmanagement.model.Student;
import org.universal.studentmanagement.studentrepo.StudentDAORepo;

@Service
public class StudentService {

	@Autowired
	StudentDAORepo studentRepo;

	public Student addStudent(Student employee) {
		try {
			List<Student> lstStudentList = studentRepo.listStudent;
			System.out.println(lstStudentList);
			lstStudentList.add(employee);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return employee;
	}

	public List<Student> getAllStudent() {
		return studentRepo.listStudent;
	}

	public List<Student> getStudentByName(String name) {
		return studentRepo.listStudent.stream().filter(e -> e.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}

	public String deleteStudent(String empName) {
		System.out.println(empName);
		try {
			Predicate<Student> condition = employee -> employee.getName().equalsIgnoreCase(empName.trim());

			studentRepo.listStudent.removeIf(condition);

			// lstEmployeeList.removeIf(e ->
			// e.getEmployeeName().equalsIgnoreCase(empName.trim()));
		} catch (Exception e) {
			return empName + " not found";
		}

		return empName + " deleted successfully";
	}

}