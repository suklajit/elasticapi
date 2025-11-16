package co.nz.csoft.elasticsearch.thm.dto;

import java.io.Serializable;

public class WorkingHours implements Serializable {
    private  String startTime;
    private  String finishTime;
    private  String breakFromTime;
    private String breakToTime;
    private String day;
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
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
