package com.nithin.study.numbergenerator

interface NumberGeneratorContract {
    interface View {
        fun showNumber(number: Int, oddOrEven: String)
    }

    interface Presenter {
        fun attachView(view: NumberGeneratorContract.View)

        fun detachView()

        fun generateNumberClicked()
    }
}