--this file is not used because of the import.sql in the src/main/resources
insert into note (title, body) values ('a simple note #1', 'a very simple note');
insert into note (title, body) values ('a simple note #2', 'a very simple note #2');
insert into tag (name, note_id) values ('math', 1);
insert into tag (name, note_id) values ('english', 1);
insert into tag (name, note_id) values ('science', 1);
insert into tag (name, note_id) values ('math', 2);
insert into tag (name, note_id) values ('english', 2);