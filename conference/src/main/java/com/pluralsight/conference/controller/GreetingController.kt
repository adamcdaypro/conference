package com.pluralsight.conference.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GreetingController {

    @GetMapping("greeting")
    fun getGreeting(model: MutableMap<String, Any>): String {
        model["message"] = "Hello Adam!"
        return "greeting"
    }
}
