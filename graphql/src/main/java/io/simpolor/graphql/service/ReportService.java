package io.simpolor.graphql.service;

import io.simpolor.graphql.repository.ReportRepository;
import io.simpolor.graphql.repository.entity.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public Long getTotalCount() {

        return reportRepository.count();
    }

    public List<Report> getAll() {

        return reportRepository.findAll();
    }

    public Report get(Long reportId) {

        Optional<Report> optionalStudent = reportRepository.findById(reportId);
        if(!optionalStudent.isPresent()){
            throw new IllegalArgumentException("reportId : "+reportId);
        }

        return optionalStudent.get();
    }

    public Report create(Report report) {

        return reportRepository.save(report);
    }

    public Report update(Report report) {

        Optional<Report> optionalReportCard = reportRepository.findById(report.getReportId());
        if(!optionalReportCard.isPresent()){
            throw new IllegalArgumentException("reportId : "+report.getReportId());
        }

        return reportRepository.save(report);
    }

    public Long delete(Long reportId) {

        reportRepository.deleteById(reportId);

        return reportId;
    }

}
