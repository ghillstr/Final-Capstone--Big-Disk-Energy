
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
        league_name varchar(50) NOT NULL,
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
        league_name varchar(50) NOT NULL,
        tee_date date NOT NULL,
        start_time time NOT NULL,
        
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);

CREATE TABLE scores (
        round_id SERIAL PRIMARY KEY,
        username varchar(50) NOT NULL,
        score_total integer,
        league_name varchar(50) NOT NULL
);


COMMIT TRANSACTION;

INSERT INTO invite_status (status_id, status_type)
VALUES (DEFAULT, 'Pending'),
       (DEFAULT, 'Accepted'),
       (DEFAULT, 'Rejected');

<<<<<<< HEAD

=======
>>>>>>> 99c8c3c8cd2186c8be9a522a6649173a36fde91c
