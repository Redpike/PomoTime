package pl.com.redpike.pomotime.config;

/**
 * Created by Redpike
 */
public class PomoTimeConfig {

    /**
     * Application properties
     */
    public static final String APP_TITLE = "PomoTime";
    public static final Double APP_WIDTH = 350d;
    public static final Double APP_HEIGHT = 190d;
    public static final Integer SECONDS = 60;

    /**
     * Application view names
     */
    private static final String FXML_PREFIX = "/fxml/";
    private static final String FXML_SUFFIX = "View.fxml";
    public static final String HOME_VIEW_NAME = FXML_PREFIX + "home" + FXML_SUFFIX;

    /**
     * Other resources
     */
    public static final String APP_ICON = "/images/icon/pomodoro.png";
    public static final String BELL_PATH = "/sounds/bell.wav";
    public static final String CRANK_PATH = "/sounds/crank.wav";
}
