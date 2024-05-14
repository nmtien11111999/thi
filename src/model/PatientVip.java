package model;

import java.util.Date;

public class PatientVip extends Patient {
    private String typeVip;
    private String dateVip;

    public PatientVip(int id, int medicalCode, String name, String dateIn, String dateOut, String reason, String typeVip,String dateVip) {
        super(id, medicalCode, name, dateIn, dateOut, reason);
        this.typeVip = typeVip;
        this.dateVip = dateVip;
    }

    public String getTypeVip() {
        return typeVip;
    }

    public void setTypeVip(String typeVip) {
        this.typeVip = typeVip;
    }

    public String getDateVip() {
        return dateVip;
    }

    public void setDateVip(String dateVip) {
        this.dateVip = dateVip;
    }



    @Override
    public String toString() {
        return " Hồ sơ bệnh án:" + getId() + " { " + " -Số thứ tự: " + getId() +
                " -Mã bệnh án: " + getMedicalCode() + " -Tên bệnh nhân: " + getName() +
                " -Ngày nhập viện: " + getDateIn() + " -Ngày ra viện: " + getDateOut() +
                " -Lý do nhập viện: " + getReason() + " -Gói vip: " + getTypeVip() + " -Thời hạn gói: " + getDateVip();
    }
}
