package io.simpolor.graphql.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import io.simpolor.graphql.repository.entity.Report;
import io.simpolor.graphql.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportQuery implements GraphQLQueryResolver {

    private final ReportService reportService;

    public Long countReport(){

        return reportService.getTotalCount();
    }

    public Iterable<Report> getAllReport(){

        return reportService.getAll();
    }

    public Report getReport(Long reportId){

        return reportService.get(reportId);
    }

}
