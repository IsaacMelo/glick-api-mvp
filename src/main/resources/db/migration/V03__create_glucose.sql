CREATE TABLE glucose (
  glucose_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  reading_status VARCHAR(255) NULL DEFAULT NULL,
  value DOUBLE NULL DEFAULT NULL,
  create_date DATETIME NULL DEFAULT NULL,
  modify_date DATETIME NULL DEFAULT NULL,
  reading_date DATETIME NULL DEFAULT NULL,
  user_id BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (glucose_id),
  CONSTRAINT FKuser_glucose
    FOREIGN KEY (user_id)
    REFERENCES user (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE medication (
  medication_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  medication_status VARCHAR(255) NULL DEFAULT NULL,
  insulin_unity DOUBLE NULL DEFAULT NULL,
  create_date DATETIME NULL DEFAULT NULL,
  modify_date DATETIME NULL DEFAULT NULL,
  reading_date DATETIME NULL DEFAULT NULL,
  user_id BIGINT(20) NULL DEFAULT NULL,
  glucose_id BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (medication_id),
  CONSTRAINT FKuser_medication
    FOREIGN KEY (user_id)
    REFERENCES user (user_id),
  CONSTRAINT FKglucose_medication
    FOREIGN KEY (glucose_id)
    REFERENCES glucose (glucose_id)	
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
  score_id BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (food_id),
  CONSTRAINT FKuser_food
    FOREIGN KEY (user_id)
    REFERENCES user (user_id),
 CONSTRAINT FKscore_food
    FOREIGN KEY (score_id)
    REFERENCES score (score_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO glucose (glucose_id, value, user_id, insulin_unity, create_date, modify_date) VALUES ('0', '200', '1','1','2017-09-28 14:12:44','2017-09-28 14:12:44');
INSERT INTO glucose (glucose_id, value, user_id, insulin_unity, create_date, modify_date) VALUES ('0', '200', '1','1','2017-09-28 14:12:44','2017-09-28 14:12:44');
INSERT INTO glucose (glucose_id, value, user_id, insulin_unity, create_date, modify_date) VALUES ('0', '200', '1','1','2017-09-28 14:12:44','2017-09-28 14:12:44');
INSERT INTO glucose (glucose_id, value, user_id, insulin_unity, create_date, modify_date) VALUES ('0', '200', '1','1','2017-09-28 14:12:44','2017-09-28 14:12:44');

INSERT INTO food (food_id, carbohydrates, quantity, proteins, calories, fats, user_id, create_date, modify_date) VALUES (0, '350', '2', '1' , '1', '1','1','2017-09-28 14:12:44','2017-09-28 14:12:44');
INSERT INTO food (food_id, carbohydrates, quantity, proteins, calories, fats, user_id, create_date, modify_date) VALUES (0, '350', '2', '1' , '1', '1','1','2017-09-28 14:12:44','2017-09-28 14:12:44');
INSERT INTO food (food_id, carbohydrates, quantity, proteins, calories, fats, user_id, create_date, modify_date) VALUES (0, '350', '2', '1' , '1', '1','1','2017-09-28 14:12:44','2017-09-28 14:12:44');
INSERT INTO food (food_id, carbohydrates, quantity, proteins, calories, fats, user_id, create_date, modify_date) VALUES (0, '350', '2', '1' , '1', '1','1','2017-09-28 14:12:44','2017-09-28 14:12:44');

