package hospitalms;
/*@author
    Saidur Rahman Sujon
*/
import java.util.Scanner;

public class HospitalMS {

    public static void main(String[] args) {
        int flag = 0;
        Scanner sc = new Scanner(System.in);
        
        //Doctor Section
        System.out.println("Enter 3 doctor's name & Specialized Sector respectively: \nDoctor 1:");
        Doctor d1 = new Doctor(sc.nextLine(), sc.nextLine());
        System.out.println("\nDoctor 2:");
        Doctor d2 = new Doctor(sc.nextLine(), sc.nextLine());
        System.out.println("\nDoctor 3:");
        Doctor d3 = new Doctor(sc.nextLine(), sc.nextLine());
        Doctor d4 = null; //Runtime Polymorphism: reference creation
        
        //Nurse Section
        System.out.println("\nEnter a Nurse Name: ");
        Nurse n = new Nurse(sc.nextLine());
        
        //Patient Section
        System.out.println("\nEnter Patient's Disease, Name & Age respectively: ");
        Patient p = new Patient(sc.nextLine(), sc.nextLine(), sc.nextInt());

        //Finding Doctor
        if (p.getDis().equals(d1.getSpecialist())) {
            d4 = d1;
            System.out.println("\nAssigned Doc: " + d4.getName());
            d4.talk();
            d4.doTreatment(p);
            n.NurseTakingCare(p);
        } else if (p.getDis().equals(d2.getSpecialist())) {
            d4 = d2;
            System.out.println("\nAssigned Doc: " + d4.getName());
            d4.talk();
            d4.doTreatment(p);
            n.NurseTakingCare(p);
        } else if (p.getDis().equals(d3.getSpecialist())) {
            d4 = d3;
            System.out.println("\nAssigned Doc: " + d4.getName());
            d4.talk();
            d4.doTreatment(p);
            n.NurseTakingCare(p);
        } else {
            flag = 1;
            System.out.println("\nNo Doctor Found, Treatment is not possible.");
        }
        
        //If doctor is available
        if (flag != 1) {
            System.out.println("How many days did the patient stay?");
            p.setWorkday(sc.nextInt());
            System.out.println("Enter Perday cost: ");
            p.perdayCost = sc.nextFloat();
        }
        
        //Displaying Info
        p.showPDNInfo(p, d4, n);
    }

}
