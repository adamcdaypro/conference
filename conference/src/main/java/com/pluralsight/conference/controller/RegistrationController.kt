package com.pluralsight.conference.controller

import com.pluralsight.conference.model.Registration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RegistrationController {

    @GetMapping("registration")
    fun getRegistration(@ModelAttribute("registration") registration: Registration): String = "registration"

    @PostMapping("registration")
    fun addRegistration(@ModelAttribute("registration") registration: Registration): String = "redirect:registration"

}
