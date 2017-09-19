package pl.com.redpike.pomotime.model;

import javafx.scene.control.Label;

public class StatusLabel extends Label {

    private static final String STATUS_PREFIX = "PomoTime is ";

    public void setStatusText(String text) {
        setText(STATUS_PREFIX + text);
    }
}
