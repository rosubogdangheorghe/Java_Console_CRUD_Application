package ro.sdacademy.javaremote12.doctor;

import ro.sdacademy.javaremote12.consult.ConsultEntity;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    private String firstName;
    private String lastName;
    private String address;
    @Enumerated(EnumType.STRING)
    private DoctorSpecialityEnum speciality;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "doctor")
    private List<ConsultEntity> consults;

    public DoctorEntity(String firstName, String lastName, String address, DoctorSpecialityEnum speciality, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speciality = speciality;
        this.email = email;
        this.phone = phone;
    }

    public DoctorEntity() {
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DoctorSpecialityEnum getSpeciality() {
        return speciality;
    }

    public void setSpeciality(DoctorSpecialityEnum speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (this.checkEmailByRegex(email)) {
            this.email = email;
        } else {
            System.out.println("Email Data is incorrect");
        }

    }
    public Boolean checkEmail(String emailAddress) {
        Boolean result;
        try {
            InternetAddress email = new InternetAddress(emailAddress);
            email.validate();
            result = true;
        } catch (AddressException e) {
            result = false;
        }
        return result;
    }
    public Boolean checkEmailByRegex(String emailAddress) {
        final String regex = "([a-zA-Z0-9_.-]*)@([a-zA-Z_.-]*)((\\.([a-zA-Z]*){2,3})+)";
        final Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(emailAddress);
        return matcher.matches();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ConsultEntity> getConsults() {
        return consults;
    }

    public void setConsults(List<ConsultEntity> consults) {
        this.consults = consults;
    }

    @Override
    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Doctor: Id: ").append(doctorId).append(", ");
        stringbuilder.append("First Name: ").append(firstName).append(", ");
        stringbuilder.append("Last Name: ").append(lastName).append(", ");
        stringbuilder.append("Address: ").append(address).append(", ");
        stringbuilder.append("Speciality: ").append(speciality).append(", ");
        stringbuilder.append("E-mail: ").append(email).append(", ");
        stringbuilder.append("Phone Number: ").append(phone).append(" ");
        return stringbuilder.toString();
    }
}
