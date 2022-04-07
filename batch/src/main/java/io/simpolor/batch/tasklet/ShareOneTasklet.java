package io.simpolor.batch.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public class ShareOneTasklet implements Tasklet, StepExecutionListener {

    private String shareData;
    private int count = 0;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        log.info("ShareOneTasklet run : {}", count);

        if(count < 3){
            count++;
            return RepeatStatus.CONTINUABLE;
        }

        shareData = "This is shareDate";
        log.info("ShareOneTasklet Finished");

        return RepeatStatus.FINISHED;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) { }

    /**
     * Tasklet 간에 값을 넘기기 위한 함수
     * @param stepExecution
     */
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stepExecution
                .getJobExecution()
                .getExecutionContext().put("share_data", shareData);
        return ExitStatus.COMPLETED;
    }
}
