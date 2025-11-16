package co.nz.csoft.elasticsearch.enums;

public enum ChannelManagerUpdateType {
    ROOM_RATE_PLAN("Room Rate Plan"),
    AVAILABILITY_UPDATE("Availability"),
    ROOM_PLAN_RESTRICTION("Room Plan Restriction"),
    STOP_SELL("Stop Sell"),
    CLOSE_TO_ARRIVAL("Closed To Arrival"),
    CLOSE_TO_DEPARTURE("Closed To Departure"),
    MIN_LOS("Minimum Length Of Stay"),
    MAX_LOS("Maximum Length Of Stay");

    private final String updateType;

    private ChannelManagerUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String value() {
        return this.updateType;
    }

    @Override
    public String toString() {
        return updateType;
    }
}
