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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginController {

    @FXML
    public TextField logemail;

    @FXML
    public Button loglogin;

    @FXML
    public PasswordField logpass;
    public Label incorrect;
    @FXML
    public void  go_to_login(MouseEvent event) throws IOException {
        String email=logemail.getText();
        String pass=logpass.getText();
        //System.out.println(email);
        //System.out.println(pass);
        File file=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\emails.txt");
        File file1=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\passwords.txt");
        Scanner sc=new Scanner(file);
        Scanner sc1=new Scanner(file1);
        String st="",st1="";
        Map<String,String>mp= new HashMap<>();
        while(sc.hasNextLine() && sc1.hasNextLine()){
            st= sc.nextLine();
            st1=sc1.nextLine();
            mp.put(st,st1);
        }
        if(mp.containsKey(email)){
            if(mp.get(email).equals(pass)){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/loggedin.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage=new Stage();
                stage.setTitle("QuizTantic");
                stage.setScene(scene);
                stage.setResizable(false);
                Stage stclose=(Stage)(logemail.getScene().getWindow());
                stclose.close();
                stage.show();

                Global.getInstance().current_user=email;
            }
            else{
                incorrect.setVisible(true);
            }
        }
        else{
            incorrect.setVisible(true);
        }
    }

}
