package pl.com.redpike.pomotime.config;

public enum DurationEnum {
    POMODORO("Pomodoro", 25),
    SHORT_BREAK("Short break", 5),
    LONG_BREAK("Long break", 15);

    private String statusName;
    private Integer duration;

    DurationEnum(String statusName, Integer duration) {
        this.statusName = statusName;
        this.duration = duration;
    }

    public String getStatusName() {
        return statusName;
    }

    public Integer getDuration() {
        return duration;
    }
}
