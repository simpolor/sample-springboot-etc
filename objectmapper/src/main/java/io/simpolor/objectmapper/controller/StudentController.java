package io.simpolor.objectmapper.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.simpolor.objectmapper.model.ResultDto;
import io.simpolor.objectmapper.model.StudentDto;
import io.simpolor.objectmapper.repository.entity.Student;
import io.simpolor.objectmapper.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	ObjectMapper objectMapper;

	@PostConstruct
	public void init(){
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@RequestMapping(value="", method= RequestMethod.GET)
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
	public ResultDto register(String request) throws JsonProcessingException {

		StudentDto studentDto = objectMapper.readValue(request, StudentDto.class);
		Student student = studentService.create(studentDto.toEntity());

		return ResultDto.builder()
				.id(student.getStudentId())
				.build();
	}

	@RequestMapping(value="/{studentId}", method=RequestMethod.PUT)
	public void modify(@PathVariable Long studentId,
					   String request) throws JsonProcessingException {

		StudentDto studentDto = objectMapper.readValue(request, StudentDto.class);
		studentDto.setId(studentId);

		studentService.update(studentDto.toEntity());
	}

	@RequestMapping(value="/{studentId}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long studentId) {

		studentService.delete(studentId);
	}
}
