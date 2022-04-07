
package io.simpolor.batch.config;

import io.simpolor.batch.domain.Item;
import io.simpolor.batch.reader.QueueItemReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ItemConfig {

    @StepScope
    @Bean(name = "itemReader")
    public ItemReader<Item> itemReader() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", System.currentTimeMillis()));
        items.add(new Item("item2", System.currentTimeMillis()));

        log.info("ItemReader size : {}", items.size());

        return new QueueItemReader<>(items);
    }

    @StepScope
    @Bean(name = "itemProcessor")
    public ItemProcessor<Item, Item> itemProcessor(){

        log.info("ItemProcessor run");

        return item -> {
            item.setName(item.getName()+"_setting");
            return item;
        };
    }

    @StepScope
    @Bean(name = "itemWriter")
    public ItemWriter<Item> itemWriter() {
        return items -> {
            for (Item item : items) {
                log.info("ItemWriter item name : {}", item.getName());
            }
        };
    }
}
