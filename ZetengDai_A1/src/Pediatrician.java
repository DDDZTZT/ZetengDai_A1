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
        System.out.println("Type:Pediatrician");
        System.out.println("Age Range:" + ageRange);
        System.out.println("==================================================================");
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
