package co.nz.csoft.elasticsearch.enums;

public enum RoomTypeStatus {
    Close("Close"),
    Open("Open"),
    None("None");
    private final String roomTypeStatus;

    private RoomTypeStatus(String roomTypeStatus) {
        this.roomTypeStatus = roomTypeStatus;
    }

    public String value() {
        return this.roomTypeStatus;
    }

    @Override
    public String toString() {
        return roomTypeStatus;
    }
}
