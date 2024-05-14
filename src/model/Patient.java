package model;

import java.util.Date;

public abstract class Patient {
    private int id = 0;
    private int medicalCode;
    private String name;
    private String dateIn;
    private String dateOut;
    private String reason;

    public Patient(int id, int medicalCode, String name, String dateIn, String dateOut, String reason) {
        this.id = id;
        this.medicalCode = medicalCode;
        this.name = name;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(int medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
