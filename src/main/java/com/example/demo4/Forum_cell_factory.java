package com.example.demo4;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class Forum_cell_factory extends ListCell<Question> {
    @Override
    protected void updateItem(Question question, boolean empty) {
        super.updateItem(question, empty);

        if(empty)
        {
            setText(null);
            setGraphic(null);
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/forum-cell.fxml"));
            Forum_cell_controller forum_cell_controller = new Forum_cell_controller(question);
            fxmlLoader.setController(forum_cell_controller);
            setText(null);

            try {
                setGraphic(fxmlLoader.load());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
