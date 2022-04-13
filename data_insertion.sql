use DB_project;
-- Insertion for User Table
insert into User (uid, username, password, email, city, state) values
    (1, 'Charlie','111111','xxxx@nyu.edu','newyork','NY'),
    (2, 'Alex', '123456','alex@nyu.edu', 'newport', 'NJ'),
    (3, 'Billy', '654321', 'billty@mit.edu','boston', 'MA'),
    (4, 'Dogge', '1241512', 'dog@njit.edu', 'newport', 'NJ'),
    (5, 'Eilly', 'jvoiwenq', 'eilly@buffalo.edu', 'buffalo','NY');

-- Insertion for Profile table
insert into Profile(uid, visibility, age, date_of_birth, description, level, total_thumbs_up)
values  (1,1,22,'1999-5-24','this is des','noob',0),
        (2,0,12,'1999-5-24','this is des','noob',0),
        (3,0,25,'1999-5-24','this is des','noob',0),
        (4,1,30,'1999-5-24','this is des','noob',0),
        (5,1,70,'1999-5-24','this is des','noob',0);

-- Insertion for root Topics table
insert into Topics(tid, tname, parent_id)
values (1,'CS',null),      -- Root Topic CS
       (2,'Database', 1),  -- Database is the subtopic of CS
       (3, 'Art', null),   -- Root Topic Art
       (4, 'DataStructure',1), -- Root Topic DS
       (5, 'Algorithm', 1), -- Root Topic Algo
       (6, 'Database Design', 2);-- Database Design is the subtopic of Database and CS

-- Insertion for hasChild table
insert into hasChild(parent_id, children_id)
VALUES (1,2),
       (1,5),
       (2,6);

-- Insertion for Questions table
insert into Questions(qid, tid, uid, qTitle, qBody, question_created_time, question_solved_time, bestAnswer)
values (1, 2, 1, '', '',now(),null,null)
;

asdasdasdasdas;