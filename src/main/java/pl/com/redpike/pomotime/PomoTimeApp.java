package pl.com.redpike.pomotime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.com.redpike.pomotime.config.PomoTimeConfig;

/**
 * Created by Redpike
 */
public class PomoTimeApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(PomoTimeConfig.APP_TITLE);

        Parent root = FXMLLoader.load(getClass().getResource(PomoTimeConfig.HOME_VIEW_NAME));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(PomoTimeConfig.APP_ICON)));
        primaryStage.setScene(new Scene(root, PomoTimeConfig.APP_WIDTH, PomoTimeConfig.APP_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
