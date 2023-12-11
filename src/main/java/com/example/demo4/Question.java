package com.example.demo4;

import java.util.ArrayList;

public class Question {
    public String asker;
    public String question;
    public String time;
    public ArrayList<String>answer;

    public Question(String asker, String question, String time, ArrayList<String>answer) {
        this.asker = asker;
        this.question = question;
        this.time = time;
        this.answer=new ArrayList<>();
        this.answer.addAll(answer);
    }

    public Question() {
        this.asker = "Zarif";
        this.question = "";
        this.time = "";
        this.answer=new ArrayList<>();
    }
}
