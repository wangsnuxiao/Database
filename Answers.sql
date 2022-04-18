use DB_project;
drop trigger profile_trigger;


-- Q1: Create a new user account, together with username, email,
-- password, city, state, country and profile.

-- Idea: Using profile_trigger to detection any new insertion.
-- When an new insertion happends to User table

-- Profile trigger monitor new insertions on User Table
CREATE TRIGGER profile_trigger after Insert on User
     For each row
     begin
     insert into Profile (
       uid, visibility, age, date_of_birth, description, level, total_thumbs_up
     )
     values (New.uid, 0, null, null, null, 0, 0);
     end;
-- Test Insertion into User table
INSERT into User (uid, username, password, email, city, state)
values (6,'testing','123456','testing@nyu.edu','NYC','NY');


-- Q2: Insert a new question into the system, by a particular user and
-- assigned it to a particular topic in the hierarchy.
INSERT into Questions(qid, tid, uid, qTitle, qBody, question_created_time, question_solved_time, bestAnswer)
values (2,5,3,'DFS','how to write dfs', now(), null,null);
-- Q3: Write a query that computes for each user their current status
-- (basic, advanced, or expert status)
select U.uid, username, level from User U join Profile P on U.uid = P.uid;

-- Q4: For a given question (say identified by an ID), output all answers to the question
-- in chronological order from first to last. Output the answer text and the time and date when it was posted, and whether an
-- answer posted
drop procedure if exists get_answers;
create procedure get_answers(IN question_id INTEGER)
    begin
        select Questions.qid,answer_text, answer_created_time, aid, bestAnswer, aid=bestAnswer as isbest
            from Questions join Answers on Questions.qid = Answers.qid
            where Answers.qid = question_id
            order by answer_created_time;
    end;
;
call get_answers(2);

-- Q5: For each topic in the topic hierarchy, output the number of questions posted and total number of
-- answers posted within that topic.
select Topics.tid,tname,count(distinct Q.qid) total_questions ,count(distinct A.aid) total_answers from Topics
    left join Questions Q on Topics.tid = Q.tid
    left join Answers A on Q.qid = A.qid
    where parent_id is not null
    group by Topics.tid;

-- Q6: Given a keyword query, output all questions that match the query and that fall into a particular topic,
-- sorted from highest to lowest relevance.
drop procedure if exists search;
create procedure serach(IN searchkey varchar(100),
                        IN topic_serachkey varchar(50))
select qTitle,qBody,T.tname,
       (0.8 * Match(qTitle) Against(searchkey in boolean mode ))
          + (0.6 * Match(T.tname) Against(topic_serachkey in boolean mode)) as relevence
from Questions join Topics T on T.tid = Questions.tid
where Match(qTitle) Against(searchkey)
order by relevence;

call serach('sql','database');