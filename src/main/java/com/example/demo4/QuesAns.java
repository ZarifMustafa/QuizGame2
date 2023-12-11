package com.example.demo4;

public class QuesAns {
    String correctAns;
    String ques;
    String[] ans=new String[4];
    QuesAns(String correctAns,String ques,String[] ans){
        this.correctAns=correctAns;
        this.ques=ques;
        for(int i=0;i<4;i++){
            this.ans[i]=ans[i];
        }
    }
}
