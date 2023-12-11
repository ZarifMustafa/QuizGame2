package com.example.demo4;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.example.demo4.Global.global;

public class MemoryController implements Initializable {

    public Label question;
    public RadioButton ans1;
    public ToggleGroup answer;
    public RadioButton ans2;
    public RadioButton ans3;
    public RadioButton ans4;
    public Button Submit;
    public String[] questions;
    public String[][] ans;
    public String[] correctanswers;
    public String correctans;
    public Label correct;
    public Label incorrect;
    public Label ca;

    public Label time;
    int id, id1,firstIndex;
    public int timercount=0,timercount1=0,timercount2=0;
    ArrayList<Integer>randomizing=new ArrayList<>();
    Timer timer=new Timer();
    Timer timer1=new Timer();
    Timer timer2=new Timer();
    public Label observe;
    public final Image[] memorypics=new Image[50];
    public ImageView memorypic=new ImageView();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            File quesfiles[];

            quesfiles=new File[10];
            quesfiles[0]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memoryques.txt");
            quesfiles[1]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\iqques.txt");
            quesfiles[2]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\educationques.txt");
            quesfiles[3]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\vocabularyques.txt");
            quesfiles[4]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\gkques.txt");
            quesfiles[5]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\entertainmentques.txt");
            quesfiles[6]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\physicsques.txt");
            quesfiles[7]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\chemistryques.txt");
            quesfiles[8]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\biologyques.txt");
            quesfiles[9]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\mathques.txt");
            File ansfiles[];
            ansfiles=new File[10];
            ansfiles[0]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memoryans.txt");
            ansfiles[1]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\iqans.txt");
            ansfiles[2]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\educationans.txt");
            ansfiles[3]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\vocabularyans.txt");
            ansfiles[4]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\gkans.txt");
            ansfiles[5]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\entertainmentans.txt");
            ansfiles[6]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\physicsans.txt");
            ansfiles[7]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\chemistryans.txt");
            ansfiles[8]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\biologyans.txt");
            ansfiles[9]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\mathans.txt");
            File correctansfiles[];
            correctansfiles=new File[10];
            correctansfiles[0]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memorycorrectans.txt");
            correctansfiles[1]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\iqcorrectans.txt");
            correctansfiles[2]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\educationcorrectans.txt");
            correctansfiles[3]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\vocabularycorrectans.txt");
            correctansfiles[4]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\gkcorrectans.txt");
            correctansfiles[5]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\entertainmentcorrectans.txt");
            correctansfiles[6]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\physicscorrectans.txt");
            correctansfiles[7]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\chemistrycorrectans.txt");
            correctansfiles[8]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\biologycorrectans.txt");
            correctansfiles[9]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\mathcorrectans.txt");
            File currentfile=quesfiles[(Global.getInstance().getMemoryIndex())];
            Scanner sc=new Scanner(currentfile);
            questions=new String[50];
            for(int i=0;i<50;i++){
                questions[i]=sc.nextLine();//input nicchi file theke
            }

            for(int i=0;i<50;i++){
                randomizing.add(i);
            }
            Collections.shuffle(randomizing);
            firstIndex=randomizing.get(0);
            question.setText(questions[firstIndex]);
            id=0;
            currentfile=ansfiles[Global.getInstance().getMemoryIndex()];
            sc=new Scanner(currentfile);
            ans=new String[50][4];
            for(int i=0;i<50;i++){
                for (int j = 0; j < 4; j++) {
                    ans[i][j]=sc.nextLine();
                }
                sc.nextLine();
            }
            ans1.setText(ans[firstIndex][0]);
            ans2.setText(ans[firstIndex][1]);
            ans3.setText(ans[firstIndex][2]);
            ans4.setText(ans[firstIndex][3]);
            currentfile=correctansfiles[(Global.getInstance().getMemoryIndex())];
            sc=new Scanner(currentfile);
            correctanswers=new String[50];
            for(int i=0;i<50;i++){
                correctanswers[i]=sc.nextLine();
            }
            correctans=correctanswers[firstIndex];
            if(Global.getInstance().getMemoryIndex()==0){
                /*
                int p=0;
                File file=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg");
                File []files=file.listFiles();
                for(int i=0;i< files.length;i++){
                    memorypics[i]=new Image(files[i].getAbsolutePath());
                }
                 */

                int p=0;
                Image img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\1.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\2.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\3.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\4.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\5.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\6.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\7.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\8.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\9.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\10.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\11.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\12.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\13.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\14.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\15.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\16.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\17.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\18.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\19.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\20.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\21.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\22.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\23.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\24.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\25.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\26.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\27.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\28.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\29.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\30.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\31.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\32.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\33.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\34.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\35.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\36.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\37.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\38.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\39.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\40.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\41.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\42.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\43.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\44.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\45.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\46.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\47.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\48.png");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\49.jpg");
                memorypics[p++]=img;
                img=new Image("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\memoryimg\\50.png");
                memorypics[p++]=img;

            }

            if(Global.getInstance().getMemoryIndex()==0){
                observe.setVisible(true);
                timercount1=5;
                TimerTask timertask1= new TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> {
                            timercount1--;
                            if(timercount1<0){
                                observe.setVisible(false);
                            }
                        });
                    }
                };
                timercount1=5;
                //if(!global.flag) {
                    timer1.schedule(timertask1, 1000, 1000);
                //}
                timercount1=5;
                memorypic.setImage(memorypics[firstIndex]);
                memorypic.setVisible(true);
                timercount2=15;
                TimerTask timertask2= new TimerTask() {

                    @Override
                    public void run() {
                        Platform.runLater(() -> {
                            timercount2--;
                            //System.out.println(timercount2);
                            if(timercount2==-1){
                                memorypic.setVisible(false);
                                timercount2=15;
                            }
                        });
                    }
                };
                timercount2=15;
                //if(!global.flag) {
                    timer2.schedule(timertask2, 1000, 1000);
                //}
            }

            TimerTask timertask= new TimerTask() {

                public void run() {
                    Platform.runLater(() -> {
                        String st=String.valueOf(timercount);
                        time.setText(st);
                        //if(!global.flag){
                            timercount--;
                        //}

                        if(timercount==-1){
                            try {
                                correctAnsShow();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            };

            timercount=30;
            //if(!global.flag) {
                timer.schedule(timertask, 1000, 1000);
            //}
            timercount=30;
            time.setText(String.valueOf(timercount));

            id1=0;
            QuesAns quesans[]=new QuesAns[3];

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void correctAnsShow() throws InterruptedException {
        global.score+=1;
        if(ans1.isSelected() && correctanswers[firstIndex].equals("0")) correct.setVisible(true);
        else if(ans2.isSelected() && correctanswers[firstIndex].equals("1")) correct.setVisible(true);
        else if(ans3.isSelected() && correctanswers[firstIndex].equals("2")) correct.setVisible(true);
        else if(ans4.isSelected() && correctanswers[firstIndex].equals("3")) correct.setVisible(true);
        else{
            incorrect.setVisible(true);
            char ch=correctanswers[firstIndex].charAt(0);
            ca.setText("Correct Answer: "+ans[firstIndex][ch-'0']);
            ca.setVisible(true);
            global.score--;
        }
        //timercount=30;
        //timercount2=15;
        time.setVisible(false);
        ans1.setDisable(true);
        ans2.setDisable(true);
        ans3.setDisable(true);
        ans4.setDisable(true);
    }

    public void submit_korsi() throws IOException {
        if(id==9){
            FXMLLoader fxmlloader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/totalscore.fxml"));
            Scene scene = new Scene(fxmlloader.load());
            Stage stage=new Stage();
            stage.setTitle("Quiz Mania!");
            stage.setScene(scene);
            Stage stclose=(Stage)(question.getScene().getWindow());
            stclose.close();
            stage.show();
            return;
        }
        id++;
        firstIndex=randomizing.get(id);
        question.setText(questions[firstIndex]);
        correct.setVisible(false);
        incorrect.setVisible(false);
        ans1.setText(ans[firstIndex][0]);
        ans2.setText(ans[firstIndex][1]);
        ans3.setText(ans[firstIndex][2]);
        ans4.setText(ans[firstIndex][3]);
        ans1.setDisable(false);
        ans2.setDisable(false);
        ans3.setDisable(false);
        ans4.setDisable(false);
        ca.setVisible(false);
        ans1.setSelected(false);
        ans2.setSelected(false);
        ans3.setSelected(false);
        ans4.setSelected(false);
        time.setVisible(true);
        if(Global.getInstance().getMemoryIndex()==0){
            memorypic.setImage(memorypics[firstIndex]);
            memorypic.setVisible(true);
            timercount2=15;
            TimerTask timertask2= new TimerTask() {

                @Override
                public void run() {
                    Platform.runLater(() -> {
                        if(timercount2==15 && timercount==30){
                            memorypic.setVisible(true);
                        }
                        if(timercount2==-1){
                            //memorypic.setVisible(true);
                            memorypic.setVisible(false);
                            timercount2=15;
                        }
                    });
                }
            };
            timercount2=15;
            //if(!global.flag) {
                timer2.schedule(timertask2, 1000, 1000);
            //}
            //memorypic.setVisible(false);
        }
        TimerTask timertask= new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    String st=String.valueOf(timercount);
                    time.setText(st);
                    if(timercount==-1){
                        try {
                            correctAnsShow();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        };

        timercount=30;
        //if(!global.flag){
            timer.schedule(timertask,1000, 1000);
        //}
        timercount=30;
        time.setText(String.valueOf(timercount));
        global.flag=true;
        global.cnt++;
    }

}
