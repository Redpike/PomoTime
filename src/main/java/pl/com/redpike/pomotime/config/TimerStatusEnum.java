package pl.com.redpike.pomotime.config;

public enum TimerStatusEnum {
    STOPPED("stopped"),
    BREAK("break"),
    RUNNING("running");

    private String statusName;

    TimerStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
