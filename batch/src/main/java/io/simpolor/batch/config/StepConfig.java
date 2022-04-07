package io.simpolor.batch.config;

import io.simpolor.batch.domain.Item;
import io.simpolor.batch.tasklet.SampleOneTasklet;
import io.simpolor.batch.tasklet.SampleTwoTasklet;
import io.simpolor.batch.tasklet.ShareOneTasklet;
import io.simpolor.batch.tasklet.ShareTwoTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Step 구현은 Tasklet 혹은 Reader, Processor, Writer로 구성
 *
 * @JobScope는 Step 선언문에서만 사용이 가능하고,
 * @StepScope는 Step을 구성하는 ItemReader, ItemProcessor, ItemWriter에서 사용 가능
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class StepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public static final int CHUNK_SIZE = 10;

    @Bean
    @JobScope
    public Step sampleOneStep(){

        return stepBuilderFactory.get("sampleOneStep")
                .tasklet(new SampleOneTasklet())
                .build();
    }

    @Bean
    @JobScope
    public Step sampleTwoStep(@Value("#{jobParameters[requestDate]}") Long time){

        log.info("sampleTwoStep run : {}", time);

        return stepBuilderFactory.get("SampleTwoTasklet")
                .tasklet(new SampleTwoTasklet())
                .build();
    }

    @Bean
    @JobScope
    public Step sampleTaskletStep(){

        log.info("sampleTaskletStep run");

        return stepBuilderFactory.get("sampleTaskletStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("SampleTaskletStep run");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    @JobScope
    public Step shareOneStep(){

        log.info("shareOneStep run");

        return stepBuilderFactory.get("shareOneStep")
                .tasklet(new ShareOneTasklet())
                .build();
    }

    @Bean
    @JobScope
    public Step shareTwoStep(){

        log.info("shareTwoStep run");

        return stepBuilderFactory.get("shareTwoStep")
                .tasklet(new ShareTwoTasklet())
                .build();
    }


    @Bean
    @JobScope
    public Step startStep() {

        log.info("startStep run");

        return stepBuilderFactory.get("startStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("startStep run");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    @JobScope
    public Step evenStep() {

        log.info("evenStep run");

        return stepBuilderFactory.get("evenStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("evenStep run");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    @JobScope
    public Step oddStep() {

        log.info("oddStep run");

        return stepBuilderFactory.get("oddStep")
                .tasklet((contribution, chunkContext) -> {
                    log.info("oddStep run");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    @JobScope
    public Step itemStep(ItemReader itemReader,
                         ItemProcessor itemProcessor,
                         ItemWriter itemWriter) {

        log.info("itemStep run");

        return stepBuilderFactory.get("itemStep")
                .<Item, Item>chunk(CHUNK_SIZE)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }
}
