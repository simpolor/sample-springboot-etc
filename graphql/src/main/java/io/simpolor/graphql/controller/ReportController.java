package io.simpolor.graphql.controller;

import io.simpolor.graphql.model.ReportDto;
import io.simpolor.graphql.repository.entity.Report;
import io.simpolor.graphql.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/reports")
@RequiredArgsConstructor
public class ReportController {

	private final ReportService reportService;

	@GetMapping(value="/total-count")
	public Long totalCount() {

		return reportService.getTotalCount();
	}

	@GetMapping
	public List<ReportDto> list() {

		List<Report> reports = reportService.getAll();
		if(CollectionUtils.isEmpty(reports)){
			return Collections.EMPTY_LIST;
		}

		return ReportDto.of(reports);
	}

	@GetMapping(value="/{reportId}")
	public ReportDto detail(@PathVariable Long reportId) {

		Report report = reportService.get(reportId);

		return ReportDto.of(report);
	}

	@PostMapping
	public void register(@RequestBody ReportDto request) {

		reportService.create(request.toEntity());
	}

	@PutMapping(value="/{reportId}")
	public void modify(@PathVariable Long reportId,
					   @RequestBody ReportDto request) {

		request.setId(reportId);
		reportService.update(request.toEntity());
	}

	@DeleteMapping(value="/{reportId}")
	public void delete(@PathVariable Long reportId) {

		reportService.delete(reportId);
	}

}
