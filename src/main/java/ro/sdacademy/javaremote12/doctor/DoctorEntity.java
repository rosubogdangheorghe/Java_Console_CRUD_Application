package ro.sdacademy.javaremote12.doctor;

import ro.sdacademy.javaremote12.consult.ConsultEntity;

import javax.persistence.*;
import java.util.List;

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
    @Enumerated (EnumType.STRING)
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
        this.email = email;
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
