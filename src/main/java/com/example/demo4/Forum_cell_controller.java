package com.example.demo4;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Forum_cell_controller implements Initializable {
    public Label q_statement;
    public Label time;
    public Label asker;
    private final Question question;

    public Forum_cell_controller(Question question) {
        this.question = question;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        q_statement.setText(question.question);
        time.setText(question.time);
        asker.setText("by "+question.asker);
    }
}
