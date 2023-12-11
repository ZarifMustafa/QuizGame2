package com.example.demo4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Expand_question_controller implements Initializable {
    public Label statement;
    public TextArea answer;
    public Button submit_answer;
    public ListView<String> answer_list;
    private final Question question;
    public ObservableList<String>answers;
    public int id;

    public Expand_question_controller(Question question, int id)
    {
        this.question=question;
        this.id=id;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        set_answers();
        submit_answer.setOnMouseClicked(e-> {
            if(!answer.getText().isBlank())
            {
                answers.add(answer.getText());
                ForumController.questions.get(id).answer.add(answer.getText());
                File file = new File("C:/Users/Guest1/IdeaProjects/demo4/src/main/resources/textfiles/forum/question"+id+".txt");
                try
                {
                    FileWriter fileWriter = new FileWriter(file, true);
                    fileWriter.write(answer.getText()+"\n");
                    fileWriter.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }

            }
            answer.clear();
        });
    }

    private void set_answers() {
        answers = FXCollections.observableArrayList();
        answers.addAll(question.answer);
        answer_list.setItems(answers);
        statement.setText(question.question);
    }
}
