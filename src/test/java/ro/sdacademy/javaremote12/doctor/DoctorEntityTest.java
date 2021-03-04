package ro.sdacademy.javaremote12.doctor;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorEntityTest {

    @Test
    public void checkEmail() {
        DoctorEntity doctor = new DoctorEntity();
        String email = "bogdan's@gmail.ro";
        boolean isValid = doctor.checkEmail(email);
        assertTrue(isValid);

    }
    @Test
    public void checkEmailByRegex(){

        DoctorEntity doctor = new DoctorEntity();
        String email = "bogdan-rosu@gmail.com";
        boolean isValid = doctor.checkEmailByRegex(email);
        assertTrue(isValid);
    }
}