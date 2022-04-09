create schema DB_project;
drop table Answers;
drop table Questions;

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
  parent_id INTEGER
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
    qTitle varchar(20),
    qBody varchar(500),
    question_created_time timestamp,
    question_solved_time timestamp,
    bestAnswer INTEGER,
    foreign key (uid) references User(uid),
    foreign key (tid) references Topics(tid)
);

create table Answers(
  aid INTEGER auto_increment primary key ,
  uid integer,
  qid integer,
  answer_text varchar(500),
  answer_created_time timestamp,
  thumbs_up_num INTEGER,
  foreign key (uid) references User(uid),
  foreign key (qid) references Questions(qid)
);