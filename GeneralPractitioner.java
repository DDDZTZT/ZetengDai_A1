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
    public GeneralPractitioner(String id, String name, String status, String gender, String specializedDiseases) {
        super(id, name, status, gender); // Only pass id and name to the parent constructor
        this.specializedDiseases = specializedDiseases;
    }

    // Print comprehensive information
    public void printDoctorDetails() {
        System.out.println("------------ GeneralPractitioner info ------------");
        super.printDetails(); // Call the base class method to print general information
        System.out.println("Type: General Practitioner");
        System.out.println("Specialize:" + specializedDiseases);
        System.out.println ("------------------------------");
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
