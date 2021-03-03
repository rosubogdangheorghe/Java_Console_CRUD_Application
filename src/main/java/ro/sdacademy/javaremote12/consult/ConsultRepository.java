package ro.sdacademy.javaremote12.consult;

import java.util.List;

public interface ConsultRepository {

    void createConsult(ConsultEntity consult);

    void updateConsult(Integer id, Double price, String diagnostic);

    List<ConsultEntity> getAllConsults();

    ConsultEntity getConsultById(Integer Id) throws Exception;

    void deleteConsult(Integer id);

}
