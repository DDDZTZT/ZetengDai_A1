/**
 * Main class for the health service appointment system
 */

public class Main {
    public static void main(String[] args) {
        
        // Create three General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner("GP001", "Dr. Smith", "Common Illnesses");
        GeneralPractitioner gp2 = new GeneralPractitioner("GP002", "Dr. Johnson", "Chronic Diseases");
        GeneralPractitioner gp3 = new GeneralPractitioner("GP003", "Dr. Brown", "Preventive Care");
        
        // Create two Pediatrician objects
        Pediatrician pd1 = new Pediatrician("PD001", "Dr. Wilson", "0-12 years");
        Pediatrician pd2 = new Pediatrician("PD002", "Dr. Davis", "0-14 years");
        
        // Print all health professionals
        gp1.printDoctorDetails();
        gp2.printDoctorDetails();
        gp3.printDoctorDetails();
        pd1.printDoctorDetails();
        pd2.printDoctorDetails();
        }
    }