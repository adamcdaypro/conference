package com.pluralsight.conference

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.thymeleaf.spring6.SpringTemplateEngine
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring6.view.ThymeleafViewResolver

@Configuration
open class ThymeleafConfiguration: WebMvcConfigurer {

    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Bean
    open fun templateResolver(): SpringResourceTemplateResolver {
        return SpringResourceTemplateResolver().apply {
            setApplicationContext(applicationContext)
            prefix = "/WEB-INF/view/"
            suffix = ".html"
        }
    }

    @Bean
    open fun springTemplateEngine(): SpringTemplateEngine {
        return SpringTemplateEngine().apply {
            setTemplateResolver(templateResolver())
            enableSpringELCompiler = true
        }
    }

    @Bean
    open fun thymeleafViewResolver(): ThymeleafViewResolver {
        return ThymeleafViewResolver().apply {
            templateEngine = springTemplateEngine()
            order = 0
        }
    }

}