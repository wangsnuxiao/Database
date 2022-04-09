
-- Insertion for User Table
insert into User (uid, username, password, email, city, state) values
    (null, 'Charlie','111111','xxxx@nyu.edu','newyork','NY'),
    (null, 'Alex', '123456','alex@nyu.edu', 'newport', 'NJ'),
    (null, 'Billy', '654321', 'billty@mit.edu','boston', 'MA'),
    (null, 'Dogge', '1241512', 'dog@njit.edu', 'newport', 'NJ'),
    (null, 'Eilly', 'jvoiwenq', 'eilly@buffalo.edu', 'buffalo','NY');
insert into Profile(uid, visibility, age, date_of_birth, description, level, total_thumbs_up)
values  (1,1,22,'1999-5-24','this is des','noob',0),
        (1,0,12,'1999-5-24','this is des','noob',0),
        (1,0,25,'1999-5-24','this is des','noob',0),
        (1,1,30,'1999-5-24','this is des','noob',0),
        (1,1,70,'1999-5-24','this is des','noob',0)