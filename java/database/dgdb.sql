CREATE TABLE leagues (
        league_id SERIAL PRIMARY KEY,
        user_id integer NOT NULL,
        course_id integer NOT NULL,
        league_name varchar(20) NOT NULL,
        
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES course(course_id)
);
        
CREATE TABLE leaderboard (
        leaderboard_id SERIAL PRIMARY KEY,
        league_id integer NOT NULL,
        user_id integer NOT NULL,
        player_total integer,
        
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
        
);

CREATE TABLE course (
        course_id SERIAL PRIMARY KEY,
        course_name varchar(100) NOT NULL
        
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

CREATE TABLE invite_status (
        status_id SERIAL PRIMARY KEY,
        status_type varchar(15) NOT NULL,
        
        CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES invite(status_id)
);

CREATE TABLE tee_time (
        tee_time_id SERIAL PRIMARY KEY,
        group_id integer,
        league_id integer NOT NULL,
        course_id integer NOT NULL,
        tee_date date NOT NULL,
        start_time time NOT NULL,
        
        CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES invite(group_id),
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id),
        CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES course(course_id)
        
);

CREATE TABLE scores (
        round_id SERIAL PRIMARY KEY,
        user_id integer NOT NULL,
        score_total integer,
        league_id integer NOT NULL,
        
        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT fk_league_id FOREIGN KEY (league_id) REFERENCES leagues(league_id)
        
);


