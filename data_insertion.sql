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
values (1, 2, 1, 'sql', 'how to write sql',now(),null,null),
       (2, 1, 4, 'why you choose cs','please exaplain why you like cs', '2021-12-21', '2021-12-22', 1),
       (3, 5, 2, 'Master Therom', 'the follwoing question is which case of Master therom', '2022-1-1','2022-1-3', 5),
       (4, 3, 5, 'Is this pating good or not', 'body of painting', '2022-3-12', '2022-4-11', 7)
;

-- Insertion for Answers table
INSERT into answers(aid, uid, qid, answer_text,answer_created_time,thumbs_up_num)
values (1, 1, 2, 'because u like it', '2021-12-22', 30),
       (2, 2, 2, 'it makes money', '2021-12-21', 3),
       (3, 3, 2, 'it makes more money', '2021-12-21', 10),
       (4, 1, 3, 'case 1', '2022-1-2',0),
       (5, 3, 3, 'case 2', '2021-1-3',15),
       (6, 5, 3, 'case 3', '2021-1-1',2),
       (7, 4, 4, 'no', '2021-4-11',5),
       (8, 2, 4, 'Yes', '2021-4-11', 0)
;