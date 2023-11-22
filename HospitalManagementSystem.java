import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Patient {
    private String id;
    private String name;
    private int age;
    private String gender;

    public Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Patient{id='" + id + "', name='" + name + "', age=" + age + ", gender='" + gender + "'}";
    }
}

class Hospital {
    private ArrayList<Patient> patients;

    public Hospital() {
        patients = new ArrayList<>();
    }

    public void admitPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient admitted: " + patient);
    }

    public void deletePatient(String patientId) {
        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            Patient patient = iterator.next();
            if (patient.getId().equals(patientId)) {
                iterator.remove();
                System.out.println("Patient deleted: " + patient);
                return;
            }
        }
        System.out.println("Patient with ID " + patientId + " not found.");
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients in the hospital.");
        } else {
            System.out.println("List of patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }
}

public class HospitalManagementSystem {
    private static final String USERNAME = "nazmul";
    private static final String PASSWORD = "1081";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login System
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (!enteredUsername.equals(USERNAME) || !enteredPassword.equals(PASSWORD)) {
            System.out.println("Invalid username or password. Exiting the system.");
            return;
        }

        // If login is successful, continue with the hospital management system
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Admit Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter patient gender: ");
                    String gender = scanner.nextLine();

                    Patient newPatient = new Patient(id, name, age, gender);
                    hospital.admitPatient(newPatient);
                    break;
                case 2:
                    hospital.displayPatients();
                    break;
                case 3:
                    System.out.print("Enter patient ID to delete: ");
                    String patientIdToDelete = scanner.nextLine();
                    hospital.deletePatient(patientIdToDelete);
                    break;
                    case 4:
                    System.out.println("Exiting the Hospital Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
