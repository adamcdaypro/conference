package com.pluralsight.conference.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

class Registration(@NotBlank val name: String)