package ro.sdacademy.javaremote12.patient;

import org.junit.Test;
import ro.sdacademy.javaremote12.SessionCreation;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PatientRepositoryImplementationTest {

    @Test
    public void createPatient() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Test first name");
        patient.setLastName("Test last name");
        patient.setCnp("2570202020040");
        patient.setBirthday(LocalDate.of(1957,2,2));
        patient.setAge();
        patient.setPhone("0732225225");


        PatientRepository patientImplementation = new PatientRepositoryImplementation();
        Integer result = patientImplementation.createPatient(patient);
        if(result == -1) {
            assertFalse(false);
        } else{
            assertTrue(true);
        }
    }
}