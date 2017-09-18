package pl.com.redpike.pomotime.control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import pl.com.redpike.pomotime.config.DurationEnum;
import pl.com.redpike.pomotime.model.PomoStatus;
import pl.com.redpike.pomotime.model.StatusLabel;

import static pl.com.redpike.pomotime.config.DurationEnum.*;
import static pl.com.redpike.pomotime.config.PomoTimeConfig.SECONDS;
import static pl.com.redpike.pomotime.config.TimerStatusEnum.*;

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
    private IntegerProperty completedPomodoro;
    private Timeline timeline;
    private PomoStatus pomoStatus;
    private int duration;
    private int completed;

    public HomeViewController() {
        this.timerText = new SimpleStringProperty();
        this.completedPomodoro = new SimpleIntegerProperty();

        initStatus();
        initTimeline();
    }

    public void startPomodoro() {
        pomoStatus.setTimerStatus(RUNNING);
        pomodoroStatusTitle.setStatusText(pomoStatus.getReadableStatus());
        startButton.setDisable(true);
        stopButton.setDisable(false);
        timeline.play();
    }

    public void stopPomodoro() {
        pomoStatus.setTimerStatus(STOPPED);
        pomodoroStatusTitle.setStatusText(pomoStatus.getReadableStatus());
        startButton.setDisable(false);
        stopButton.setDisable(true);
        timeline.stop();
        initTimeline();
    }

    private void initStatus() {
        pomoStatus = new PomoStatus();
        pomoStatus.setTimerStatus(STOPPED);
    }

    private void initTimeline() {
        duration = POMODORO.getDuration() * SECONDS;
        completed = 0;
        setTimerText(duration);
        setCompletedPomodoro(completed);
        timeline = new Timeline();
        timeline.setCycleCount(duration);
        timeline.setAutoReverse(false);

        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            duration -= 1;
            setTimerText(duration);
        }));

        timeline.setOnFinished(e -> {
            countCompletedPomodoros();
            setNextTimerStatus();
            setTimerText(duration);
            timeline.play();
        });
    }

    private void countCompletedPomodoros() {
        if (pomoStatus.getTimerStatus() != BREAK) {
            completed += 1;
            setCompletedPomodoro(completed);
        }
    }

    private void setNextTimerStatus() {
        if (completedPomodoro.get() % 4 != 0 && pomoStatus.getTimerStatus() != BREAK) {
            pomoStatus.setTimerStatus(BREAK);
            duration = SHORT_BREAK.getDuration() * SECONDS;
            pomodoroStatusTitle.setText(SHORT_BREAK.getStatusName());
        } else if (completedPomodoro.get() % 4 == 0 && pomoStatus.getTimerStatus() != BREAK) {
            pomoStatus.setTimerStatus(BREAK);
            duration = LONG_BREAK.getDuration() * SECONDS;
            pomodoroStatusTitle.setText(DurationEnum.LONG_BREAK.getStatusName());
        } else {
            pomoStatus.setTimerStatus(RUNNING);
            duration = POMODORO.getDuration() * SECONDS;
            pomodoroStatusTitle.setStatusText(pomoStatus.getReadableStatus());
        }
    }

    public String getTimerText() {
        return timerText.get();
    }

    public StringProperty timerTextProperty() {
        return timerText;
    }

    public void setTimerText(int remainingSeconds) {
        int minutes = remainingSeconds / SECONDS;
        int seconds = remainingSeconds % SECONDS;
        this.timerText.set(String.format("%02d:%02d", minutes, seconds));
    }

    public String getCompletedPomodoro() {
        return "Completed pomodoro: " + completedPomodoro.get();
    }

    public IntegerProperty completedPomodoroProperty() {
        return completedPomodoro;
    }

    public void setCompletedPomodoro(int completedPomodoro) {
        this.completedPomodoro.set(completedPomodoro);
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
