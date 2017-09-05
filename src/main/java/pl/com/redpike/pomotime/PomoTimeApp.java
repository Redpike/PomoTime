package pl.com.redpike.pomotime;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.com.redpike.pomotime.config.PomoTimeConfig;

/**
 * Created by Redpike
 */
public class PomoTimeApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(PomoTimeConfig.APP_TITLE);
        Button button = new Button();
        button.setText("Say 'Hello World'");

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        primaryStage.setScene(new Scene(stackPane, PomoTimeConfig.APP_WIDTH, PomoTimeConfig.APP_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
