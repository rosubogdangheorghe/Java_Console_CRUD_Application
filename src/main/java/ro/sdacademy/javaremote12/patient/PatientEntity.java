package ro.sdacademy.javaremote12.patient;

import ro.sdacademy.javaremote12.consult.ConsultEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name= "patients")
public class PatientEntity {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    private String cnp;
    private Integer age;
    private LocalDate birthday;
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<ConsultEntity> consults;

    public PatientEntity(String lastName, String firstName, String cnp, LocalDate birthday, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.cnp = cnp;
        this.birthday = birthday;
        this.age = calculateAge();
        this.phone = phone;
    }

    public PatientEntity() {
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {

        if(this.checkCnpRegexLength(cnp) && this.checkCnpAlgorithm(cnp)) {
            this.cnp = cnp;
        }
          else {
            System.out.println("data is incorrect");
        }
    }
    public Boolean checkCnpRegexLength(String string) {
        final String regex ="[0-9]*";
        final Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(string);
        return matcher.matches() && string.length() == 13;
    }
    public Boolean checkCnpAlgorithm (String string) {
        int [] cnp = new int [13];
        String[] stringArray = string.split("");
        for(int i = 0; i<13;i++) {
            cnp[i] = Integer.parseInt(stringArray[i]);
        }

        final Integer[] testKeyArray = new Integer[]{2,7,9,1,4,6,3,5,8,2,7,9};
         int testSum = 0;
        for(int i=0;i<12;i++) {
            testSum += cnp[i]*testKeyArray[i];
        }
        testSum = testSum%11;
        if(testSum == 10) {
            testSum = 1;
        }
        Integer year = cnp[1]*10+cnp[2];
        switch (cnp[0]) {
            case 1 :
            case 2 : {
                year +=1900;
                break;
            }
            case 3:
            case 4: {
                year += 1800;
                break;
            }
            case 5:
            case 6: {
                year += 2000;
                break;
            }
            default: {
                return false;
            }
        }
        return (cnp[12] == testSum && year >1800 && year <2099);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge() {
        this.age = calculateAge();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public Integer calculateAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(this.birthday,now);
        return age = period.getYears(); //46
    }


    public Integer computeAge(LocalDate birthday) {
        Integer year = birthday.getYear();
        Integer age = LocalDate.now().getYear() - year;
        return age; //47

    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Patient: Id: ").append(patientId).append(" ,");
        stringBuilder.append("First Name: ").append(firstName).append(" ,");
        stringBuilder.append("Last Name: ").append(lastName).append(", ");
        stringBuilder.append("CNP: ").append(cnp).append(", ");
        stringBuilder.append("Age :").append(age).append(", ");
        stringBuilder.append("Birth Date: ").append(birthday).append(", ");
        stringBuilder.append("Phone Number: ").append(phone).append(" ");
        return stringBuilder.toString();
    }


}

