package com.example.quizapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var r = findViewById<Button>(R.id.btn_start)
        var e = findViewById<AppCompatEditText>(R.id.et_name)
        r.setOnClickListener{
            if(e.text.toString().isEmpty()){
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, e.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}