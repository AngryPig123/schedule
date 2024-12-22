CREATE SEQUENCE member_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE member
(
    id                  INT DEFAULT NEXTVAL('member_id_seq') PRIMARY KEY,
    login_id            VARCHAR(50)  NOT NULL UNIQUE,
    password            VARCHAR(200) NOT NULL,
    first_name          VARCHAR(6)   NOT NULL,
    last_name           VARCHAR(6)   NOT NULL,
    home_zip_no         VARCHAR(50),
    home_address        VARCHAR(50),
    home_address_detail VARCHAR(50),
    cell_first_number   VARCHAR(10),
    cell_middle_number  VARCHAR(10),
    cell_last_number    VARCHAR(10),
    create_id           int,
    create_date         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modify_id           int,
    modify_date         TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)