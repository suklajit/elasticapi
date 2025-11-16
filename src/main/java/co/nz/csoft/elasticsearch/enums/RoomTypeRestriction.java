package co.nz.csoft.elasticsearch.enums;

public enum RoomTypeRestriction {
    Arrival("Arrival"),
    Departure("Departure"),
    None("None");
    private final String roomTypeRestriction;
    private RoomTypeRestriction(String roomTypeRestriction) {
        this.roomTypeRestriction = roomTypeRestriction;
    }

    public String value() {
        return this.roomTypeRestriction;
    }

    @Override
    public String toString() {
        return roomTypeRestriction;
    }
}
