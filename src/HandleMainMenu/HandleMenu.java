package HandleMainMenu;

import MainMenu.Menu;
import handleModel.HandlePatientNormal;
import handleModel.HandlePatientVip;

import java.util.Scanner;

public class HandleMenu {
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    Scanner inputdouble = new Scanner(System.in);
    HandlePatientNormal handlePatientNormal = new HandlePatientNormal();
    HandlePatientVip handlePatientVip = new HandlePatientVip();
    public void HandleMain(){
       try {
           while (true){
               Menu.MainMenu();
               switch (choice()){
                   case 1:
                       addPatient();
                       break;
                   case 2:
                   case 3:
                       System.out.println(" Hiển thị danh sách bệnh nhân thuòng");
                       handlePatientNormal.displayPatientNormal();
                       break;
                   case 4:
                       System.out.println(" Hiển thị bệnh nhân vip");
                       handlePatientVip.displayPatientNormal();
                       break;
                   case 5:
                       return;
                   default:
                       System.out.println(" nhập sai định dạng");
                       break;
               }
           }
       } catch (Exception e){
           System.out.println(" Nhập sai định dạng");
       }
    }

    public void addPatient(){
        try {
            while (true){
                System.out.println(" Nhập lựa chọn: ");
                System.out.println("1. Thêm vào khách thường ");
                System.out.println("2. Thêm vào khách Vip");
                switch (choice()){
                    case 1:
                        handlePatientNormal.addPatient();
                        break;
                    case 2:
                        handlePatientVip.addPatient();
                        break;
                    default:
                        System.out.println(" Nhập sai định dạng ");
                        break;
                }
            }
        } catch (Exception e){
            System.out.println(" nhập sai định dạng ");
        }
    }

    public int choice(){
        try {
            System.out.println(" nhập lựa chọn ");
            int choice = inputInt.nextInt();
            return choice;
        } catch (Exception e){
            inputInt.nextLine();
            return -1;
        }
    }

}
