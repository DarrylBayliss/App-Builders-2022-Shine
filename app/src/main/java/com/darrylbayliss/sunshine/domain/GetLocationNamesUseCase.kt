package com.darrylbayliss.sunshine.domain

class GetLocationNamesUseCase {

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
