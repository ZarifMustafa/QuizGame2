package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    public Button about;

    @FXML
    public Button help;

    @FXML
    public Button login;

    @FXML
    public Button register;
    public ImageView quiztime;
    public Button forum;
    @FXML
    public void display_guest(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Quiz Mania!");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage stclose=(Stage)(login.getScene().getWindow());
        stclose.close();
        stage.show();
    }

    @FXML
    public void display_login(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("QuizTantic!");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage stclose=(Stage)(login.getScene().getWindow());
        stclose.close();
        stage.show();
    }

    @FXML
    public void display_register(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("QuizTantic");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage stclose=(Stage)(login.getScene().getWindow());
        stclose.close();
        stage.show();
    }
    @FXML
    public void go_to_about(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/about.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Quiz Mania!");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage stclose=(Stage)(login.getScene().getWindow());
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
        Stage stclose=(Stage)(login.getScene().getWindow());
        //stclose.close();
        stage.show();
    }
}
