/**
 * Patient class
 * @author Juanfer De Leon
 */
public class Patient implements Comparable<Patient> {

    //Atributes
    String name = "";
    String sympoms = "";
    String eCode = "";

    Patient(){
    }

    Patient(String name, String symptoms, String eCode){
        setName(name);
        setSympoms(symptoms);
        seteCode(eCode);
    }

    /**
     * Compares patients priority
     * @param patient
     * @return
     */
    @Override
    public int compareTo(Patient patient){
        if (this.eCode.compareTo(patient.geteCode()) < 0){
            return (-1);
        } else if (this.eCode.compareTo(patient.geteCode()) > 0){
            return (1);
        } else if (this.eCode.compareTo(patient.geteCode()) == 0){
            return 0;
        }
        return 0;
    }

    /**
     * Returns patient name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets patient name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns patient symptoms
     * @return
     */
    public String getSympoms() {
        return sympoms;
    }

    /**
     * Sets patient symptoms
     * @param sympoms
     */
    public void setSympoms(String sympoms) {
        this.sympoms = sympoms;
    }

    /**
     * Returns Emergency(Priority) Code
     * @return
     */
    public String geteCode() {
        return eCode;
    }

    /**
     * Sets Emergency(Priority) Code
     * @param eCode
     */
    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    /**
     * Patient toString
     * @return
     */
    public String toString(){
        return "\nPatient:\n" +
                "\nName: " + getName() +
                "\nSymptoms: " + getSympoms() +
                "\nEmergency Code: " + geteCode();
    }

}
