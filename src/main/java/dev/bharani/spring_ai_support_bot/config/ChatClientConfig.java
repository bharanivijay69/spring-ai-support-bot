package dev.bharani.spring_ai_support_bot.config;

import dev.bharani.spring_ai_support_bot.chat.Prompt;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder,
                                 PromptChatMemoryAdvisor promptChatMemoryAdvisor,
                                 QuestionAnswerAdvisor questionAnswerAdvisor) {
        return builder
                .defaultSystem(Prompt.SYSTEM_PROMPT)
                .defaultAdvisors(promptChatMemoryAdvisor, questionAnswerAdvisor)
                .build();
    }

}
