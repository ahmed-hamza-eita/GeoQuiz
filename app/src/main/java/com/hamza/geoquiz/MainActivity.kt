package com.hamza.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamza.geoquiz.databinding.ActivityMainBinding
import com.hamza.geoquiz.models.Questions
import com.hamza.geoquiz.utils.showToast

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val questionBnk = listOf(
        Questions(R.string.question_australia, true),
        Questions(R.string.question_oceans, true),
        Questions(R.string.question_mideast, false),
        Questions(R.string.question_africa, false),
        Questions(R.string.question_americas, true),
        Questions(R.string.question_asia, true),

        )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        actions()
        updateQuestion()

    }

    private fun actions() {
        binding.btnTrue.setOnClickListener { checkAnswer(true)
            updateQuestionWhenAnswerd()
        }
        binding.btnFalse.setOnClickListener { checkAnswer(false)
            updateQuestionWhenAnswerd()
        }
        binding.btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBnk.size
            updateQuestionWhenAnswerd()
        }

    }

    private fun updateQuestion() {

        val questionTxtResId = questionBnk[currentIndex].textResId
        binding.txtQuestion.setText(questionTxtResId)
    }

    private fun updateQuestionWhenAnswerd() {
        currentIndex = (currentIndex + 1) % questionBnk.size

        val questionTxtResId = questionBnk[currentIndex].textResId
        binding.txtQuestion.setText(questionTxtResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBnk[currentIndex].answers
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