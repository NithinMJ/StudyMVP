package com.nithin.study.numbergenerator

import android.view.View
import com.nithin.study.R.id.emptyListNames
import kotlinx.android.synthetic.main.activity_main.*

class ListGeneratorPresenter(
        private val listGeneratorApi: ListGeneratorApi
) : ListGeneratorContract.Presenter {

    private var view: ListGeneratorContract.View? = null

    override fun attachView(view: ListGeneratorContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadPeople() {
        try {
            val names: List<Person> = listGeneratorApi.getPeople()
            if (names.isNotEmpty()) {
                view?.showPeople(names)
            } else {
                view?.showNoResults()
            }
        } catch (e: Exception) {
            view?.showException()
        }

    }
}