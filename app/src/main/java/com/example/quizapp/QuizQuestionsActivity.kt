package com.example.quizapp
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>?= null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null
    private var tv1:TextView?=null
    private var tv2:TextView?=null
    private var tv3:TextView?=null
    private var tv4:TextView?=null
    private var p: ProgressBar?=null
    private var t: TextView?=null
    private var tq: TextView?=null
    private var iv:  ImageView?=null
    private var bs: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        tv1 = findViewById<TextView>(R.id.tv_option_one)
        tv2 = findViewById<TextView>(R.id.tv_option_two)
        tv3 = findViewById<TextView>(R.id.tv_option_three)
        tv4 = findViewById<TextView>(R.id.tv_option_four)
        p = findViewById<ProgressBar>(R.id.progressBar)
        t = findViewById<TextView>(R.id.tv_progress)
        tq = findViewById<TextView>(R.id.tv_question)
        iv = findViewById<ImageView>(R.id.iv_image)
        bs = findViewById<Button>(R.id.btn_submit)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList = Constants.getQuestions()
        setQuestion()
        tv1?.setOnClickListener(this)
        tv2?.setOnClickListener(this)
        tv3?.setOnClickListener(this)
        tv4?.setOnClickListener(this)
        bs?.setOnClickListener(this)

    }
    private fun setQuestion(){

        val question= mQuestionsList!![mCurrentPosition-1]
        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size){
            bs?.text = "FINISH"
        }
        else{
            bs?.text = "SUBMIT"
        }
        p?.progress = mCurrentPosition
        t?.text = "$mCurrentPosition" + "/" +p?.max
        tq?.text = question.question
        iv?.setImageResource(question.image)
        tv1?.text = question.optionOne
        tv2?.text = question.optionTwo
        tv3?.text = question.optionThree
        tv4?.text = question.optionFour

    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv1!!)
        options.add(1,tv2!!)
        options.add(2,tv3!!)
        options.add(3,tv4!!)
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tv1!!,1 )
            }
            R.id.tv_option_two ->{
                selectedOptionView(tv2!!,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv3!!,3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tv4!!,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        Toast.makeText(this, "You have Successfully Completed the Quiz",
                            Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        bs?.text = "FINISH"
                    }else{
                        bs?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tv1!!.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 ->{
                tv2!!.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 ->{
                tv3!!.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 ->{
                tv4!!.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
    }
}
