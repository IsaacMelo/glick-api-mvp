CREATE TABLE glucose (
  glucose_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  create_date DATETIME NULL DEFAULT NULL,
  insulin_unity DOUBLE NULL DEFAULT NULL,
  medication VARCHAR(255) NULL DEFAULT NULL,
  modify_date DATETIME NULL DEFAULT NULL,
  reading_date DATETIME NULL DEFAULT NULL,
  reading_status VARCHAR(255) NULL DEFAULT NULL,
  value DOUBLE NULL DEFAULT NULL,
  user_id BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (glucose_id),
  CONSTRAINT FKuser_glucose
    FOREIGN KEY (user_id)
    REFERENCES user (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE food (
  food_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  brand VARCHAR(255) NULL DEFAULT NULL,
  calories FLOAT NULL DEFAULT NULL,
  carbohydrates FLOAT NULL DEFAULT NULL,
  create_date DATETIME NULL DEFAULT NULL,
  fats FLOAT NULL DEFAULT NULL,
  modify_date DATETIME NULL DEFAULT NULL,
  name VARCHAR(255) NULL DEFAULT NULL,
  proteins FLOAT NULL DEFAULT NULL,
  quantity DOUBLE NULL DEFAULT NULL,
  reading_date DATETIME NULL DEFAULT NULL,
  servings VARCHAR(255) NULL DEFAULT NULL,
  type VARCHAR(255) NULL DEFAULT NULL,
  user_id BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (food_id),
  CONSTRAINT FKuser_food
    FOREIGN KEY (user_id)
    REFERENCES user (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE medication (
  medication_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  create_date DATETIME NULL DEFAULT NULL,
  medication_type VARCHAR(255) NULL DEFAULT NULL,
  modify_date DATETIME NULL DEFAULT NULL,
  quantity DOUBLE NULL DEFAULT NULL,
  reading_date DATETIME NULL DEFAULT NULL,
  user_id BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (medication_id),
  CONSTRAINT FKuser_medication
    FOREIGN KEY (user_id)
    REFERENCES user (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO glucose (glucose_id, value, user_id, insulin_unity) VALUES ('1', '200', '1','1');
INSERT INTO food (food_id, carbohydrates, quantity, user_id) VALUES ('1', '350', '2', '1');
INSERT INTO food (food_id, carbohydrates, quantity, user_id) VALUES ('2', '350', '2', '1');
INSERT INTO food (food_id, carbohydrates, quantity, user_id) VALUES ('3', '300', '2', '1');
