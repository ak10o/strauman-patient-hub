DROP TABLE IF EXISTS PATIENT_DETAILS;

CREATE TABLE PATIENT_DETAILS
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    age          INT          NOT NULL,
    disease      VARCHAR(100),
    phone_number VARCHAR(10)
);