package io.simpolor.springdoc.controller;

import io.simpolor.springdoc.model.ResultDto;
import io.simpolor.springdoc.model.StudentDto;
import io.simpolor.springdoc.repository.entity.Student;
import io.simpolor.springdoc.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Tag(name = "/students", description = "학생 API")
@Slf4j
@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@Operation(summary = "학생 목록 조회", description = "학생 목록을 조회합니다.", responses = {
		@ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
		@ApiResponse(responseCode = "404", description = "Not found", content = @Content),
		@ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true)))
	})
	@Parameters({
			@Parameter(name="Authorization", description="인증 헤더값", example="bearer {accessToken}", in= ParameterIn.HEADER, required=true)
	})
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<StudentDto> list() {

		List<Student> students = studentService.getAll();
		if(CollectionUtils.isEmpty(students)){
			return Collections.EMPTY_LIST;
		}

		return StudentDto.of(students);
	}

	@Operation(summary = "학생 상세 조회", description = "학생을 상세 조회합니다.")
	@RequestMapping(value="/{studentId}", method=RequestMethod.GET)
	public StudentDto detail(@PathVariable Long studentId) {

		Student student = studentService.get(studentId);

		return StudentDto.of(student);
	}

	@Operation(summary = "학생 등록", description = "학생을 등록합니다.")
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResultDto register(@ParameterObject @RequestBody StudentDto request)  {

		Student student = studentService.create(request.toEntity());

		return ResultDto.builder()
				.id(student.getStudentId())
				.build();
	}

	@Operation(summary = "학생 수정", description = "학생을 수정합니다.")
	@RequestMapping(value="/{studentId}", method=RequestMethod.PUT)
	public void modify(@PathVariable Long studentId,
					   @ParameterObject @RequestBody StudentDto request){

		request.setId(studentId);
		studentService.update(request.toEntity());
	}

	@Operation(summary = "학생 삭제", description = "학생을 삭제합니다..")
	@RequestMapping(value="/{studentId}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long studentId) {

		studentService.delete(studentId);
	}
}
