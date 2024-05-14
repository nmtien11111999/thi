package model;

import java.util.Date;

public class PatientVip extends Patient {
    private String typeVip;
    private Date dateVip;

    public PatientVip(int id, int medicalCode, String name, String dateIn, String dateOut, String reason, String typeVip,Date dateVip) {
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

    public Date getDateVip() {
        return dateVip;
    }

    public void setDateVip(Date dateVip) {
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
