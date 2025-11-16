package co.nz.csoft.elasticsearch.thm.dto;

import java.io.Serializable;

public class ServiceOpen implements Serializable {
    private  String openingTime;
    private  String closingTime;
    private  String breakFromTime;
    private String breakToTime;
    private String day;

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getBreakFromTime() {
        return breakFromTime;
    }

    public void setBreakFromTime(String breakFromTime) {
        this.breakFromTime = breakFromTime;
    }

    public String getBreakToTime() {
        return breakToTime;
    }

    public void setBreakToTime(String breakToTime) {
        this.breakToTime = breakToTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


}
