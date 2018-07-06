package com.nithin.study.numbergenerator

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.nithin.study.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
        AppCompatActivity(),
        ListGeneratorContract.View {

    private val listGeneratorPresenter: ListGeneratorContract.Presenter = ListGeneratorPresenter(object : ListGeneratorApi {})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listGeneratorPresenter.attachView(this)
        buttonGenerateNumber.setOnClickListener { listGeneratorPresenter.loadPeople() }
    }

    override fun onDestroy() {
        listGeneratorPresenter.detachView()
        super.onDestroy()
    }

    override fun showPeople(names: List<Person>) {
        emptyListNames.visibility = View.GONE
        val adapter = ListNamesAdapter(this@MainActivity, names)
        listViewNames.adapter = adapter
        listViewNames.visibility = View.VISIBLE

    }

    override fun showNoResults() {
        listViewNames.visibility = View.GONE
        emptyListNames.text = getString(R.string.errorMessage)
        emptyListNames.visibility = View.VISIBLE
    }

    override fun showException() {
        listViewNames.visibility = View.GONE
        emptyListNames.visibility = View.GONE
        AlertDialog.Builder(this)
                .setMessage(R.string.errorException)
                .show()
    }


}
