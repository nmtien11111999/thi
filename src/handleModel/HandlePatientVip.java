package handleModel;

import model.PatientNormal;
import model.PatientVip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandlePatientVip {
    List<PatientVip> patientsVip = new ArrayList<>();
    Scanner inputString = new Scanner(System.in);

    int id = 0;

    Scanner inputInt = new Scanner(System.in);

    public void addPatient(){
        readPatientNormal();
//        patientsVip.add(handlePatient());
        System.out.println(" Thêm thành công: ");
        writePatientNormal();
    }

    public void removePatient(int medicalCode){
        readPatientNormal();
        try {
            for (PatientVip patient : patientsVip){
                if (medicalCode == patient.getMedicalCode()){
                    System.out.println(" Bạn có chắc là muốn xóa: ");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice = inputInt.nextInt();
                    switch (choice){
                        case 1:
                            patientsVip.remove(patient);
                            System.out.println(" Xóa thành công: ");
                            writePatientNormal();
                            return;
                        case 2:
                            return;
                        default:
                            System.out.println(" Nhập sai định dạng");
                    }
                }
            }
            System.out.println(" Không tìm thấy mã bệnh án: ");
        } catch (Exception e){
            System.out.println(" Nhập sai định dạng ");
        }
    }

    public PatientVip handlePatient(){
        try {
            System.out.print(" Nhập mã bệnh án ");
            int medicalCode = inputInt.nextInt();
            System.out.print(" Nhập tên bệnh nhân ");
            String name = inputString.nextLine();
            System.out.print(" Ngày nhập viện ");
            String dateIn = inputString.nextLine();
            System.out.println(" Ngay ra viện ");
            String dateOut = inputString.nextLine();
            System.out.println(" lý do nhập viện ");
            String reason = inputString.nextLine();
            System.out.println(" Nhập loại vip ");
            String vip = inputString.nextLine();
            System.out.println(" Nhập thời hạn vip ");
            String date = inputString.nextLine();
            return new PatientVip(id++, medicalCode,name,dateIn,dateOut,reason,vip,date);
        } catch (Exception e){
            System.out.println(" Nhập sai định dạng ");
        }
        return null;
    }

    public void displayPatientNormal(){
        readPatientNormal();
        for (PatientVip patient : patientsVip){
            System.out.println(" Hồ sơ bệnh án:"+patient.getId()+" -Mã bệnh án: " + patient.getMedicalCode() + " -Tên bệnh nhân: "+patient.getName()+" -Ngày nhập viện: "+patient.getDateIn()+ " - Ngày ra viện: "+patient.getDateOut()+" -Lý do nhập viện: "+patient.getReason() );
        }
    }
    public void readPatientNormal(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("medicalVip_records.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                int medicalCode = Integer.parseInt(tokens[1]);
                String name = tokens[2];
                String dateIn = tokens[3];
                String dateOut = tokens[4];
                String reason = tokens[5];
                String typeVip = tokens[6];
                String date = tokens[7];
                patientsVip.add(new PatientVip(id,medicalCode,name,dateIn,dateOut,reason,typeVip,date));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writePatientNormal(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("medicalVip_records.csv"))) {
            for (PatientVip patient : patientsVip){
                bufferedWriter.write(patient.getId()+","+patient.getMedicalCode()+","+patient.getName()+","+patient.getDateIn()+","
                        +patient.getDateOut()+","+patient.getReason()+","+patient.getTypeVip()+","+patient.getDateVip());
                bufferedWriter.newLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
