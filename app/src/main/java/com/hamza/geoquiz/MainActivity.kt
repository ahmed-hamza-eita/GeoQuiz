package com.hamza.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hamza.geoquiz.databinding.ActivityMainBinding
import com.hamza.geoquiz.models.Questions
import com.hamza.geoquiz.utils.showToast

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this)[QuizViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        actions()
        updateQuestion()

    }

    private fun actions() {
        binding.btnTrue.setOnClickListener {
            checkAnswer(true)
            updateQuestionWhenAnswerd()
        }
        binding.btnFalse.setOnClickListener {
            checkAnswer(false)
            updateQuestionWhenAnswerd()
        }
        binding.btnNext.setOnClickListener {
           quizViewModel.moveToNext()
            updateQuestion()
        }

    }

    private fun updateQuestion() {

        val questionTxtResId = quizViewModel.currentQuestionText
        binding.txtQuestion.setText(questionTxtResId)
    }

    private fun updateQuestionWhenAnswerd() {


        val questionTxtResId = quizViewModel.currentQuestionText
        binding.txtQuestion.setText(questionTxtResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        if (userAnswer == correctAnswer) {
            showToast("Correct Answer")

        } else {
            showToast("Wrong Answer")


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}