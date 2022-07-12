package io.simpolor.springdoc.model;

import io.simpolor.springdoc.repository.entity.Student;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "학생 DTO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	@Schema(description = "학생 아이디")
	private Long id;

	@Schema(description = "학생 이름")
	private String name;

	@Schema(description = "학년",  defaultValue = "null", allowableValues = {"1", "2", "3"})
	private Integer grade;

	@Schema(description = "나이")
	private Integer age;

	@Schema(description = "취미")
	private List<String> hobbies;

	public Student toEntity(){

		Student student = new Student();
		student.setStudentId(this.id);
		student.setName(this.name);
		student.setGrade(this.grade);
		student.setAge(this.age);
		student.setHobbies(this.hobbies);

		return student;
	}

	public static StudentDto of(Student student){

		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getStudentId());
		studentDto.setName(student.getName());
		studentDto.setGrade(student.getGrade());
		studentDto.setAge(student.getAge());
		studentDto.setHobbies(student.getHobbies());

		return studentDto;
	}

	public static List<StudentDto> of(List<Student> students){

		return students.stream().map(StudentDto::of).collect(Collectors.toList());
	}

}
