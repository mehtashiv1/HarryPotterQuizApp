package com.bawp.harrypotterquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val username=intent.getStringExtra(SetData.name)
        val score = intent.getStringExtra(SetData.score)
        val totalQuestions = intent.getStringExtra("total size")

        congrats.text = "Congratulations ${username}"
        final_score.text = "${score} / 5"
        finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}