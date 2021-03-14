package ro.sdacademy.javaremote12;

import ro.sdacademy.javaremote12.generics.RepositoryImplementation;
import java.util.Scanner;

import static ro.sdacademy.javaremote12.menu.DoctorMenu.*;
import static ro.sdacademy.javaremote12.menu.PatientMenu.*;
import static ro.sdacademy.javaremote12.menu.ConsultMenu.*;

public class Application {
    RepositoryImplementation repositoryImplementation;

    void startMenu() {
        repositoryImplementation = new RepositoryImplementation();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Start Application");
            System.out.println("Press one of the following option:");
            System.out.println("To step into doctor menu press    -> 1");
            System.out.println("To step into patient menu press   -> 2");
            System.out.println("To step into consult menu press   -> 3");
            System.out.println("To exit application press   ->  0");
            int generalOption = scanner.nextInt();
            switch (generalOption) {
                case 1: {

                        System.out.println("Doctor menu");
                        System.out.println("To create a doctor press    ->  11");
                        System.out.println("To update a doctor press    ->  12");
                        System.out.println("To print all doctors press  ->  13");
                        System.out.println("To print one doctor press   ->  14");
                        System.out.println("To delete one doctor press  ->  15");
                        int doctorOption = scanner.nextInt();

                        switch (doctorOption) {
                            case 11: {
                                doctorCreationMenu(scanner);
                                break;
                            }
                            case 12: {
                                try {
                                    doctorUpdateMenu(scanner);

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case 13: {
                                printDoctorsListMenu();
                                break;
                            }
                            case 14: {
                                try {
                                    printOneDoctorMenu(scanner);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case 15: {
                                try {
                                    deleteDoctorMenu(scanner);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            default:
                                return;
                        }
                        break;
                    }

                case 2: {
                        System.out.println("Patient Menu");
                        System.out.println("To create a patient press   ->  21");
                        System.out.println("To update a patient press   ->  22");
                        System.out.println("To print all patients press ->  23");
                        System.out.println("To print one patient press  ->  24");
                        System.out.println("To delete one patient press -> 25");
                        int patientOption = scanner.nextInt();
                        switch (patientOption) {
                            case 21: {
                                patientCreationMenu(scanner);

                                break;
                            }
                            case 22: {
                                try {
                                    patientUpdateMenu(scanner);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            case 23: {
                                printPatientsListMenu();
                                break;
                            }
                            case 24: {
                                try {
                                    printOnePatientMenu(scanner);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                                break;
                            }
                            case 25: {
                                try {
                                    deletePatientMenu(scanner);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                            default:
                                return;
                        }
                        break;
                    }

                case 3: {

                        System.out.println("Consult Menu");
                        System.out.println("To create a consult press   -> 31");
                        System.out.println("To update a consult press   -> 32");
                        System.out.println("To print all consults press -> 33");
                        System.out.println("To print one consult press  -> 34");
                        System.out.println("To delete one consult press -> 35");
                        int consultOption = scanner.nextInt();

                        switch (consultOption) {
                            case 31: {
                                createConsultMenu(scanner);
                                break;
                            }
                            case 32: {
                                try {
                                    updateConsultMenu(scanner);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                                break;
                            }
                            case 33: {
                                printConsultsListMenu();
                                break;
                            }
                            case 34: {
                                printOneConsultMenu(scanner);
                                break;
                            }
                            case 35: {
                                deleteConsultMenu(scanner);
                                break;
                            }
                            default:
                                return;

                        }

                        break;
                    }
                    default:
                        return;
                }
            }
        }
}

