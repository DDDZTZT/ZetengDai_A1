/**
 * Base class for all health professionals, containing common attributes (ID, name)
 */
public class HealthProfessional {
    private String id; // Unique ID (numbers only)
    private String name; // Professional's full name

    // Default constructor: Initialize default values for ID and name
    public HealthProfessional() {
        this.id = "000000";
        this.name = "Unknown";
    }

    // Corrected constructor - removed the unused 'department' parameter
    public HealthProfessional(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters for accessing private attributes
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Print basic information of the health professional
    public void printDetails() {
        System.out.println("Doctor basic info：");
        System.out.println("ID：" + id);
        System.out.println("Name：" + name);
    }

    // Setters (optional but recommended)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * Child class of HealthProfessional, representing general practitioners
 */
public class GeneralPractitioner extends HealthProfessional {
    private String specializedDiseases;

    public GeneralPractitioner() {
        super();
        this.specializedDiseases = "Common General Medical Conditions";
    }

    // Corrected constructor - matches the base class constructor
    public GeneralPractitioner(String id, String name, String specializedDiseases) {
        super(id, name); // Only pass id and name to the parent constructor
        this.specializedDiseases = specializedDiseases;
    }

    // Print comprehensive information
    public void printDoctorDetails() {
        System.out.println("==================== GeneralPractitioner info ====================");
        super.printDetails(); // Call the base class method to print general information
        System.out.println("Type: General Practitioner");
        System.out.println("Specialize：" + specializedDiseases);
        System.out.println("======================================================");
    }

    // Getter for specialized diseases
    public String getSpecializedDiseases() {
        return specializedDiseases;
    }

    // Setter for specialized diseases
    public void setSpecializedDiseases(String specializedDiseases) {
        this.specializedDiseases = specializedDiseases;
    }
}

/**
 * Child class of HealthProfessional, representing pediatricians
 */
public class Pediatrician extends HealthProfessional {
    private String ageRange; // Patient age range accepted

    public Pediatrician() {
        super();
        this.ageRange = "0-14";
    }

    // Corrected constructor - matches the base class constructor
    public Pediatrician(String id, String name, String ageRange) {
        super(id, name); // Only pass id and name to the parent constructor
        this.ageRange = ageRange;
    }

    // Print comprehensive information of the pediatrician
    public void printDoctorDetails() {
        System.out.println("==================== Pediatrician info ====================");
        super.printDetails();
        System.out.println("Type：Pediatrician");
        System.out.println("Age Range：" + ageRange);
        System.out.println("======================================================");
    }

    // Getter for age range
    public String getAgeRange() {
        return ageRange;
    }

    // Setter for age range
    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }
}

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
        System.out.println("---------------- Appointment info ----------------");
        System.out.println("Name：" + patientName);
        System.out.println("Phone number：" + patientMobile);
        System.out.println("Appointment time：" + timeSlot);
        System.out.println("Attending Doctor Info：");

        // Use polymorphism to call the correct method
        if (doctor instanceof GeneralPractitioner) {
            ((GeneralPractitioner) doctor).printDoctorDetails();
        } else if (doctor instanceof Pediatrician) {
            ((Pediatrician) doctor).printDoctorDetails();
        } else {
            doctor.printDetails(); // Fallback to base class method
        }
        System.out.println("----------------------------------------");
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

/**
 * Main class for the health service appointment system
 */
public class Main {

}
