package io.simpolor.batch.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    @Primary // jobLauncherController에서 Initialize 하기 위한 애노테이션
    @Bean(name = "sampleJob")
    public Job sampleJob(Step sampleOneStep,
                         Step sampleTwoStep){

        return jobBuilderFactory.get("sampleJob")
                .start(sampleOneStep)
                .next(sampleTwoStep)
                .build();
    }

    @Bean(name = "sampleJob2")
    public Job sampleJob2(Step sampleOneStep){

        return jobBuilderFactory.get("sampleJob2")
                .start(sampleOneStep)
                .build();
    }

    @Bean(name = "sampleFlowJob")
    public Job sampleFlowJob(Step sampleTaskletStep){
        return jobBuilderFactory.get("sampleFlowJob")
                .flow(sampleTaskletStep)
                .build()
                .build();
    }

    @Bean(name = "shareJob")
    public Job shareJob(Step shareOneStep,
                        Step shareTwoStep){

        return jobBuilderFactory.get("shareJob")
                .start(shareOneStep)
                .next(shareTwoStep)
                .build();
    }

    @Bean(name = "deciderJob")
    public Job deciderJob(JobExecutionDecider oddDecider,
                          Step startStep,
                          Step evenStep,
                          Step oddStep) {

        return jobBuilderFactory.get("deciderJob")
                .start(startStep)
                .next(oddDecider) // 홀수 | 짝수 구분
                .from(oddDecider) // decider의 상태가
                    .on("ODD") // ODD라면
                    .to(oddStep) // oddStep로 간다.
                .from(oddDecider) // decider의 상태가
                    .on("EVEN") // ODD라면
                    .to(evenStep) // evenStep로 간다.
                .end() // builder 종료
                .build();
    }

    @Bean(name = "itemJob")
    public Job itemJob(Step itemStep) {

        return jobBuilderFactory.get("itemJob")
                .start(itemStep)
                .build();
    }

}
