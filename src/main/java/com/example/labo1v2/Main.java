package com.example.labo1v2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Queue;

public class Main extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//
//    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception{
        ProcessFactory p = new ProcessFactory();
        Queue<Process> processen = p.leesProcessen("20000");
        Queue<Process> processen2 = p.leesProcessen("10000");
        Queue<Process> processen3 = p.leesProcessen("50000");
    }
}