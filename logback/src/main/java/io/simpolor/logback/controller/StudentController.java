package io.simpolor.logback.controller;

import io.simpolor.logback.component.SlackSender;
import io.simpolor.logback.model.ResultDto;
import io.simpolor.logback.model.StudentDto;
import io.simpolor.logback.repository.entity.Student;
import io.simpolor.logback.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {

	// private static final Logger eventLog = LoggerFactory.getLogger("event-log");
	private final StudentService studentService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<StudentDto> list() {

		List<Student> students = studentService.getAll();
		if(CollectionUtils.isEmpty(students)){
			return Collections.EMPTY_LIST;
		}

		return StudentDto.of(students);
	}

	@RequestMapping(value="/{studentId}", method=RequestMethod.GET)
	public StudentDto detail(@PathVariable Long studentId) {

		Student student = studentService.get(studentId);

		return StudentDto.of(student);
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResultDto register(@RequestBody StudentDto request) {

		Student student = studentService.create(request.toEntity());

		log.debug("register : {}", student.toString());

		return ResultDto.builder()
				.id(student.getStudentId())
				.build();
	}

	@RequestMapping(value="/{studentId}", method=RequestMethod.PUT)
	public void modify(@PathVariable Long studentId,
					   @RequestBody StudentDto request) {

		log.info("register : {}, {}", studentId, request.toString());

		request.setId(studentId);
		studentService.update(request.toEntity());
	}

	@RequestMapping(value="/{studentId}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long studentId) {

		studentService.delete(studentId);
	}

	/*@PostMapping(value="/queue/{studentId}")
	public StudentDto queue(@PathVariable Long studentId) {

		Student student = studentService.get(studentId);
		eventLog.debug("Student queue: {}", student);

		return StudentDto.of(student);
	}*/
}
