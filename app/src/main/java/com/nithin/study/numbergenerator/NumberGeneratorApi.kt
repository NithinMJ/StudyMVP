package com.nithin.study.numbergenerator

import java.util.*

interface NumberGeneratorApi {
    fun generateNumber(): Int = Random().nextInt(10)
}