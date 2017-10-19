CREATE TABLE score (
  score_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  quantity DOUBLE NULL DEFAULT NULL, 
  create_date DATETIME NULL DEFAULT NULL,
  type VARCHAR(255) NULL DEFAULT NULL,
  user_id BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (score_id),
  CONSTRAINT FKuser_score
    FOREIGN KEY (user_id)
    REFERENCES user (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO score (score_id, quantity, user_id) VALUES (0, '100', '1');