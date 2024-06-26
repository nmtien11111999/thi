package handleModel;

import model.PatientNormal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandlePatientNormal {
     List<PatientNormal> patients = new ArrayList<>();
     Scanner inputString = new Scanner(System.in);
     Scanner inputdouble = new Scanner(System.in);
    int id = 0;

    Scanner inputInt = new Scanner(System.in);

    public void addPatient(){
        readPatientNormal();
        if (handlePatient() != null){
            patients.add(handlePatient());
            System.out.println(" Thêm thành công: ");
        }
        writePatientNormal();
    }

    public PatientNormal handlePatient(){
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
            System.out.println(" Nhập giá tiền ");
            double price = inputdouble.nextDouble();
            return new PatientNormal(id++, medicalCode,name,dateIn,dateOut,reason,price);
        } catch (Exception e){
            System.out.println(" Nhập sai định dạng ");
        }
        return null;
    }

    public void removePatient(int medicalCode){
        readPatientNormal();
        try {
            for (PatientNormal patient : patients){
                if (medicalCode == patient.getMedicalCode()){
                    System.out.println(" Bạn có chắc là muốn xóa: ");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice = inputInt.nextInt();
                    switch (choice){
                        case 1:
                            patients.remove(patient);
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

    public void displayPatientNormal(){
        readPatientNormal();
        for (PatientNormal patient : patients){
            System.out.println(" Hồ sơ bệnh án:"+patient.getId()+" -Mã bệnh án: " + patient.getMedicalCode() + " -Tên bệnh nhân: "+patient.getName()+" -Ngày nhập viện: "+patient.getDateIn()+ " - Ngày ra viện: "+patient.getDateOut()+" -Lý do nhập viện: "+patient.getReason() );
        }
    }
    public void readPatientNormal(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("medical_records.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                int medicalCode = Integer.parseInt(tokens[1]);
                String name = tokens[2];
                String dateIn = tokens[3];
                String dateOut = tokens[4];
                String reason = tokens[5];
                double price = Double.parseDouble(tokens[6]);
                patients.add(new PatientNormal(id,medicalCode,name,dateIn,dateOut,reason,price));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writePatientNormal(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("medical_records.csv"))) {
            for (PatientNormal patient : patients){
                bufferedWriter.write(patient.getId()+","+patient.getMedicalCode()+","+patient.getName()+","+patient.getDateIn()+","
                        +patient.getDateOut()+","+patient.getReason()+","+patient.getPrice());
                bufferedWriter.newLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
