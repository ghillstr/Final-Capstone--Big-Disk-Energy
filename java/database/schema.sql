
BEGIN TRANSACTION;

DROP TABLE IF EXISTS scores;
DROP TABLE IF EXISTS tee_time;
DROP TABLE IF EXISTS invite;
DROP TABLE IF EXISTS invite_status;
DROP TABLE IF EXISTS users_leagues; 
DROP TABLE IF EXISTS leagues;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');



CREATE TABLE leagues (
        league_id SERIAL PRIMARY KEY,
        username varchar(50) NOT NULL,
        course_name varchar(50) NOT NULL,
        league_name varchar(20) NOT NULL    
);

CREATE TABLE users_leagues (
        league_id integer NOT NULL,
        user_id integer NOT NULL,
        
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE invite_status (
        status_id SERIAL PRIMARY KEY,
        status_type varchar(15) NOT NULL
        
);

CREATE TABLE invite (
        invite_id SERIAL PRIMARY KEY,
        status_id integer NOT NULL,
        league_id integer NOT NULL,
        league_name varchar(20) NOT NULL,
        user_id integer NOT NULL,
        username varchar(50) NOT NULL,
        
        CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES invite_status(status_id),
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);

CREATE TABLE tee_time (
        tee_time_id SERIAL PRIMARY KEY,
        user_id integer NOT NULL,
        username varchar(50) NOT NULL,
        league_id integer NOT NULL,
        league_name varchar(20) NOT NULL,
        tee_date date NOT NULL,
        start_time time (0) NOT NULL,
        
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);

CREATE TABLE scores (
        round_id SERIAL PRIMARY KEY,
        username varchar(50) NOT NULL,
        score_total integer,
        league_name varchar(20) NOT NULL
);


COMMIT TRANSACTION;

INSERT INTO leagues (league_id, course_name, league_name)
VALUES (DEFAULT, 'Knob', 'DA BUS'),
       (DEFAULT, 'Nobo', 'smart car');
       
       
INSERT INTO invite_status (status_id, status_type)
VALUES (DEFAULT, 'Pending'),
       (DEFAULT, 'Accepted'),
       (DEFAULT, 'Rejected');
       

INSERT INTO invite (invite_id, status_id, league_id, user_id)
VALUES (DEFAULT, 1, 1, 3),
       (DEFAULT, 1, 1, 4),
       (DEFAULT, 1, 1, 5),
       (DEFAULT, 1, 1, 6),
       (DEFAULT, 1, 2, 7);
       
INSERT INTO tee_time (tee_time_id, user_id, league_id, tee_date, start_time)
VALUES (DEFAULT, 3, 1, '2020-12-25', '09:00:00'),
       (DEFAULT, 4, 1, '2020-12-25', '09:00:00'),
       (DEFAULT, 5, 1, '2020-12-25', '09:00:00');
       
<<<<<<< HEAD
INSERT INTO scores (round_id, username, score_total, league_name)
=======
<<<<<<< HEAD
INSERT INTO scores (round_id, user_id, score_total, league_id)
VALUES (DEFAULT, 3, 14, 1),
       (DEFAULT, 4, 47, 1),
       (DEFAULT, 5, 78, 1),d
       (DEFAULT, 6, 7, 1),
       (DEFAULT, 7, 4, 2);
=======
INSERT INTO scores (round_id, username, score_total, leaguename)
>>>>>>> 27a17f819aa7f3fcaea09a36e3e0340013400b93
VALUES (DEFAULT, 'kjm', 14, 'DA BUS'),
       (DEFAULT, 'beckboo', 47, 'DA BUS'),
       (DEFAULT, 'milf', 78, 'DA BUS'),
       (DEFAULT, 'bobbyg', 7, 'DA BUS'),
       (DEFAULT, 'ghill', 4, 'smart car');
>>>>>>> 3731af229a2daf0580632078ff3a957ba4517800
       
       
INSERT INTO users_leagues (league_id, user_id)
VALUES (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (2, 7);
       
       
       


SELECT u.user_id, u.username, l.league_id, l.league_name FROM leagues l JOIN users_leagues USING(league_id) JOIN users u USING(user_id);
SELECT invite.* FROM invite WHERE username = ? AND status_id = 1

SELECT tee_date, start_time FROM tee_time WHERE user_id = 1;

