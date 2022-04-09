
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
