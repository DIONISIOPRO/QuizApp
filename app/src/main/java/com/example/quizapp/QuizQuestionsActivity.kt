package com.example.quizapp


import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentQuestion: Int = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOptionPosition: Int? = null
    private var correctAnswers: Int = 0
    private var resultShowed: Boolean = false
    private var userName: String? = null


    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        userName = intent.getStringExtra(Constants.USER_NAME)
        questionsList = Constants.getQuestions()
        setFirstQuestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnsubmit.setOnClickListener(this)

    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> binding.tvOptionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableView)
            2 -> binding.tvOptionTwo.background = ContextCompat.getDrawable(
                    this,
                    drawableView)
            3 -> binding.tvOptionThree.background = ContextCompat.getDrawable(
                    this,
                    drawableView)
            4 -> binding.tvOptionFour.background = ContextCompat.getDrawable(
                    this,
                    drawableView)
        }

    }

    private fun selectedOptionView(tv: TextView) {
        defaultOption()
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }

    private fun encreaseCorrectAnswer() {
        correctAnswers++
    }


    private fun setFirstQuestion() {
        val question: Question? = questionsList!![currentQuestion - 1]
        defaultOption()

        binding.progressBar.progress = currentQuestion
        binding.tvProgress.text = ("${currentQuestion}/${binding.progressBar.max}").toString()
        binding.tvQuestion.text = question!!.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        resultShowed = false
    }

    private fun setNextQuestion() {
        currentQuestion += 1
        if (currentQuestion <= questionsList!!.size) {
            setFirstQuestion()
        } else {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList!!.size)
            startActivity(intent)
            finish()
        }

    }

    private fun showCorrectAnswer() {
        val question = questionsList?.get(currentQuestion - 1)
        if (question!!.correctAnswer != selectedOptionPosition) {
            answerView(selectedOptionPosition!!, R.drawable.wrong_option_border_bg)
        } else {
            encreaseCorrectAnswer()
        }
        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
        resultShowed = true
    }

    private fun defaultOption() {
        selectedOptionPosition = null
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for (option in options) {

            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                    R.drawable.default_option_border_bg)
        }
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_OptionOne -> {
                selectedOptionView(binding.tvOptionOne)
                selectedOptionPosition = 1
            }
            R.id.tv_OptionTwo -> {
                selectedOptionView(binding.tvOptionTwo)
                selectedOptionPosition = 2
            }
            R.id.tv_OptionThree -> {
                selectedOptionView(binding.tvOptionThree)
                selectedOptionPosition = 3
            }
            R.id.tv_OptionFour -> {
                selectedOptionView(binding.tvOptionFour)
                selectedOptionPosition = 4
            }

            R.id.btnsubmit -> when {
                selectedOptionPosition == null -> {
                    Toast.makeText(this, "Please Selected One Option!",
                            Toast.LENGTH_SHORT).show()
                    binding.btnsubmit.text = "SUBMIT"
                }

                selectedOptionPosition != null && !resultShowed -> {
                    showCorrectAnswer()
                    if (currentQuestion == questionsList!!.size ) {
                        binding.btnsubmit.text = "SEE YOUR SCORE"
                    } else {
                        binding.btnsubmit.text = "GO TO NEXT QUESTION"
                    }

                }

                selectedOptionPosition != null && resultShowed -> {
                    setNextQuestion()
                    binding.btnsubmit.text = "SUBMIT"

                }


            }


        }

    }
}







