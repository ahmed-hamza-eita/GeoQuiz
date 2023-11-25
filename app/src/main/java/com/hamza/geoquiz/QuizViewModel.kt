package com.hamza.geoquiz

import androidx.lifecycle.ViewModel
import com.hamza.geoquiz.models.Questions

class QuizViewModel : ViewModel() {
    private val TAG = "Quiz View Model"
    var currentIndex = 0
    private val questionBnk = listOf(
        Questions(R.string.question_australia, true),
        Questions(R.string.question_oceans, true),
        Questions(R.string.question_mideast, false),
        Questions(R.string.question_africa, false),
        Questions(R.string.question_americas, true),
        Questions(R.string.question_asia, true),
    )

    val currentQuestionAnswer: Boolean
        get() = questionBnk[currentIndex].answers

    val currentQuestionText: Int
        get() = questionBnk[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBnk.size
    }
}