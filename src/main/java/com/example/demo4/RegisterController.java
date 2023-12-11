package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegisterController {

    @FXML
    public Button regbutton;

    @FXML
    public PasswordField regconfirm;

    @FXML
    public TextField regemail;

    @FXML
    public PasswordField regpass;

    @FXML
    public TextField reguser;
    public Label reenter;
    @FXML
    public void go_to_start() throws IOException {
        String email,st2,st3,user;
        email=regemail.getText();
        user=reguser.getText();
        st2=regpass.getText();
        st3=regconfirm.getText();
        File file=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\emails.txt");
        File file1=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\passwords.txt");
        File file2=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\usernames.txt");
        Scanner sc=new Scanner(file);
        Scanner sc1=new Scanner(file1);
        String st="",st1="";
        Map<String,String> mp= new HashMap<>();
        while(sc.hasNextLine() && sc1.hasNextLine()){
            st= sc.nextLine();
            st1=sc1.nextLine();
            mp.put(st,st1);
        }
        if(mp.containsKey(email)){
            reenter.setText("User Exists");
            reenter.setVisible(true);
        }
        else if(st2.equals(st3)){
            //FileWriter filewriter=new FileWriter(file,true);

            BufferedWriter filewriter = new BufferedWriter(new FileWriter(file, true));
            filewriter.write(email+"\n");
            filewriter.close();
            filewriter = new BufferedWriter(new FileWriter(file1, true));
            filewriter.write(st2+"\n");
            filewriter.close();
            filewriter = new BufferedWriter(new FileWriter(file2, true));
            filewriter.write(user+"\n");
            filewriter.close();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("QuizTantic");
            stage.setScene(scene);
            stage.setResizable(false);
            Stage stclose=(Stage)(regbutton.getScene().getWindow());
            stclose.close();
            stage.show();
        }
        else{
            reenter.setText("Please Enter Same Password");
            reenter.setVisible(true);
        }

    }

}
