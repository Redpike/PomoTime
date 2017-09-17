package pl.com.redpike.pomotime.control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import pl.com.redpike.pomotime.config.DurationEnum;
import pl.com.redpike.pomotime.config.PomoTimeConfig;
import pl.com.redpike.pomotime.config.TimerStatusEnum;
import pl.com.redpike.pomotime.model.PomoStatus;
import pl.com.redpike.pomotime.model.StatusLabel;

/**
 * Created by Redpike
 */
public class HomeViewController {

    @FXML
    private VBox mainContainer;

    @FXML
    private StatusLabel pomodoroStatusTitle;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    private StringProperty timerText;
    private Timeline timeline;
    private PomoStatus pomoStatus;
    private int duration;

    public HomeViewController() {
        this.timerText = new SimpleStringProperty();

        initStatus();
        initTimeline();
    }

    public void startPomodoro() {
        pomoStatus.setTimerStatus(TimerStatusEnum.RUNNING);
        pomodoroStatusTitle.setStatusText(pomoStatus.getReadableStatus());
        startButton.setDisable(true);
        stopButton.setDisable(false);
        timeline.play();
    }

    public void stopPomodoro() {
        pomoStatus.setTimerStatus(TimerStatusEnum.STOPPED);
        pomodoroStatusTitle.setStatusText(pomoStatus.getReadableStatus());
        startButton.setDisable(false);
        stopButton.setDisable(true);
        timeline.stop();
        initTimeline();
    }

    private void initStatus() {
        pomoStatus = new PomoStatus();
        pomoStatus.setTimerStatus(TimerStatusEnum.STOPPED);
    }

    private void initTimeline() {
        duration = DurationEnum.POMODORO.getDuration() * PomoTimeConfig.SECONDS;
        setTimerText(duration);
        timeline = new Timeline();
        timeline.setCycleCount(duration);
        timeline.setAutoReverse(false);

        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            duration--;
            setTimerText(duration);
        }));

        timeline.setOnFinished(e -> pomodoroStatusTitle.setText("Break"));
    }

    public String getTimerText() {
        return timerText.get();
    }

    public StringProperty timerTextProperty() {
        return timerText;
    }

    public void setTimerText(int remainingSeconds) {
        int minutes = remainingSeconds / PomoTimeConfig.SECONDS;
        int seconds = remainingSeconds % PomoTimeConfig.SECONDS;
        this.timerText.set(String.format("%02d:%02d", minutes, seconds));
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
