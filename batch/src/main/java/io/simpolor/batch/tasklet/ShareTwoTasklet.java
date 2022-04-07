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
public class ShareTwoTasklet implements Tasklet, StepExecutionListener {

    private String shareData;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        log.info("SampleTwoTasklet run : {}", shareData);

        return RepeatStatus.FINISHED;
    }

    /**
     * Tasklet 간에 넘어 온 값을 처리하기 위한 함수
     * @param stepExecution
     */
    @Override
    public void beforeStep(StepExecution stepExecution) {

        Object obj =
                stepExecution
                        .getJobExecution()
                        .getExecutionContext()
                        .get("share_data");

        shareData = (obj != null) ? (String)obj : "";
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stepExecution
                .getJobExecution()
                .getExecutionContext().put("share_data", null);
        return ExitStatus.COMPLETED;
    }
}
