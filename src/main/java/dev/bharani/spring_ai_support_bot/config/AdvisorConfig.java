package dev.bharani.spring_ai_support_bot.config;

import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdvisorConfig {

    @Autowired
    JdbcChatMemoryRepository chatMemoryRepository;          // auto-configured

    @Bean
    public PromptChatMemoryAdvisor promptChatMemoryAdvisor() {
        return PromptChatMemoryAdvisor.builder(getChatMemory()).build();
    }

    @Bean
    public QuestionAnswerAdvisor questionAnswerAdvisor(VectorStore vectorStore /*auto-configured*/) {
        return QuestionAnswerAdvisor.builder(vectorStore)
                .build();
    }

    private ChatMemory getChatMemory() {
        return MessageWindowChatMemory.builder()
                .chatMemoryRepository(chatMemoryRepository)
                .maxMessages(100)                           // keep last 100 messages in memory
                .build();
    }

}
