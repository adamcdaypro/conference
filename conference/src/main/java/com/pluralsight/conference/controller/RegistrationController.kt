package com.pluralsight.conference.controller

import com.pluralsight.conference.model.Registration
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class RegistrationController {

    @GetMapping("registration")
    fun getRegistration(@ModelAttribute("registration") registration: Registration): String = "registration"

    @PostMapping("registration")
    fun addRegistration(@Valid @ModelAttribute("registration") registration: Registration,
                        result: BindingResult): String {
        return if (result.hasErrors()) {
            "registration"
        } else {
            "redirect:registration"
        }
    }

}
