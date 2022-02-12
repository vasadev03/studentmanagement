package org.universal.studentmanagement.stucontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.universal.studentmanagement.model.Student;
import org.universal.studentmanagement.stuservice.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService stuDAOService;

	@PostMapping("/new")
	public Student addStudent(@RequestBody Student student) {
		return stuDAOService.addStudent(student);
	}

	@GetMapping("/all")
	public List<Student> getAllStudent() {
		return stuDAOService.getAllStudent();
	}

	@GetMapping("/get/{name}")
	public List<Student> getStudentByName(@PathVariable("name") String name) {
		return stuDAOService.getStudentByName(name);
	}

	@DeleteMapping("/delete/{name}")
	public String deleteStudent(@PathVariable("name") String empName) {
		return stuDAOService.deleteStudent(empName);
	}

}
