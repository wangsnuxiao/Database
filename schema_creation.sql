create schema if not exists DB_project;
use DB_project;
drop table if exists Answers;
drop table if exists Questions;
drop table if exists User;
drop table if exists Profile;
drop table if exists Topics;
drop table if exists hasChild;


create table User (
  uid INTEGER auto_increment primary key ,
  username varchar(20),
  password varchar(20),
  email varchar(40),
  city varchar(20),
  state varchar(20)
);

create table Profile(
    uid INTEGER primary key ,
    visibility INTEGER,
    age INTEGER,
    date_of_birth date,
    description varchar(500),
    level varchar(30),
    total_thumbs_up integer
);
create table Topics(
  tid INTEGER auto_increment primary key,
  tname varchar(30),
  parent_id INTEGER,
  FULLTEXT (tname)
);

create table hasChild(
    parent_id Integer ,
    children_id INTEGER,
    primary key (parent_id, children_id)
);


create table Questions(
    qid INTEGER auto_increment primary key ,
    tid INTEGER,
    uid INTEGER,
    qTitle varchar(100),
    qBody varchar(500),
    question_created_time timestamp,
    question_solved_time timestamp,
    bestAnswer INTEGER,
    foreign key (uid) references User(uid) on delete no action ,
    foreign key (tid) references Topics(tid),
    FULLTEXT (qTitle)
);

create table Answers(
  aid INTEGER auto_increment primary key ,
  uid integer,
  qid integer,
  answer_text varchar(500),
  answer_created_time timestamp,
  thumbs_up_num INTEGER,
  foreign key (uid) references User(uid) on delete no action ,
  foreign key (qid) references Questions(qid)
);