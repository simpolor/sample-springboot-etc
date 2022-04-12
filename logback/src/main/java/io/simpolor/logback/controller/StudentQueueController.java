package io.simpolor.logback.controller;

import io.simpolor.logback.model.StudentDto;
import io.simpolor.logback.repository.entity.Student;
import io.simpolor.logback.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentQueueController {

	private static final Logger eventLog = LoggerFactory.getLogger("event-log");

	private final StudentService studentService;

	@PostMapping(value="/queue/{studentId}")
	public StudentDto queue(@PathVariable Long studentId) {

		Student student = studentService.get(studentId);
		eventLog.debug("Student queue: {}", student);

		return StudentDto.of(student);
	}
}
