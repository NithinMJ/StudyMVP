package com.nithin.study.numbergenerator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nithin.study.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
        AppCompatActivity(),
        NumberGeneratorContract.View {

    private val numberGeneratorPresenter: NumberGeneratorContract.Presenter = NumberGeneratorPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberGeneratorPresenter.attachView(this)
        buttonGenerateNumber.setOnClickListener {  numberGeneratorPresenter.generateNumberClicked() }
    }

    override fun onDestroy() {
        numberGeneratorPresenter.detachView()
        super.onDestroy()
    }

    override fun showNumber(number: Int, oddOrEven: String) {
        textViewGeneratedNumber.text = getString(R.string.main_text_generated_number, number, oddOrEven)
    }
}
