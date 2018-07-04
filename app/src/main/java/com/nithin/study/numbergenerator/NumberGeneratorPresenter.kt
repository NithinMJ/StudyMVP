package com.nithin.study.numbergenerator

import java.util.*

class NumberGeneratorPresenter : NumberGeneratorContract.Presenter {

    private var view: NumberGeneratorContract.View? = null

    override fun attachView(view: NumberGeneratorContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun generateNumberClicked() {
        val number: Int = Random().nextInt(10)
        val isEvenOrOdd: String = evenOrOdd(number)

        view?.showNumber(number, isEvenOrOdd)
    }

    private fun evenOrOdd(number: Int): String = if (number % 2 == 0) "Even" else "Odd"
}