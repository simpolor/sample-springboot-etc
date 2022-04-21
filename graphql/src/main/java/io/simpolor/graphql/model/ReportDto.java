package io.simpolor.graphql.model;

import io.simpolor.graphql.repository.entity.Report;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Setter
@Getter
public class ReportDto {

	private Long id;
	private Integer korean;
	private Integer english;
	private Integer math;
	private StudentDto student;

	public Report toEntity(){

		Report report = new Report();
		report.setReportId(this.getId());
		report.setKorean(this.korean);
		report.setEnglish(this.english);
		report.setMath(this.math);
		report.setStudent(this.student.toEntity());

		return report;
	}

	public static ReportDto of(Report report){

		ReportDto reportDto = new ReportDto();
		reportDto.setId(report.getReportId());
		reportDto.setKorean(report.getKorean());
		reportDto.setEnglish(report.getEnglish());
		reportDto.setMath(report.getMath());

		if(Objects.nonNull(report.getStudent())){
			reportDto.setStudent(StudentDto.of(report.getStudent()));
		}

		return reportDto;
	}

	public static List<ReportDto> of(List<Report> reports){

		return reports.stream()
				.map(ReportDto::of)
				.collect(Collectors.toList());
	}


}
