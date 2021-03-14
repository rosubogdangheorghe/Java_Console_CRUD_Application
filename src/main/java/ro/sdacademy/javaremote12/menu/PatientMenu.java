package ro.sdacademy.javaremote12.menu;

import ro.sdacademy.javaremote12.generics.RepositoryImplementation;
import ro.sdacademy.javaremote12.patient.PatientEntity;

import java.time.LocalDate;
import java.util.Scanner;

public class PatientMenu {
    private static RepositoryImplementation repositoryImplementation = new RepositoryImplementation();

    public static void patientCreationMenu(Scanner scanner) {
        System.out.println("Start to create a patient");
        PatientEntity patient = new PatientEntity();
        System.out.println("Insert First Name:");
        scanner.nextLine();
        patient.setFirstName(scanner.nextLine());

        System.out.println("Insert Last Name:");
        patient.setLastName(scanner.nextLine());

        System.out.println("Insert cnp:");
        patient.setCnp(scanner.nextLine());

        System.out.println("Insert birthday year:");
        int year = scanner.nextInt();
        System.out.println("Insert birthday month:");
        int month = scanner.nextInt();
        System.out.println("Insert birthday day:");
        int day = scanner.nextInt();
        patient.setBirthday(LocalDate.of(year, month, day));
        patient.setAge();
        System.out.println("Insert phone number");
        scanner.nextLine();
        patient.setPhone(scanner.nextLine());
        repositoryImplementation.createObject(patient);
    }
    public static void patientUpdateMenu(Scanner scanner) throws Exception {
        System.out.println("This the list of patients:");
        printPatientsListMenu();
//        String database = "from PatientEntity";
//        repositoryImplementation.getAllObjects(database,PatientEntity.class).stream().forEach(System.out::println);
        System.out.println();
        System.out.println("Input the ID of the patient you want to update:");
        Integer id = scanner.nextInt();
        String databaseById =  "from PatientEntity where id=:idNo";
        PatientEntity patient = (PatientEntity) repositoryImplementation.
                getObjectById(PatientEntity.class,id,databaseById);
        System.out.println("Insert First Name:");
        scanner.nextLine();
        patient.setFirstName(scanner.nextLine());

        System.out.println("Insert Last Name:");
        patient.setLastName(scanner.nextLine());

        System.out.println("Insert cnp:");
        patient.setCnp(scanner.nextLine());

        System.out.println("Insert birthday year:");
        int year = scanner.nextInt();
        System.out.println("Insert birthday month:");
        int month = scanner.nextInt();
        System.out.println("Insert birthday day:");
        int day = scanner.nextInt();
        patient.setBirthday(LocalDate.of(year, month, day));
        patient.setAge();
        System.out.println("Insert phone number");
        scanner.nextLine();
        patient.setPhone(scanner.nextLine());
        repositoryImplementation.updateObject(patient);
    }
    public static void printPatientsListMenu() {
        String database = "from PatientEntity";
        repositoryImplementation.getAllObjects(database,PatientEntity.class).stream().forEach(System.out::println);
    }
    public static void printOnePatientMenu(Scanner scanner) throws Exception {
        System.out.println("This the list of patients:");
        printPatientsListMenu();
        System.out.println();
        System.out.println("Input the ID of the patient you want to print:");
        Integer id = scanner.nextInt();
        String databaseById = "from PatientEntity where id=:idNo";
        PatientEntity patient = (PatientEntity) repositoryImplementation.getObjectById(PatientEntity.class,id,databaseById);
        System.out.println(patient.toString());
    }
    public static void deletePatientMenu(Scanner scanner) throws Exception {
        System.out.println("This the list of patients:");
        printPatientsListMenu();
        System.out.println("Input the ID of the patient you want to delete:");
        Integer id = scanner.nextInt();
        String databaseById = "from PatientEntity where id=:idNo";
        PatientEntity patient = (PatientEntity) repositoryImplementation.getObjectById(PatientEntity.class,id,databaseById);
        System.out.println(patient.toString());
        System.out.println("Are you sure you want to delete? Input yes or no");
        scanner.nextLine();
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            repositoryImplementation.deleteObject(patient);
            System.out.println("patient " + patient.getLastName() + " was successful deleted");
        }
    }
}
