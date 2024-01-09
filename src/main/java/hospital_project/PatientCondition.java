package hospital_project;

public class PatientCondition {
    private String actualCondition;
    private boolean urgency;

    public String getActualCondition() {
        return actualCondition;
    }

    public void setActualCondition(String actualCondition) {
        this.actualCondition = actualCondition;
    }

    public boolean isUrgency() {
        return urgency;
    }

    public void setUrgency(boolean urgency) {
        this.urgency = urgency;
    }
}
