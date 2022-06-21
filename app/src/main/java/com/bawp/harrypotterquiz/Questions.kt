package com.bawp.harrypotterquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bawp.harrypotterquiz.SetData.score
import kotlinx.android.synthetic.main.activity_questions.*

class Questions : AppCompatActivity() {
    private var Name:String?=null
    private var Score:Int=0
    private var currentPosition:Int = 1
    private var selectedOption:Int = 0
    private var questionList:ArrayList<QuestionsData>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        SetData.getQuestion()
        Name = intent.getStringExtra(SetData.name)
        questionList = SetData.getQuestion()
         setQuestion()
        opt1.setOnClickListener{
            selectedOptionStyle(opt1,1 )
        }
        opt2.setOnClickListener{
            selectedOptionStyle(opt2,2 )
        }
        opt3.setOnClickListener{
            selectedOptionStyle(opt3,3 )
        }
        opt4.setOnClickListener{
            selectedOptionStyle(opt4,4 )
        }
        Submit.setOnClickListener {
            if(selectedOption!=0){
                val question = questionList!![currentPosition - 1]
                if(selectedOption != question.correct_ans ){
                    setColor(selectedOption,R.drawable.wrong_question_option)
                }
                else{
                    Score++
                }
                setColor(question.correct_ans,R.drawable.correct_question_option)
                if(currentPosition==questionList!!.size)
                Submit.text = "FINISH"
                else
                    Submit.text = "GO TO NEXT"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent = Intent(this,Result::class.java)
                        intent.putExtra(SetData.name,Name.toString())
                        intent.putExtra(SetData.score,Score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())

                        startActivity(intent)


                    }
                }
            }
            selectedOption = 0
        }
    }

    fun setColor(opt:Int, Color:Int){
        when(opt){
            1->{
                opt1.background= ContextCompat.getDrawable(this,Color)
            }
            2->{
                opt2.background= ContextCompat.getDrawable(this,Color)
            }
            3->{
                opt3.background= ContextCompat.getDrawable(this,Color)
            }
            4->{
                opt4.background= ContextCompat.getDrawable(this,Color)
            }
        }

    }

    fun setQuestion(){
        val question = questionList!![currentPosition-1]
        setOptionStyle()

        progress_bar.progress = currentPosition
        progress_bar.max = questionList!!.size
        progress_text.text= "${currentPosition}"+"/"+"${progress_bar.max}"
        question_text.text = question.question
        opt1.text = question.optionOne
        opt2.text = question.optionTwo
        opt3.text = question.optionThree
        opt4.text = question.optionFour
    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt1)
        optionList.add(1,opt2)
        optionList.add(2,opt3)
        optionList.add(3,opt4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background= ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }
    fun selectedOptionStyle(view: TextView,opt: Int){
        setOptionStyle()
        selectedOption = opt
        view.background= ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))




    }
}