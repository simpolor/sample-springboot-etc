package io.simpolor.batch.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JobLauncherController {

    private final ApplicationContext applicationContext;
    private final JobLauncher jobLauncher;

    @GetMapping("/job/launcher")
    public String handle(@RequestParam("name") String name) {

        try {
            /**
             * Job에 값을 넘길때 JobParameters를 사용
             * key와 Job의 파라미터가 동일해야함
             */
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("requestDate", System.currentTimeMillis())
                    .toJobParameters();

            if(Objects.nonNull(name)){
                Job executeJob = applicationContext.getBean(name, Job.class);
                System.out.println("executeJob : "+executeJob);
                if(Objects.nonNull(executeJob)){
                    jobLauncher.run(executeJob, jobParameters);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Done";
    }

}
