package ro.sdacademy.javaremote12.menu;

import ro.sdacademy.javaremote12.doctor.DoctorEntity;
import ro.sdacademy.javaremote12.doctor.DoctorSpecialityEnum;
import ro.sdacademy.javaremote12.generics.RepositoryImplementation;

import java.util.Scanner;

public class DoctorMenu {
   private static RepositoryImplementation repositoryImplementation = new RepositoryImplementation();

    public static void doctorCreationMenu(Scanner scanner) {
        System.out.println("Start to Create Doctor");
        DoctorEntity doctor = new DoctorEntity();

        System.out.println("Insert First Name:");
        scanner.nextLine();
        doctor.setFirstName(scanner.nextLine());

        System.out.println("Insert Last Name:");
        doctor.setLastName(scanner.nextLine());

        System.out.println("Insert address:");
        doctor.setAddress(scanner.nextLine());
        System.out.println("Insert doctor speciality:");
        doctor.setSpeciality(DoctorSpecialityEnum.valueOf(scanner.nextLine()));
        System.out.println("Insert email:");
        doctor.setEmail(scanner.nextLine());
        System.out.println("Insert phone number:");
        doctor.setPhone(scanner.nextLine());
        repositoryImplementation.createObject(doctor);
    }

    public static void doctorUpdateMenu(Scanner scanner) throws Exception {
        System.out.println("This the list of doctors:");
        printDoctorsListMenu();
        System.out.println();
        System.out.println("Input the ID of the doctor you want to update:");
        Integer id = scanner.nextInt();
        String databaseById = "from DoctorEntity where id=:idNo";
        DoctorEntity doctor = (DoctorEntity) repositoryImplementation.getObjectById(DoctorEntity.class,id,databaseById);
        System.out.println("Insert First Name:");
        scanner.nextLine();
        doctor.setFirstName(scanner.nextLine());
        System.out.println("Insert Last Name:");
        doctor.setLastName(scanner.nextLine());
        System.out.println("Insert address:");
        doctor.setAddress(scanner.nextLine());
        System.out.println("Insert doctor speciality:");
        doctor.setSpeciality(DoctorSpecialityEnum.valueOf(scanner.nextLine()));
        System.out.println("Insert email:");
        doctor.setEmail(scanner.nextLine());
        System.out.println("Insert phone number:");
        doctor.setPhone(scanner.nextLine());
        repositoryImplementation.updateObject(doctor);
    }
    public static void printDoctorsListMenu() {
        String database = "from DoctorEntity";
        repositoryImplementation.getAllObjects(database,DoctorEntity.class).stream().forEach(System.out::println);
    }
    public static void printOneDoctorMenu(Scanner scanner) throws Exception {
        System.out.println("This the list of doctors:");
        printDoctorsListMenu();
        System.out.println();
        System.out.println("Input the ID of the doctor you want to print:");
        Integer id = scanner.nextInt();
        String databaseById = "from DoctorEntity where id=:idNo";
        DoctorEntity doctor = (DoctorEntity) repositoryImplementation.getObjectById(DoctorEntity.class,id,databaseById);
        System.out.println(doctor.toString());
    }

    public static void deleteDoctorMenu(Scanner scanner) throws Exception {
        System.out.println("This the list of doctors:");
        printDoctorsListMenu();
        System.out.println();
        System.out.println("Input the ID of the doctor you want to delete:");
        Integer id = scanner.nextInt();
        String databaseById = "from DoctorEntity where id=:idNo";
        DoctorEntity doctor = (DoctorEntity) repositoryImplementation.getObjectById(DoctorEntity.class,id,databaseById);
        System.out.println(doctor.toString());
        System.out.println("Are you sure you want to delete this Doctor? Input yes or no");
        scanner.nextLine();
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            repositoryImplementation.deleteObject(doctor);
            System.out.println("Doctor " + doctor.getLastName() + " was successful deleted");
        }
    }

}
