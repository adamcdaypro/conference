package com.pluralsight.conference.controller

import com.pluralsight.conference.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/user")
    fun getUser(@RequestParam(value = "firstName", defaultValue = "Adam") firstName: String,
                @RequestParam(value = "lastName", defaultValue = "Day") lastName: String,
                @RequestParam(value = "age", defaultValue = "44") age: Int
                ): User {
        return User(firstName, lastName, age)
    }

    @PostMapping("/user")
    fun postUser(user: User): User {
        return user
    }
}