package co.nz.csoft.elasticsearch.thm.dto;

import java.util.List;
import java.util.Map;
import java.io.Serializable;
public class DetailedView implements Serializable {
    private  Map<Integer,Map> yearWiseVisits;
   // private Map<String,Integer> monthAndNoOfVisits;
    private Integer totalNumberOfVisits;
   /*
    public Map<String, Integer> getMonthAndNoOfVisits() {
        return monthAndNoOfVisits;
    }

    public void setMonthAndNoOfVisits(Map<String, Integer> monthAndNoOfVisits) {
        this.monthAndNoOfVisits = monthAndNoOfVisits;
    }

    */

    public Integer getTotalNumberOfVisits() {
        return totalNumberOfVisits;
    }

    public void setTotalNumberOfVisits(Integer totalNumberOfVisits) {
        this.totalNumberOfVisits = totalNumberOfVisits;
    }
    public Map<Integer, Map> getYearWiseVisits() {
        return yearWiseVisits;
    }

    public void setYearWiseVisits(Map<Integer, Map> yearWiseVisits) {
        this.yearWiseVisits = yearWiseVisits;
    }
}
