CREATE TABLE user (
  user_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  birthdate DATETIME NULL DEFAULT NULL,
  create_date DATETIME NULL DEFAULT NULL,
  email VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NULL DEFAULT NULL,
  last_name VARCHAR(255) NULL DEFAULT NULL,
  modify_date DATETIME NULL DEFAULT NULL,
  password VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE role (
	role_id BIGINT(20) PRIMARY KEY,
	name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_role (
	user_id BIGINT(20) NOT NULL,
	role_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES user(user_id),
	FOREIGN KEY (role_id) REFERENCES role(role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Insert user
INSERT INTO user (user_id, email, first_name, last_name, password) VALUES ('1', 'admin@glick.com', 'admin', 'system', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

-- Insert roles
INSERT INTO role (role_id, name) values (1, 'ROLE_CREATE_GLUCOSE');
INSERT INTO role (role_id, name) values (2, 'ROLE_CREATE_FOOD');
INSERT INTO role (role_id, name) values (3, 'ROLE_CREATE_USER');

-- Insert roles user admin
INSERT INTO user_role (user_id, role_id) values (1, 1);
INSERT INTO user_role (user_id, role_id) values (1, 2);
INSERT INTO user_role (user_id, role_id) values (1, 3);
