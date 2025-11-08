/**
 * Class for patient appointments, storing patient info, time slot, and assigned doctor
 */
public class Appointment {
    private String patientName; // Patient's name
    private String patientMobile; // Patient's mobile (11 digits required)
    private String timeSlot; // Appointment time (format: HH:MM)
    private HealthProfessional doctor; // Assigned doctor (supports polymorphism)

    // Default constructor: Initialize default values for all attributes
    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "13800000000";
        this.timeSlot = "09:00";
        this.doctor = new HealthProfessional();
    }

    // Parameterized constructor: Validate mobile and time format before initialization
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // Mobile validation
        if (patientMobile.matches("1\\d{10}")) {
            this.patientMobile = patientMobile;
        } else {
            throw new IllegalArgumentException("The phone number must be 11 digits starting with 1.");
        }

        // Time validation
        if (timeSlot.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
            this.timeSlot = timeSlot;
        } else {
            throw new IllegalArgumentException("Time format error, it should be HH:MM (e.g., 08:00)");
        }

        this.patientName = patientName;
        this.doctor = doctor;
    }

    // Print comprehensive appointment information
    public void printAppointmentDetails() {
        System.out.println("------------ Appointment info ------------");
        System.out.println("Name:" + patientName);
        System.out.println("Phone number:" + patientMobile);
        System.out.println("Appointment time:" + timeSlot);
        System.out.println("Attending Doctor Info:");

        // Use polymorphism to call the correct method
        if (doctor instanceof GeneralPractitioner) {
            ((GeneralPractitioner) doctor).printDoctorDetails();
        } else if (doctor instanceof Pediatrician) {
            ((Pediatrician) doctor).printDoctorDetails();
        } else {
            doctor.printDetails(); // Fallback to base class method
        }
        System.out.println ("------------------------------");
    }

    // Getter for mobile (used for appointment cancellation)
    public String getPatientMobile() {
        return patientMobile;
    }

    // Other getters
    public String getPatientName() {
        return patientName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }
}
