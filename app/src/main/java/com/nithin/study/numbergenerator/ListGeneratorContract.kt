package com.nithin.study.numbergenerator

interface ListGeneratorContract {
    interface View {
        fun showPeople(names: List<Person>)

        fun showNoResults()

        fun showException()
    }

    interface Presenter {
        fun attachView(view: ListGeneratorContract.View)

        fun detachView()

        fun loadPeople()
    }
}