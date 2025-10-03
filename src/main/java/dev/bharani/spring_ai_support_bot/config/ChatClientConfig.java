package dev.bharani.spring_ai_support_bot.config;

import dev.bharani.spring_ai_support_bot.chat.Prompt;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder,
                                 PromptChatMemoryAdvisor promptChatMemoryAdvisor) {
        return builder
                .defaultSystem(Prompt.SYSTEM_PROMPT)
                .defaultAdvisors(promptChatMemoryAdvisor)
                .build();
    }

}
