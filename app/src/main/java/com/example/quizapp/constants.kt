package com.example.quizapp

object Constants {

    const val USER_NAME : String = "User_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_argentina,
                "Argentina",
                "Australia",
                "Armenia",
                "India",
                1)

        questionList.add(question1)

        val question2 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_australia,
                "Argentina",
                "Brazil",
                "Armenia",
                "Australia",
                4)

        questionList.add(question2)

        val question3 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_belgium,
                "Argentina",
                "Australia",
                "Belgium",
                "Mozambique",
                3)

        questionList.add(question3)

        val question4 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_brazil,
                "Denmark",
                "Brazil",
                "Fiji",
                "Portugal",
                2)

        questionList.add(question4)

        val question5 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_denmark,
                "Denmark",
                "Fiji",
                "Armenia",
                "China",
                1)

        questionList.add(question5)

        val question6 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_fiji,
                "Malawi",
                "Australia",
                "Fiji",
                "USA",
                3)

        questionList.add(question6)

        val question7 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_germany,
                "Angola",
                "Egypt",
                "Wales",
                "Germany",
                4)

        questionList.add(question7)

        val question8 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_india,
                "Franch",
                "New_zealand",
                "Kuwait",
                "India",
                4)

        questionList.add(question8)

        val question9 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_kuwait,
                "Kuwait",
                "Australia",
                "Portugal",
                "Senegal",
                1)

        questionList.add(question9)

        val question10 = Question(
                1,
                "What Country does this Flag belongs to?",
                R.drawable.ic_flag_of_new_zealand,
                "Peru",
                "Australia",
                "New_zealand",
                "UK",
                3)

        questionList.add(question10)


        return questionList

    }
}