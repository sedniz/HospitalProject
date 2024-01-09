package hospital_project;

public class Patient {
    private String name;
    private String surName;
    private int patientID;
    private PatientCondition patientCondition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public PatientCondition getPatientCondition() {
        return patientCondition;
    }

    public void setPatientCondition(PatientCondition patientCondition) {
        this.patientCondition = patientCondition;
    }
}
