package com.hello.springai

import org.springframework.ai.openai.OpenAiChatClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController(
    private val chatClient: OpenAiChatClient
) {
    @GetMapping("/ai/generate")
    fun generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") message: String?): Map<*, *> {
        return java.util.Map.of("generation", chatClient.call(message))
    }
}

