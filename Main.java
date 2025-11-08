/**
 * Main class for the health service appointment system
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();
    private static ArrayList<HealthProfessional> doctors = new ArrayList<>();
    public static void main(String[] args) {
        initDoctors();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("------ Health Service Appointment System ------");

        while (running) {
            printMenu();
            System.out.print("Please enter the operation number: ");

            // ensure only numbers
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error! Please enter numbers");
                continue;
            }

            // according number to operate
            switch (choice) {
                case 1:
                    createAppointmentMenu(scanner);
                    break;
                case 2:
                    printExistingAppointments();
                    break;
                case 3:
                    cancelBookingMenu(scanner);
                    break;
                case 4:
                    printAllDoctors();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exit! Thank for your using");
                    break;
                default:
                    System.out.println("Invalid operation number, please try again");
            }
        }
        scanner.close();
    }

    //print the menu
    private static void printMenu() {
        System.out.println("\n----- Menu -----");
        System.out.println("1. Create a new appointment");
        System.out.println("2. Check all appointment");
        System.out.println("3. Cancel appointment");
        System.out.println("4. Check doctor list");
        System.out.println("5. Exit");
        System.out.println("------------------------------");
        }

    private static void initDoctors(){
        // Part 3 – Using classes and objects
        // Create three General Practitioner objects
        doctors.add(new GeneralPractitioner("GP001", "Dr. Smith", "Active", "Male", "Common Illnesses"));
        doctors.add(new GeneralPractitioner("GP002", "Dr. Johnson", "Active", "Male", "Chronic Diseases"));
        doctors.add(new GeneralPractitioner("GP003", "Dr. Brown", "Active", "Female", "Preventive Care"));

        // Create two Pediatrician objects
        doctors.add(new Pediatrician("PD001", "Dr. Wilson", "Active", "Male", "0-12 years"));
        doctors.add(new Pediatrician("PD002", "Dr. Davis", "Active", "Female", "0-14 years"));

    }

    private static void printAllDoctors() {
        System.out.println("\n----- Doctor list -----");
        if (doctors.isEmpty()) {
            System.out.println("No doctor information available at the moment");
            return;
        }
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            HealthProfessional doc = doctors.get(i);
            if (doc instanceof GeneralPractitioner) {
                ((GeneralPractitioner) doc).printDoctorDetails();
            } else if (doc instanceof Pediatrician) {
                ((Pediatrician) doc).printDoctorDetails();
            } else {
                doc.printDetails();
            }
        }
    }

    // 创建预约的交互菜单
    private static void createAppointmentMenu(Scanner scanner) {
        System.out.println("\n----- Create a new appointment -----");

        // 选择医生
        System.out.println("Please choose the doctor (Enter doctor number):");
        printDoctorShortList();
        int doctorIndex;
        try {
            doctorIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (doctorIndex < 0 || doctorIndex >= doctors.size()) {
                System.out.println("Invalid doctor number");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error! Please enter numbers");
            return;
        }
        HealthProfessional selectedDoctor = doctors.get(doctorIndex);

        // 输入患者信息
        System.out.print("Please enter your name: ");
        String patientName = scanner.nextLine().trim();

        System.out.print("Please enter the appointment phone number (11 numbers ): ");
        String patientMobile = scanner.nextLine().trim();

        System.out.print("Please enter the appointment time(Form: HH:MM): ");
        String timeSlot = scanner.nextLine().trim();

        // 调用创建预约方法
        createAppointment(patientName, patientMobile, timeSlot, selectedDoctor);
    }

    // 简要显示医生列表（用于选择）
    private static void printDoctorShortList() {
        for (int i = 0; i < doctors.size(); i++) {
            HealthProfessional doc = doctors.get(i);
            String type = doc instanceof GeneralPractitioner ? "General Practitioner" : "Pediatrician";
            System.out.println((i + 1) + ". " + doc.getName() + " (" + type + ", ID:" + doc.getId() + ")");
        }
    }

    // 取消预约的交互菜单
    private static void cancelBookingMenu(Scanner scanner) {
        System.out.println("\n----- Cancel Appointment -----");
        System.out.print("Please enter the phone number: ");
        String mobile = scanner.nextLine().trim();
        cancelBooking(mobile);
    }

    // Part 5 – Collection of appointments
    // crate appointment and add
    private static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // check is it null or not
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Failed to create appointment: Patient name cannot be empty!");
            return; // null, return do not run code
        }

        if (doctor == null) {
            System.out.println("Failed to create appointment: No doctor assigned!");
            return;
        }

        boolean isMobileValid = patientMobile != null && patientMobile.matches("1\\d{10}");
        if (!isMobileValid) {
            System.out.println("Failed to create appointment: The phone number must be 11 digits starting with 1.");
            return;
        }

        boolean isTimeValid = timeSlot != null && timeSlot.matches("([01]\\d|2[0-3]):[0-5]\\d");
        if (!isTimeValid) {
            System.out.println("Failed to create appointment: Time format error, it should be HH:MM (e.g., 08:00)");
            return;
        }

        //all not null create appointment
        Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppointment);
        System.out.println("Appointment created successfully for patient: " + patientName);
    }

    //print the all appointment
    private static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No existing appointments in the system.");
            return;
        }

        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("\n[Appointment " + (i + 1) + "]");
            appointmentList.get(i).printAppointmentDetails();
        }
    }

    //accord the phone number to delete the appointment
    private static void cancelBooking(String targetMobile) {
        boolean isCanceled = false;

        // ues equals() to compare the phone number
        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment appt = appointmentList.get(i);
            if (appt.getPatientMobile().equals(targetMobile)) {
                // find teh phone number and delete
                appointmentList.remove(i);
                System.out.println("Successfully canceled appointment for patient with mobile: " + targetMobile);
                isCanceled = true;
                break; // assume a phone number just have one appointment and break
            }
        }

        // if not find
        if (!isCanceled) {
            System.out.println("No appointment found for mobile number: " + targetMobile);
        }
    }
}



