package com.nithin.study.numbergenerator

import java.util.*

interface ListGeneratorApi {
    fun getPeople(): List<Person> {
        return when (Random().nextInt(4)) {
            1 -> emptyList()
            2 -> listOf(Person(name = "John", surname = "Doe"), Person(name = "Jane", surname = "Duminy"))
            else -> throw Exception()
        }
    }

}