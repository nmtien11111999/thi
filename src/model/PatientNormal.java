package model;

import java.util.Date;

public class PatientNormal extends Patient {
    private double price;

    public PatientNormal( int id, int medicalCode, String name, String dateIn, String dateOut, String reason, double price) {
        super(id, medicalCode, name, dateIn, dateOut, reason);
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return " Hồ sơ bệnh án:" + getId() + " { " + " -Số thứ tự: " + getId() +
                " -Mã bệnh án: " + getMedicalCode() + " -Tên bệnh nhân: " + getName() +
                " -Ngày nhập viện: " + getDateIn() + " -Ngày ra viện: " + getDateOut() +
                " -Lý do nhập viện: " + getReason() + " -Phí nhập viện: " + getPrice();
    }
}
