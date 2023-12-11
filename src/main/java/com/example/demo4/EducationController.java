package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EducationController implements Initializable {

    @FXML
    public ImageView biology;

    @FXML
    public ImageView chemistry;

    @FXML
    public ImageView math;

    @FXML
    public ImageView physics;
    public void physicsfn() throws IOException {
        Global.getInstance().setMemoryIndex(6);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/memory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Quiz Mania!");
        stage.setScene(scene);
        Stage stclose=(Stage)(physics.getScene().getWindow());
        stclose.close();
        stage.show();
    }
    public void biologyfn() throws IOException {
        Global.getInstance().setMemoryIndex(8);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/memory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Quiz Mania!");
        stage.setScene(scene);
        Stage stclose=(Stage)(physics.getScene().getWindow());
        stclose.close();
        stage.show();
    }

    public void chemistryfn() throws IOException {
        Global.getInstance().setMemoryIndex(7);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/memory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Quiz Mania!");
        stage.setScene(scene);
        Stage stclose=(Stage)(physics.getScene().getWindow());
        stclose.close();
        stage.show();
    }
    public void mathfn() throws IOException {
        Global.getInstance().setMemoryIndex(9);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/memory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("QuizTantic");
        stage.setScene(scene);
        Stage stclose=(Stage)(physics.getScene().getWindow());
        stclose.close();
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void expand(){

    }
}
