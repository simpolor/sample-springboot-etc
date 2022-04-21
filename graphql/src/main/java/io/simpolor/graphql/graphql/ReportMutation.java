package io.simpolor.graphql.graphql;

import graphql.kickstart.tools.GraphQLMutationResolver;
import io.simpolor.graphql.repository.entity.Report;
import io.simpolor.graphql.repository.entity.Student;
import io.simpolor.graphql.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportMutation implements GraphQLMutationResolver {

    private final ReportService reportService;

    public Report createReport(Integer korean, Integer english, Integer math, Student student){

        Report report = new Report();
        report.setKorean(korean);
        report.setEnglish(english);
        report.setMath(math);
        report.setStudent(student);

        return reportService.create(report);
    }

    public Report updateReport(Report report){

        return reportService.update(report);
    }

    public Boolean deleteReport(Long reportId){

        reportService.delete(reportId);

        return true;
    }
}
