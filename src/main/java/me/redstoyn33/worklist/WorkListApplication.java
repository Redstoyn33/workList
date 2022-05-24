package me.redstoyn33.worklist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class WorkListApplication extends Application {
    FXMLLoader loader = new FXMLLoader();
    public static Main main;
    public FileManager<ArrayList<PreviewData>> saver;

    public static ArrayList<Preview> listofPre = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {


        Scene scene = new Scene(loader.load(getClass().getResourceAsStream("main.fxml")), 1000, 600);
        stage.setTitle("Список дел");
        stage.setScene(scene);
        saver = new FileManager<>("./data");
        if (saver.exists()){

            saver.load().forEach(prewien -> main.list.getChildren().add(new Preview(prewien).root));
        } else {
            saver.createFile();
        }
        stage.setOnCloseRequest(windowEvent -> {
            saver.save(PreviewData.toData(listofPre));
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}