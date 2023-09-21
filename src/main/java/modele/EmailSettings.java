package modele;

import java.sql.Time;

public class EmailSettings {
    private static final int id = 1;
    private int frequency;
    private Time time;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public EmailSettings() {
    }
}
