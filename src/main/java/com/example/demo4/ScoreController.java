package com.example.demo4;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import static com.example.demo4.Global.global;

public class ScoreController implements Initializable {
    public Label scorecard;
    public void initialize(URL url, ResourceBundle resourceBundle){
        scorecard.setText(String.valueOf(global.score*10));

    }
    public void playagainfn() throws IOException {
        global.score=0;
        Global.getInstance().setMemoryIndex(0);

        if(Global.getInstance().current_user==null){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/HomePage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("QuizTantic!");
            stage.setScene(scene);
            stage.setResizable(false);
            Stage stclose=(Stage)(scorecard.getScene().getWindow());
            stclose.close();
            stage.show();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/loggedin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("QuizTantic!");
            stage.setScene(scene);
            stage.setResizable(false);
            Stage stclose=(Stage)(scorecard.getScene().getWindow());
            stclose.close();
            stage.show();
        }
    }
}
