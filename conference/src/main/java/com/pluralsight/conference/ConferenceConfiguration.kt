package com.pluralsight.conference

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import org.springframework.web.servlet.view.InternalResourceViewResolver
import java.util.*

@Configuration
open class ConferenceConfiguration : WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/files/**")
                .addResourceLocations("/WEB-INF/pdf/")
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(localChangeInterceptor())
    }

    @Bean
    open fun localeResolver(): LocaleResolver {
        return SessionLocaleResolver().apply {
            setDefaultLocale(Locale.US)
        }
    }

    @Bean
    open fun localChangeInterceptor(): LocaleChangeInterceptor {
        return LocaleChangeInterceptor().apply {
            paramName = "lang"
        }
    }

    @Bean
    open fun viewResolver(): ViewResolver {
        return InternalResourceViewResolver().apply {
            setPrefix("/WEB-INF/jsp/")
            setSuffix(".jsp")
            order = 0
        }
    }



}