package com.bawp.harrypotterquiz

object SetData {
    const val name:String = "name"
    const val score:String = "score"
    fun getQuestion():ArrayList<QuestionsData>{
        var que:ArrayList<QuestionsData> = arrayListOf()
        var q1 = QuestionsData(
            
            "What is the name of Harry's parents?",
            1,
            "Vernon Dursley and Petunia Dursley",
            "James and Lilly Potter",
            "Arthur and Molly Weasley",
            "Remus and Nymphadora Lupin",
            2,
        )
        var q2 = QuestionsData(
            "What was full name of Lord Voldemort?",
            2,
            "Tom Riddle",
            "Tom Severus Riddle",
            "Tom Maravolo Riddle",
            "Tom Albus Riddle",
            3,
        )
        var q3 = QuestionsData(
            "How many horcrux did Lord Voldemort made?",
            3,
            "7",
            "5",
            "6",
            "9",
            1,
        )
        var q4 = QuestionsData(
            "Who killed Lord Voldemort?",
            4,
            "Albus Dumbledore",
            "Harry Potter",
            "Hermione Granger",
            "Neville Longbottoom",
            2,
        )
        var q5 = QuestionsData(
            "Who was the half blood prince?",
            5,
            "Lord Voldemort",
            "Harry Potter",
            "Albus Dumbledore",
            "Severus Snape",
            4,
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}