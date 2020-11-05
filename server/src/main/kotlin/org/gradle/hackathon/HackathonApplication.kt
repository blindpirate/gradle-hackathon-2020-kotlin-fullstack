package org.gradle.hackathon

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.io.File


fun main() {
    SpringApplication.run(HackathonApplication::class.java)
}

val distributionDir = File("../client/build/distributions").apply {
    require(isDirectory)
}

@SpringBootApplication
@Controller
open class HackathonApplication {
    @PostMapping("/data")
    @ResponseBody
    fun getShape(@RequestBody param: String): List<Shape> {
        val requestParam = Json.decodeFromString<RequestParam>(param)
        return Array(requestParam.number) {
            if (it % 2 == 0) {
                Shape("red", 10, 20)
            } else {
                Shape("blue", 20, 10)
            }
        }.toList()
    }

    @GetMapping("/")
    @ResponseBody
    fun index() = distributionDir.resolve("index.html").readText()
}

@Configuration
open class StaticResourceConfig : WebMvcConfigurer {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/static/**")
            .addResourceLocations(distributionDir.absoluteFile.toURI().toString())
    }
}