INSERT INTO leagues (league_id, username, course_name, league_name)
VALUES (DEFAULT, 'kjm', 'Knob', 'DA BUS'),
       (DEFAULT, 'ghill', 'Nobo', 'smart car');
       
       
INSERT INTO invite (invite_id, status_id, league_id, league_name, user_id, username)
VALUES (DEFAULT, 1, 1, 'DA BUS', 3, 'kjm'),
       (DEFAULT, 1, 1, 'DA BUS', 4, 'beckboo'),
       (DEFAULT, 1, 1, 'DA BUS', 5, 'milf'),
       (DEFAULT, 1, 1, 'DA BUS', 6, 'bobbyg'),
       (DEFAULT, 1, 2, 'smart car', 7, 'ghill');
       
       
INSERT INTO tee_time (tee_time_id, user_id, username, league_id, league_name, tee_date, start_time)
VALUES (DEFAULT, 3, 'kjm', 1, 'DA BUS', '2020-12-25', '09:00:00'),
       (DEFAULT, 4, 'beckboo', 1, 'DA BUS', '2020-12-25', '09:00:00'),
       (DEFAULT, 5, 'milf', 1, 'DA BUS', '2020-12-25', '09:00:00');
       

INSERT INTO scores (round_id, username, score_total, league_name)
VALUES (DEFAULT, 'kjm', 14, 'DA BUS'),
       (DEFAULT, 'beckboo', 47, 'DA BUS'),
       (DEFAULT, 'milf', 78, 'DA BUS'),
       (DEFAULT, 'bobbyg', 7, 'DA BUS'),
       (DEFAULT, 'ghill', 4, 'smart car'),
       (DEFAULT, 'beckboo', 20, 'DA BUS');
    
          
INSERT INTO users_leagues (league_id, user_id)
VALUES (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (2, 7);
       