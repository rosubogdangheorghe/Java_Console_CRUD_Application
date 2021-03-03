package ro.sdacademy.javaremote12;

import ro.sdacademy.javaremote12.consult.ConsultEntity;
import ro.sdacademy.javaremote12.consult.ConsultRepository;
import ro.sdacademy.javaremote12.consult.ConsultRepositoryImplementation;
import ro.sdacademy.javaremote12.doctor.DoctorEntity;
import ro.sdacademy.javaremote12.doctor.DoctorRepository;
import ro.sdacademy.javaremote12.doctor.DoctorRepositoryImplementation;
import ro.sdacademy.javaremote12.doctor.DoctorSpecialityEnum;
import ro.sdacademy.javaremote12.patient.PatientEntity;
import ro.sdacademy.javaremote12.patient.PatientRepository;
import ro.sdacademy.javaremote12.patient.PatientRepositoryImplementation;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    DoctorRepository doctorImplementation;
    PatientRepository patientImplementation;
    ConsultRepository consultImplementation;

    void startMenu() {
        doctorImplementation = new DoctorRepositoryImplementation();
        patientImplementation = new PatientRepositoryImplementation();
        consultImplementation = new ConsultRepositoryImplementation();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Start Application");
            System.out.println("Press one of the following options:");
            System.out.println("To create a doctor press    ->  1");
            System.out.println("To update a doctor press    ->  2");
            System.out.println("To print all doctors press  ->  3");
            System.out.println("To print one doctor press   ->  4");
            System.out.println("To delete one doctor press  ->  5");
            System.out.println("To create a patient press   ->  6");
            System.out.println("To update a patient press   ->  7");
            System.out.println("To print all patients press ->  8");
            System.out.println("To print one patient press  ->  9");
            System.out.println("To delete one patient press -> 10");
            System.out.println("To create a consult press   -> 11");
            System.out.println("To update a consult press   -> 12");
            System.out.println("To print all consults press -> 13");
            System.out.println("To print one consult press  -> 14");
            System.out.println("To delete one consult press -> 15");
            System.out.println("To exit application press   ->  0");
            int option = scanner.nextInt();
            switch (option) {
                case 1: {
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
                    doctorImplementation.createDoctor(doctor);
                    break;
                }
                case 2: {
                    try {
                        System.out.println("This the list of doctors:");
                        doctorImplementation.getAllDoctors().stream().forEach(System.out::println);
                        System.out.println();
                        System.out.println("Input the ID of the doctor you want to update:");
                        Integer id = scanner.nextInt();
                        DoctorEntity doctor = doctorImplementation.getDoctorById(id);
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
                        doctorImplementation.updateDoctor(doctor);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    doctorImplementation.getAllDoctors().stream().forEach(System.out::println);
                    break;
                }
                case 4: {
                    try {
                        System.out.println("This the list of doctors:");
                        doctorImplementation.getAllDoctors().stream().forEach(System.out::println);
                        System.out.println();
                        System.out.println("Input the ID of the doctor you want to print:");
                        Integer id = scanner.nextInt();
                        DoctorEntity doctor = doctorImplementation.getDoctorById(id);
                        System.out.println(doctor.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 5: {
                    try {
                        System.out.println("This the list of doctors:");
                        doctorImplementation.getAllDoctors().stream().forEach(System.out::println);
                        System.out.println();
                        System.out.println("Input the ID of the doctor you want to delete:");
                        Integer id = scanner.nextInt();
                        DoctorEntity doctor = doctorImplementation.getDoctorById(id);
                        System.out.println(doctor.toString());
                        System.out.println("Are you sure you want to delete? Input yes or no");
                        scanner.nextLine();
                        String answer = scanner.nextLine();
                        if (answer.equals("yes")) {
                            doctorImplementation.deleteDoctor(id);
                            System.out.println("Doctor " + doctor.getLastName() + " was successful deleted");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 6: {
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
                    patientImplementation.createPatient(patient);
                    break;
                }
                case 7: {
                    try {
                        System.out.println("This the list of patients:");
                        patientImplementation.getAllPatients().stream().forEach(System.out::println);
                        System.out.println();
                        System.out.println("Input the ID of the patient you want to update:");
                        Integer id = scanner.nextInt();
                        PatientEntity patient = patientImplementation.getPatientById(id);
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
                        patientImplementation.updatePatient(patient);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 8: {
                    patientImplementation.getAllPatients().stream().forEach(System.out::println);
                    break;
                }
                case 9: {
                    try {
                        System.out.println("This the list of patients:");
                        patientImplementation.getAllPatients().stream().forEach(System.out::println);
                        System.out.println();
                        System.out.println("Input the ID of the patient you want to print:");
                        Integer id = scanner.nextInt();
                        PatientEntity patient = patientImplementation.getPatientById(id);
                        System.out.println(patient.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 10: {
                    try {
                        System.out.println("This the list of patients:");
                        patientImplementation.getAllPatients().stream().forEach(System.out::println);
                        System.out.println("Input the ID of the patient you want to delete:");
                        Integer id = scanner.nextInt();
                        PatientEntity patient = patientImplementation.getPatientById(id);
                        System.out.println(patient.toString());
                        System.out.println("Are you sure you want to delete? Input yes or no");
                        scanner.nextLine();
                        String answer = scanner.nextLine();
                        if (answer.equals("yes")) {
                            patientImplementation.deletePatient(id);
                            System.out.println("patient " + patient.getLastName() + " was successful deleted");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 11: {
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
                        PatientEntity patient = patientImplementation.getPatientById(scanner.nextInt());
                        consult.setPatient(patient);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Insert doctor id:");
                    try {
                        DoctorEntity doctor = doctorImplementation.getDoctorById(scanner.nextInt());
                        consult.setDoctor(doctor);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    consultImplementation.createConsult(consult);
                    break;
                }
                case 12: {
                    System.out.println("This the list of consults:");
                    consultImplementation.getAllConsults().stream().forEach(System.out::println);
                    System.out.println("Input the ID of the consult you want to update:");
                    Integer id = scanner.nextInt();
                    try {
                        System.out.println("Input the price of the consult:");
                        Double price = scanner.nextDouble();
                        System.out.println("Input diagnostic");
                        scanner.nextLine();
                        String diagnostic = scanner.nextLine();
                        consultImplementation.updateConsult(id, price, diagnostic);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 13: {
                    consultImplementation.getAllConsults().stream().forEach(System.out::println);
                    break;
                }
                case 14: {
                    System.out.println("This the list of consults:");
                    consultImplementation.getAllConsults().stream().forEach(System.out::println);
                    System.out.println("Input the ID of the consult you want to print:");
                    Integer id = scanner.nextInt();
                    try {
                        ConsultEntity consult = consultImplementation.getConsultById(id);
                        System.out.println(consult.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 15: {
                    System.out.println("This the list of consults:");
                    consultImplementation.getAllConsults().stream().forEach(System.out::println);
                    System.out.println("Input the ID of the consult you want to delete:");
                    Integer id = scanner.nextInt();
                    try {
                        ConsultEntity consult = consultImplementation.getConsultById(id);
                        System.out.println(consult.toString());
                        System.out.println("Are you sure you want to delete this consult? Input yes or no");
                        scanner.nextLine();
                        String answer = scanner.nextLine();
                        if (answer.equals("yes")) {
                            consultImplementation.deleteConsult(id);
                            System.out.println("Consult with id: " + id + " was successful deleted");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                default:
                    return;
            }
        }
    }
}
