CREATE TABLE players (
        user_id integer NOT NULL,
        firstName varchar(20) NOT NULL,
        lastname varchar(20)  NOT NULL,
        
        CONSTRAINT pk_players_user_id PRIMARY KEY (user_id)
);
CREATE SEQUENCE seq_league_id;

CREATE TABLE league (
        league_id integer NOT NULL nextVal('seq_league_id'),
        user_id integer NOT NULL,
        course_id integer NOT NULL,
        league_name varchar(20) NOT NULL,
        
        CONSTRAINT pk_league_league_id PRIMARY KEY (league_id),
        CONSTRAINT fk_league_user_id FOREIGN KEY (user_id),
        CONSTRAINT fk_league_course_id FOREIGN KEY (course_id)
);
        
CREATE TABLE  leaderboard (
        league_id integer NOT NULL,
        user_id integer NOT NULL,
        player_total integer,
        
        CONSTRAINT pk_leaderboard_league_id PRIMARY KEY (league_id),
        CONSTRAINT fk_leaderboard_league_id FOREIGN KEY (league_id),
        CONSTRAINT fk_leaderboard_user_id FOREIGN KEY (user_id)
        
);

CREATE SEQUENCE seq_course_id;

CREATE TABLE course (
        course_id integer NOT NULL nextval('seq_course_id'),
        course_name varchar(100) NOT NULL,
        
         CONSTRAINT pk_course_course_id PRIMARY KEY (course_id)
        
);   

CREATE SEQUENCE seq_invite_id;

CREATE TABLE invite (
        invite_id integer NOT NULL nextval('seq_invite_id'),
        status_id integer NOT NULL,
        user_id integer NOT NULL,
        
        CONSTRAINT pk_invite_invite_id PRIMARY KEY (invite_id),
        CONSTRAINT fk_invite_status_id FOREIGN KEY (status_id),
        CONSTRAINT fk_invite_user_id FOREIGN KEY (user_id)
);

CREATE TABLE invite_status (
        status_id integer NOT NULL,
        status_type varchar(15) NOT NULL,
        
        CONSTRAINT pk_invite_status__id PRIMARY KEY (invite_id),
        CONSTRAINT fk_invite_status_id FOREIGN KEY (status_id),
);

CREATE SEQUENCE seq_tee_time_id;

CREATE TABLE tee_time (
        tee_time_id integer NOT NULL nextval('seq_tee_time_id'),
        course_id integer NOT NULL,
        tee_date integer NOT NULL,
        start_time time NOT NULL,
        number_of_players integer NOT NULL
        
        CONSTRAINT pk_tee_time_tee_time__id PRIMARY KEY (tee_time_id),
        CONSTRAINT fk_tee_time_course_id FOREIGN KEY (course_id)
        
);

CREATE SEQUENCE seq_round_id; 

CREATE TABLE scores (
        round_id integer NOT NULL nextval('seq_round_id'),
        user_id integer NOT NULL,
        score_total integer,
        league_id integer NOT NULL,
        
        
        CONSTRAINT pk_scores_round_id PRIMARY KEY (round_id),
        CONSTRAINT fk_scores_user_id FOREIGN KEY (user_id),
        CONSTRAINT fk_scores_league_id FOREIGN KEY (league_id)
        
        
        
);
        
    
