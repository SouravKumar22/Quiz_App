package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tn = findViewById<TextView>(R.id.tv_name)
        val ts = findViewById<TextView>(R.id.tv_score)
        val bf = findViewById<Button>(R.id.btn_finish)
        val username = intent.getStringExtra(Constants.USER_NAME)
        tn.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        ts.text = "Your Score is $correctAnswer out of $totalQuestions"

        bf.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}