package com.example.quizapp
object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(1,"What Country does this Flag belong to?",
            R.drawable.argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionsList.add(que1)
        val que2 = Question(1,"What Country does this Flag belong to?",
            R.drawable.germany,
            "Georgia",
            "Philippines",
            "New Zealand",
            "Germany",
            4
        )
        questionsList.add(que2)
        val que3 = Question(1,"What Country does this Flag belong to?",
            R.drawable.kwait,
            "India",
            "Nepal",
            "Kuwait",
            "Denmark",
            3
        )
        questionsList.add(que3)
        val que4 = Question(1,"What Country does this Flag belong to?",
            R.drawable.figi,
            "figi",
            "England",
            "South Africa",
            "Japan",
            1
        )
        questionsList.add(que4)
        val que5 = Question(1,"What Country does this Flag belong to?",
            R.drawable.newzland,
            "Australia",
            "New Zealand",
            "Pakistan",
            "Iraq",
            2
        )
        questionsList.add(que5)
        val que6 = Question(1,"What Country does this Flag belong to?",
            R.drawable.india,
            "India",
            "Pakistan",
            "Afghanistan",
            "Sri Lanka",
            1
        )
        questionsList.add(que6)
        val que7 = Question(1,"What Country does this Flag belong to?",
            R.drawable.brazil,
            "Greece",
            "Libya",
            "Brazil",
            "HongKong",
            3
        )
        questionsList.add(que7)
        val que8 = Question(1,"What Country does this Flag belong to?",
            R.drawable.denmark,
            "Dominica",
            "Denmark",
            "Finland",
            "Egypt",
            2
        )
        questionsList.add(que8)
        val que9 = Question(1,"What Country does this Flag belong to?",
            R.drawable.belgium,
            "Burma",
            "China",
            "Belgium",
            "Malaysia",
            3
        )
        questionsList.add(que9)
        val que10 = Question(1,"What Country does this Flag belong to?",
            R.drawable.australia,
            "Japan",
            "Colombia",
            "Mexico",
            "Australia",
            4
        )
        questionsList.add(que10)
        return questionsList
    }
}