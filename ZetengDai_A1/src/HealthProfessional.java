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
        System.out.println("Doctor basic info:");
        System.out.println("ID:" + id);
        System.out.println("Name:" + name);
    }

    // Setters (optional but recommended)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
