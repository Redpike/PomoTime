package pl.com.redpike.pomotime.model;

import pl.com.redpike.pomotime.config.TimerStatusEnum;

public class PomoStatus {

    private TimerStatusEnum timerStatus;

    public TimerStatusEnum getTimerStatus() {
        return timerStatus;
    }

    public void setTimerStatus(TimerStatusEnum timerStatus) {
        this.timerStatus = timerStatus;
    }

    public String getReadableStatus() {
        return this.timerStatus.getStatusName();
    }
}
