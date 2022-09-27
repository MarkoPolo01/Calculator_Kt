package com.example.calculator_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
// f
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var nextOperation = 0

    fun onNumberClick(view: View) {
        val button: Button = findViewById(view.id)
        val inputNumber: TextView = findViewById(R.id.resultOperation)
        val text = inputNumber.text.toString() + button.text.toString()
        inputNumber.text = text
    }

    fun onClear(view: View) {
        val poleOne: TextView = findViewById(R.id.numberOperation)
        val poleTwo: TextView = findViewById(R.id.matchOperation)
        val poleThree: TextView = findViewById(R.id.resultOperation)
        poleOne.text=""
        poleTwo.text=""
        poleThree.text=""

    }

    fun onClickTextView(view: View){
        val one : TextView = findViewById(R.id.numberOperation)
        val two : TextView = findViewById(R.id.matchOperation)
        val three : TextView = findViewById(R.id.resultOperation)
        three.text = one.text.toString()
        one.text = ""
        two.text = ""
    }
    fun onOperationClick(view: View){
        val button : Button = findViewById(view.id)
        val inputNumber: TextView = findViewById(R.id.resultOperation)
        val twoOutputNumber : TextView = findViewById(R.id.matchOperation)
        val oneOutputNumber : TextView = findViewById(R.id.numberOperation)
        if (view.id != R.id.equal_btn && !inputNumber.text.equals("")) {
            if(!oneOutputNumber.text.equals("")){
                when(nextOperation){
                    R.id.plus_btn -> {oneOutputNumber.text = (oneOutputNumber.text.toString().toDouble()+inputNumber.text.toString().toDouble()).toString() }
                    R.id.minus_btn -> {oneOutputNumber.text = (oneOutputNumber.text.toString().toDouble()-inputNumber.text.toString().toDouble()).toString()}
                    R.id.milt_btn -> {oneOutputNumber.text = (oneOutputNumber.text.toString().toDouble()*inputNumber.text.toString().toDouble()).toString()}
                    R.id.disiv_btn -> {oneOutputNumber.text = (oneOutputNumber.text.toString().toDouble()/inputNumber.text.toString().toDouble()).toString()}

                }
                twoOutputNumber.text = button.text.toString()
                inputNumber.text = ""
            }else{
                twoOutputNumber.text = button.text.toString()
                oneOutputNumber.text = inputNumber.text.toString()
                inputNumber.text = ""
            }
            nextOperation = view.id
        } else {
            if(!inputNumber.text.equals("")){
                var num = 0.0
                when (nextOperation) {
                    R.id.plus_btn -> {
                        num = findViewById<TextView>(R.id.numberOperation).text.toString().toDouble() +
                                inputNumber.text.toString().toDouble()
                    }
                    R.id.disiv_btn -> {
                        num = findViewById<TextView>(R.id.numberOperation).text.toString().toDouble() /
                                inputNumber.text.toString().toDouble()
                    }
                    R.id.milt_btn -> {
                        num = findViewById<TextView>(R.id.numberOperation).text.toString().toDouble() *
                                inputNumber.text.toString().toDouble()
                    }
                    R.id.minus_btn -> {
                        num = findViewById<TextView>(R.id.numberOperation).text.toString().toDouble() -
                                inputNumber.text.toString().toDouble()
                    }
                }
                twoOutputNumber.text = ""
                inputNumber.text = ""
                oneOutputNumber.text = num.toString()
            }else{
                twoOutputNumber.text = button.text.toString()
                nextOperation = view.id
            }
        }
    }

}