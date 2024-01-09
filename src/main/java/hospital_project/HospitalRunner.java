package hospital_project;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalRunner {
    static Scanner scan = new Scanner(System.in);
    static DataBase dataBase = new DataBase();

    private static Hospital hospital1 = new Hospital();

    public static void main(String[] args) {

        startApp();

    }

    private static void startApp() {
        do {
            System.out.print("1. Doctor Find\n" +
                    "2. Patient Find\n" +
                    "3. Exit\n" +
                    "What is your choice ? : ");
            int choice = intScanner(scan);
            if (choice == 1) {
                int choice1 = takePatientContion();
                setDoctorTitle(choice1);

            } else if (choice == 2) {
                int choicePatientSelection = takePatientContion();
                setPatientActuelCondition(choicePatientSelection);

            }else if (choice == 3) {
                System.out.println("Logging Out");
                break;
            } else {
                System.out.println("Please select good option !");
            }

        } while (true);
    }

    public static String doctorTitle(String actuelCondition) {
        if (actuelCondition.equalsIgnoreCase("Allergy")) {
            return dataBase.titles[0];
        } else if (actuelCondition.equalsIgnoreCase("Headache")) {
            return dataBase.titles[1];
        } else if (actuelCondition.equalsIgnoreCase("Diabetes")) {
            return dataBase.titles[2];
        } else if (actuelCondition.equalsIgnoreCase("Cold")) {
            return dataBase.titles[3];
        } else if (actuelCondition.equalsIgnoreCase("Migraine")) {
            return dataBase.titles[4];
        } else if (actuelCondition.equalsIgnoreCase("Heart Diseases")) {
            return dataBase.titles[5];
        } else {
            return "Wrong Title !";
        }

    }

    public static int intScanner(Scanner scan) {
        while (true) {
            try {
                return Math.abs(scan.nextInt());
            } catch (InputMismatchException e) {
                System.err.println("Hata: Lütfen Geçerli Bir Tamsayı Değer Girin.");
                scan.nextLine();
            }
        }
    }

    public static void setDoctorTitle(int choice) {

        String patientsCondition = dataBase.patientCondition[choice - 1];
        String title = doctorTitle(patientsCondition);
        findDoctor(title);
    }

    public static void setPatientActuelCondition(int choice) {

        String patientsCondition = dataBase.patientCondition[choice - 1];

        findPatient(patientsCondition);
    }
    public static int takePatientContion() {
        System.out.print("What is your problem ?\n" +
                "1. Allergy\n" +
                "2. Headache\n" +
                "3. Diabetes\n" +
                "4. Cold\n" +
                "5. Migraine\n" +
                "6. Heart Diseases\n" +
                "Please Select : ");
          return intScanner(scan);

    }


    public static Doctor findDoctor(String title) {
        Doctor doctor = new Doctor();
        int index = 0;

        for (int i = 0; i < dataBase.titles.length; i++) {
            if (dataBase.titles[i].equals(title)) {
                index = i;
                break;
            }
        }

        doctor.setName(dataBase.doctorNames[index]);
        doctor.setSurName(dataBase.doctorSurnames[index]);
        doctor.setTitle(dataBase.titles[index]);

        System.out.println(doctor.getName() + " " + doctor.getSurName() + " " + doctor.getTitle());
        return doctor;
    }

    public static PatientCondition findPatientCondition(String actuelCondition) {
        PatientCondition patientCondition = new PatientCondition();

        switch (actuelCondition) {
            case "Allergy":
            case "Headache":
            case "Diabetes":
            case "Cold":
                patientCondition.setUrgency(false);
                break;
            case "Migraine":
            case "Heart Diseases":
                patientCondition.setUrgency(true);
                break;
            default:
                System.out.println("This is not valid condition !");
                break;
        }
        return patientCondition;
    }

    public static Patient findPatient(String actuelCondition) {

        Patient patient = new Patient();
        int index = 0;

        for (int i = 0; i < dataBase.patientCondition.length; i++) {
            if (dataBase.patientCondition[i].equals(actuelCondition)) {
                index = i;
                break;
            }
        }

        patient.setName(dataBase.patientsNames[index]);
        patient.setSurName(dataBase.patientsSurnames[index]);
        patient.setPatientID(dataBase.patientIDs[index]);

        patient.setPatientCondition(findPatientCondition(actuelCondition));
        System.out.println(patient.getPatientID() + " " + patient.getName() + " " + patient.getSurName() +
                " " + dataBase.patientCondition[index]);
        return patient;
    }

}