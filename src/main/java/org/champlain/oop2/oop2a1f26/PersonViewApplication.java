package org.champlain.oop2.oop2a1f26;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PersonViewApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PersonViewApplication.class.getResource("person-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 350);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
