package com.example.easy_calci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener { appendOnExpresstion(string= "1", canClear= true) }
        tvTwo.setOnClickListener { appendOnExpresstion(string= "2", canClear= true) }
        tvThree.setOnClickListener { appendOnExpresstion(string= "3", canClear= true) }
        tvFour.setOnClickListener { appendOnExpresstion(string= "4", canClear= true) }
        tvFive.setOnClickListener { appendOnExpresstion(string= "5", canClear= true) }
        tvSix.setOnClickListener { appendOnExpresstion(string= "6", canClear= true) }
        tvSeven.setOnClickListener { appendOnExpresstion(string= "7", canClear= true) }
        tvEight.setOnClickListener { appendOnExpresstion(string= "8", canClear= true) }
        tvNine.setOnClickListener { appendOnExpresstion(string= "9", canClear= true) }
        tvZero.setOnClickListener { appendOnExpresstion(string= "0", canClear= true) }
        tvDot.setOnClickListener { appendOnExpresstion(string= ".", canClear= true) }

        //operators
        tvPlus.setOnClickListener { appendOnExpresstion(string= "+", canClear= false) }
        tvMinus.setOnClickListener { appendOnExpresstion(string= "-", canClear= false) }
        tvMul.setOnClickListener { appendOnExpresstion(string= "*", canClear= false) }
        tvDivide.setOnClickListener { appendOnExpresstion(string= "/", canClear= false) }
        tvOpen.setOnClickListener { appendOnExpresstion(string= "(", canClear= false) }
        tvClose.setOnClickListener { appendOnExpresstion(string= ")", canClear= false) }

        tvClear.setOnClickListener{
            tvExpression.text=""
            tvResult.text=""
        }

        tvBack.setOnClickListener {
            val string=tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length - 1)
            }
            tvResult.text=""
        }
        tvEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = longResult.toString()
            } catch (e:ArithmeticException){
                println(e)
            }
        }
    }

    fun appendOnExpresstion(string:String, canClear:Boolean){
        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }
        if (canClear){
            tvResult.text = ""
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}