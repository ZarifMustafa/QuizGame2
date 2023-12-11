package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoggedinController {

    @FXML
    public Button about;

    @FXML
    public Button forum;

    @FXML
    public Button guest;

    @FXML
    public Button help;

    @FXML
    public void display_guest(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("QuizTantic");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage stclose=(Stage)(help.getScene().getWindow());
        stclose.close();
        stage.show();
    }

    public void go_to_about(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/about.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Quiz Mania!");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage stclose=(Stage)(help.getScene().getWindow());
        //stclose.close();
        stage.show();

    }
    public void forumfn() throws IOException {

        //if(Global.getInstance().current_user==null) return;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/forum.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Quiz Mania!");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage stclose=(Stage)(help.getScene().getWindow());
        //stclose.close();
        stage.show();
    }
    @FXML
    public void go_to_help(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/help.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Quiz Mania!");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage stclose=(Stage)(help.getScene().getWindow());
        //stclose.close();
        stage.show();
    }

}
