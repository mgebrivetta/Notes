package com.example.todo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static com.example.todo.Controller AppController;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("EventInterface"), 980, 120);
        stage.setTitle("Заметки");
        stage.setScene(scene);
        stage.show();
    }

    //сохраняем добавленные записи перед тем как завершить приложение
    @Override
    public void stop() throws Exception {
        EventSerializer.serialize(AppController.getEvents());
        super.stop();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent parent = fxmlLoader.load();
        AppController = fxmlLoader.getController();
        return parent;
    }

    public static void main(String[] args) {
        launch();
    }

}