CREATE TABLE customer_profile (
    id          VARCHAR(36) NOT NULL,
    first_name  VARCHAR(255) NULL,
    last_name   VARCHAR(255) NULL,
    email       VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

insert into customer_profile(id,first_name,last_name,email) values (1,'Benoit','Moussaud','Benoit.Moussaud@acme.org');
insert into customer_profile(id,first_name,last_name,email) values (2,'Scott','Tiger','Scott.Tiger@acme.org');
insert into customer_profile(id,first_name,last_name,email) values (3,'Patato','Valdes','Patato.Valdes@acme.org');
insert into customer_profile(id,first_name,last_name,email) values (4,'John','Doe','John.Doe@acme.org');
