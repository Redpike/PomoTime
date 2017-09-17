package pl.com.redpike.pomotime.config;

public enum TimerStatusEnum {
    STOPPED("stopped"),
    PAUSED("paused"),
    RUNNING("running");

    private String statusName;

    TimerStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
