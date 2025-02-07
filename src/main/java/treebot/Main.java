package treebot;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import treebot.exception.TreeBotException;
import treebot.ui.MainWindow;

public class Main extends Application {
    private TreeBot treeBot;

    public Main() {
        try {
            treeBot = new TreeBot();
        } catch (TreeBotException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setTreeBot(treeBot);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
