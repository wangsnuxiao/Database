use DB_project;
drop trigger profile_trigger;

CREATE TRIGGER profile_trigger after Insert on User
     For each row
     begin
     insert into Profile (
       uid, visibility, age, date_of_birth, description, level, total_thumbs_up
     )
     values (New.uid, 0, null, null, null, 0, 0);
     end;

INSERT into User (uid, username, password,email,city,state)
values (6,'testing','123456','testing@nyu.edu','NYC','NY');