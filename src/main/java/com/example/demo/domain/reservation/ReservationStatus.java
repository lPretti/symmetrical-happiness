package com.example.demo.domain.reservation;

public enum ReservationStatus {

    PENDING,
    REJECTED,
    ACCEPTED,
    CANCELED;

    public static ReservationStatus getStatus(String status) {
        ReservationStatus result;
        switch (status) {
            case "PENDING" :
                result = ReservationStatus.PENDING;
                break;
            case "REJECTED" :
                result = ReservationStatus.REJECTED;
                break;
            case "ACCEPTED" :
                result = ReservationStatus.ACCEPTED;
                break;
            case "CANCELED" :
                result = ReservationStatus.CANCELED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
        return result;
    }
}
