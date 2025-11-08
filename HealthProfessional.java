/**
 * Base class for all health professionals, containing common attributes (ID, name)
 */
public class HealthProfessional {
    private String id; // Unique ID (numbers only)
    private String name; // Professional's full name
    private String status; // Professional's working status
    private String gender; // Professional's gender

    // Default constructor: Initialize default values for ID, name, status and gender
    public HealthProfessional() {
        this.id = "000000";
        this.name = "Unknown";
        this.status = "Active";
        this.gender = "Not Specified";
    }

    // Full constructor: Initialize all attributes
    public HealthProfessional(String id, String name, String status, String gender) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.gender = gender;
    }
    // Getters for accessing private attributes
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() { return status; }

    public String getGender() { return gender; }

    // Print basic information of the health professional
    public void printDetails() {
        System.out.println("Doctor basic info:");
        System.out.println("ID:" + id);
        System.out.println("Name:" + name);
        System.out.println("Status:" + status);
        System.out.println("Gender:" + gender);
    }

    // Setters (optional but recommended)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) { this.status = status; }

    public void setGender(String gender) { this.gender = gender; }
}
