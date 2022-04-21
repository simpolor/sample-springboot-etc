package io.simpolor.graphql.controller;

import io.simpolor.graphql.model.StudentDto;
import io.simpolor.graphql.repository.entity.Student;
import io.simpolor.graphql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@GetMapping
	public List<StudentDto> list() {

		return StudentDto.of(studentService.getAll());
	}

	@GetMapping(value="/{studentId}")
	public StudentDto detail(@PathVariable Long studentId) {

		Student student = studentService.get(studentId);

		return StudentDto.of(student);
	}

	@PostMapping
	public void register(@RequestBody StudentDto request) {

		studentService.create(request.toEntity());
	}

	@PutMapping(value="/{studentId}")
	public void modify(@PathVariable Long studentId,
					   @RequestBody StudentDto request) {

		request.setId(studentId);
		studentService.update(request.toEntity());
	}

	@DeleteMapping(value="/{studentId}")
	public void delete(@PathVariable Long studentId) {

		studentService.delete(studentId);
	}

}
