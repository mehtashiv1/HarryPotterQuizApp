package com.bawp.harrypotterquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var textInput = findViewById<TextView>(R.id.input)
        var btnId = findViewById<Button>(R.id.btn)
        btnId.setOnClickListener{
            if(textInput.text.toString().isEmpty()){
                Toast.makeText(this,"Enter Your Name", Toast.LENGTH_LONG).show()
            }
            else{
                var intent = Intent(this,Questions::class.java)
                intent.putExtra("${SetData.name}",input.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}