package gameassets;

import javax.swing.*;
import java.text.DecimalFormat;

public class GameTimer {
    private int seconds, minutes;
    private String ddSeconds, ddMinutes;
    private javax.swing.Timer timer;
    public JLabel counter;

    private final int delay;

    public GameTimer(int delay) {
        this.delay = delay;
        initTimer();
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public String getTimer() {
        return counter.getText();
    }

    private void initTimer() {
        DecimalFormat ddFormat = new DecimalFormat("00");
        counter = new JLabel("00:00");
        counter.setHorizontalAlignment(JLabel.CENTER);
        counter.setVerticalAlignment(JLabel.CENTER);
        counter.setFont(Constants.DISPLAY_FONT);
        counter.setForeground(Constants.LIGHT);
        timer = new javax.swing.Timer(delay, e -> {
            seconds = (seconds + 1) % 60;
            ddSeconds = ddFormat.format(seconds);
            minutes += seconds == 0 ? 1 : 0;
            ddMinutes = ddFormat.format(minutes);
            counter.setText(ddMinutes + ":" + ddSeconds);
        });
    }

}
