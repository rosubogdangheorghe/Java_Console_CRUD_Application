package ro.sdacademy.javaremote12.menu;

import ro.sdacademy.javaremote12.consult.ConsultEntity;
import ro.sdacademy.javaremote12.doctor.DoctorEntity;
import ro.sdacademy.javaremote12.generics.RepositoryImplementation;
import ro.sdacademy.javaremote12.patient.PatientEntity;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsultMenu {

    private static RepositoryImplementation repositoryImplementation = new RepositoryImplementation();



    public static void createConsultMenu(Scanner scanner) {
        System.out.println("Start to create a consult");
        ConsultEntity consult = new ConsultEntity();
        System.out.println("Input date of the consult");
        System.out.println("year:");
        int year = scanner.nextInt();
        System.out.println("month:");
        int month = scanner.nextInt();
        System.out.println("day:");
        int day = scanner.nextInt();
        consult.setDate(LocalDate.of(year, month, day));
        System.out.println("Insert the patient id:");
        try {
            String databaseById = "from PatientEntity where id=:idNo";
            PatientEntity patient = (PatientEntity) repositoryImplementation.
                    getObjectById(PatientEntity.class,scanner.nextInt(),databaseById);
            consult.setPatient(patient);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Insert doctor id:");
        try {
            String databaseById = "from DoctorEntity where id=:idNo";
            DoctorEntity doctor = (DoctorEntity) repositoryImplementation.getObjectById(DoctorEntity.class,scanner.nextInt(),databaseById);
            consult.setDoctor(doctor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        repositoryImplementation.createObject(consult);
    }

    public static void updateConsultMenu(Scanner scanner) throws Exception {
        System.out.println("This the list of consults:");
        printConsultsListMenu();
        System.out.println("Input the ID of the consult you want to update:");
        Integer id = scanner.nextInt();
        String databaseById = "from ConsultEntity where id=:idNo";
        ConsultEntity consult = (ConsultEntity) repositoryImplementation.getObjectById(
                PatientEntity.class,id,databaseById);
        try {
            System.out.println("Input the price of the consult:");
            Double price = scanner.nextDouble();
            consult.setPrice(price);
            System.out.println("Input diagnostic");
            String diagnostic = scanner.nextLine();
            consult.setDiagnostic(diagnostic);
            repositoryImplementation.updateObject(consult);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printConsultsListMenu() {
        String database = "from ConsultEntity";
        repositoryImplementation.getAllObjects(database,ConsultEntity.class).stream().forEach(System.out::println);
    }
    public static void printOneConsultMenu(Scanner scanner) {
        System.out.println("This the list of consults:");
        printConsultsListMenu();
        System.out.println("Input the ID of the consult you want to print:");
        Integer id = scanner.nextInt();
        try {
            String databaseById = "from ConsultEntity where id=:idNo";
            ConsultEntity consult = (ConsultEntity) repositoryImplementation.getObjectById(
                    PatientEntity.class,id,databaseById);
            System.out.println(consult.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteConsultMenu(Scanner scanner) {
        System.out.println("This the list of consults:");
       printConsultsListMenu();
        System.out.println("Input the ID of the consult you want to delete:");
        Integer id = scanner.nextInt();
        try {
            String databaseById = "from ConsultEntity where id=:idNo";
            ConsultEntity consult = (ConsultEntity) repositoryImplementation.getObjectById(
                    PatientEntity.class,id,databaseById);
            System.out.println(consult.toString());
            System.out.println("Are you sure you want to delete this consult? Input yes or no");
            scanner.nextLine();
            String answer = scanner.nextLine();
            if (answer.equals("yes")) {
                repositoryImplementation.deleteObject(consult);
                System.out.println("Consult for the patient: " + consult.getPatient().getLastName() + " was cancelled");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
