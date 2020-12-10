BEGIN TRANSACTION;

DROP TABLE IF EXISTS scores;
DROP TABLE IF EXISTS tee_time;
DROP TABLE IF EXISTS invite;
DROP TABLE IF EXISTS invite_status;
DROP TABLE IF EXISTS leaderboard;
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
        user_id integer NOT NULL,
        course_name varchar(50) NOT NULL,
        league_name varchar(20) NOT NULL,
        
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);
        
CREATE TABLE leaderboard (
        leaderboard_id SERIAL PRIMARY KEY,
        league_id integer NOT NULL,
        user_id integer NOT NULL,
        player_total integer,
        
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
        
); 

CREATE TABLE invite_status (
        status_id SERIAL PRIMARY KEY,
        status_type varchar(15) NOT NULL
        
);

CREATE TABLE invite (
        invite_id SERIAL PRIMARY KEY,
        group_id integer,
        status_id integer NOT NULL,
        league_id integer NOT NULL,
        user_id integer NOT NULL,
        
        CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES invite_status(status_id),
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);

CREATE TABLE tee_time (
        tee_time_id SERIAL PRIMARY KEY,
<<<<<<< HEAD
        group_id integer,
=======
        user_id integer NOT NULL,
>>>>>>> 96a06648cf5801d28f47694b5a5c2b752a07ca12
        league_id integer NOT NULL,
        tee_date date NOT NULL,
        start_time time NOT NULL,
        
        CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES invite(group_id),
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);

CREATE TABLE scores (
        round_id SERIAL PRIMARY KEY,
        user_id integer NOT NULL,
        score_total integer,
        league_id integer NOT NULL,
        
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id)
        
);

<<<<<<< HEAD
<<<<<<< HEAD

=======
CREATE TABLE course (
        course_id SERIAL PRIMARY KEY,
        course_name varchar(100) NOT NULL
        
);  

INSERT INTO leagues (league_id, user_id, course_name, league_name) VALUES (DEFAULT, 1, 'Knob', 'Struggle Bus');
INSERT INTO tee_time (tee_time_id, user_id, league_id, tee_date, start_time) VALUES (DEFAULT, 1, 1, '2020-12-11', '08:00:00');

SELECT users.user_id, users.username, tee_time.league_id FROM tee_time 
JOIN users USING (user_id);
>>>>>>> 96a06648cf5801d28f47694b5a5c2b752a07ca12
=======

COMMIT TRANSACTION;
>>>>>>> 54885792a975750f26dcac4b30087f3ba9acd325
