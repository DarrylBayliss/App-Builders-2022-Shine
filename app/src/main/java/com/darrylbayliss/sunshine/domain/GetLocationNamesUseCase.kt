package com.darrylbayliss.sunshine.domain

import javax.inject.Inject

class GetLocationNamesUseCase @Inject constructor() {

    operator fun invoke(): List<String> {
        return listOf(
            "Ascona",
            "London",
            "New York",
            "Tokyo",
            "Berlin"
        )
    }
}
