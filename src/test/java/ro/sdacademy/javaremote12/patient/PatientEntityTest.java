package ro.sdacademy.javaremote12.patient;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PatientEntityTest {

    @Test
    public void calculateAge() {
            PatientEntity patient = new PatientEntity();
            patient.setFirstName("Bogdan");
            patient.setLastName("rosu");
            patient.setCnp("1741011020038");
            patient.setBirthday(LocalDate.of(1974,10,11));
            patient.setPhone("040734008566");
            int result = patient.calculateAge();
            assertEquals(46,result);

    }
    @Test
    public void computeAge() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Bogdan");
        patient.setLastName("rosu");
        patient.setCnp("1741011020038");
        patient.setBirthday(LocalDate.of(1974,10,11));
        patient.setPhone("040734008566");
        int result = patient.computeAge(patient.getBirthday());
        assertEquals(47,result);
    }
    @Test
    public void checkCnpRegexLength() {
        PatientEntity patient = new PatientEntity();
        String testString = "1741011020035";
        Boolean isValid = patient.checkCnpRegexLength(testString);
        assertTrue(isValid);
    }

    @Test
    public void checkCnpAlgorithm(){
        PatientEntity patient = new PatientEntity();
        String testString = "1741011020038";
        Boolean isValid = patient.checkCnpAlgorithm(testString);
        assertTrue(isValid);
    }
}