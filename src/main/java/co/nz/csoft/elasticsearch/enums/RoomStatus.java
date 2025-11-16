package co.nz.csoft.elasticsearch.enums;

public enum RoomStatus {
        OCCUPIED("OCCUPIED"),
        NOT_READY("NOT_READY"),
        DO_NOT_DISTRUB("DO_NOT_DISTRUB"),
        CLEANING_IN_PROGRESS("CLEANING_IN_PROGRESS"),
        SLEEP_OUT("SLEEP_OUT"),
        ON_QUEUE("ON_QUEUE"),
        VACANT_READY("VACANT_READY"),
        CHECKING_OUT("CHECKING_OUT"),
        BLOCKED("BLOCKED"),
        LATE_CHECK_OUT("LATE_CHECK_OUT");
private String roomStatus;
        RoomStatus(String status)
        {
        this.roomStatus= roomStatus;
        }
public String getValue()
        {
        return roomStatus;
        }
        }