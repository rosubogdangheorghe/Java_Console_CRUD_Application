CREATE TABLE `yellow_team`.`consults` (
  `consult_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `price` DOUBLE NULL,
  `diagnostic` VARCHAR(45) NULL,
  PRIMARY KEY (`consult_id`));
  
  CREATE TABLE `yellow_team`.`doctors` (
  `doctor_id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `speciality` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`doctor_id`));
  
  CREATE TABLE `yellow_team`.`patients` (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `cnp` VARCHAR(13) NOT NULL,
  `age` INT NULL,
  `birthday` DATE NULL,
  `phone` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`patient_id`));

CREATE TABLE `yellow_team`.`doctor_patient` (
  `doctor_patient_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`doctor_patient_id`),
  INDEX `doctorid_idx` (`doctor_id` ASC) VISIBLE,
  INDEX `patientid_idx` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `doctorid`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `yellow_team`.`doctors` (`doctor_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `patientid`
    FOREIGN KEY (`patient_id`)
    REFERENCES `yellow_team`.`patients` (`patient_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
    ALTER TABLE `yellow_team`.`consults` 
ADD INDEX `consult_patient_idx` (`patient_id` ASC) VISIBLE,
ADD INDEX `consult_doctorid_idx` (`doctor_id` ASC) VISIBLE;
;

ALTER TABLE `yellow_team`.`consults` 
ADD CONSTRAINT `consult_doctorid`
  FOREIGN KEY (`doctor_id`)
  REFERENCES `yellow_team`.`doctors` (`doctor_id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT,
ADD CONSTRAINT `consult_patientid`
  FOREIGN KEY (`patient_id`)
  REFERENCES `yellow_team`.`patients` (`patient_id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

