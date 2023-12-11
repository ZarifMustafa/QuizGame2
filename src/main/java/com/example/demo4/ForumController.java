package com.example.demo4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ForumController implements Initializable {
    public ListView<Question> forum;
    public static ObservableList<Question>questions;
    public Button askqsbtn;
    public TextArea qsfield;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        set_questions();
        forum.getSelectionModel().selectedItemProperty().addListener((observableValue, old_value, new_value) -> expand_question(new_value));
        qsfield.setVisible(false);

        askqsbtn.setOnMouseClicked(e-> show_qsfield());
    }

    private void set_questions() {
        questions= FXCollections.observableArrayList();
        try
        {
            File file = new File("C:/Users/Guest1/IdeaProjects/demo4/src/main/resources/textfiles/forum");
            File[] files = file.listFiles();

            assert files!=null;
            for(File f: files)
            {
                if(f.getName().equals("question no.txt")) continue;

                StringBuilder quest = new StringBuilder("");
                String temp;
                Scanner sc = new Scanner(f);
                String sender = sc.nextLine();

                while(sc.hasNextLine())
                {
                    temp=sc.nextLine();
                    if(temp.equals("#####")) break;
                    quest.append(temp).append("\n");
                }

                ArrayList<String>answers = new ArrayList<>();
                while(sc.hasNextLine())
                {
                    temp=sc.nextLine();
                    answers.add(temp);
                }

                String time = Global.getInstance().get_date_time();
                questions.add(new Question(sender,quest.toString(),time,answers));
            }

            forum.setItems(questions);
            forum.setCellFactory(questionListView -> new Forum_cell_factory());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void expand_question(Question new_value)
    {
        if(new_value==null) return;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/expand-question.fxml"));
            Expand_question_controller expand_question_controller = new Expand_question_controller(new_value, forum.getSelectionModel().getSelectedIndex());
            fxmlLoader.setController(expand_question_controller);

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("QuizTantic");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void show_qsfield()
    {
        if(askqsbtn.getText().equals("Ask a question"))
        {
            qsfield.setVisible(true);
            askqsbtn.setText("Add question");
        }
        else
        {
            try
            {
                File file = new File("C:/Users/Guest1/IdeaProjects/demo4/src/main/resources/textfiles/forum/question no.txt");
                Scanner sc = new Scanner(file);
                int id=sc.nextInt();

                Question question = new Question();
                question.question=qsfield.getText();
                question.asker=Global.getInstance().current_user;
                question.time=Global.getInstance().get_date_time();
                questions.add(question);

                file = new File("C:/Users/Guest1/IdeaProjects/demo4/src/main/resources/textfiles/forum/question"+id+".txt");
                file.createNewFile();

                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(question.asker+"\n");
                fileWriter.write(question.question+"\n");
                fileWriter.write("#####"+"\n");
                for(String s:question.answer) fileWriter.write(s+"\n");
                fileWriter.close();

                ++id;
                FileWriter fileWriter1 = new FileWriter(new File("C:/Users/Guest1/IdeaProjects/demo4/src/main/resources/textfiles/forum/question no.txt"));
                fileWriter1.write(id+"\n");
                fileWriter1.close();

                askqsbtn.setText("Ask a question");
                qsfield.setVisible(false);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
