insert into category (name, created_on, updated_on) values ('Computers', '2013-03-01 19:00:00', '2013-03-01 19:00:00')
insert into category (name, created_on, updated_on) values ('Education', '2013-03-01 19:00:00', '2013-03-01 19:00:00')
insert into category (name, created_on, updated_on) values ('History', '2013-03-01 19:00:00', '2013-03-01 19:00:00')

insert into author (name, created_on, updated_on) values ('Henry Author', '2013-03-01 19:00:00', '2013-03-01 19:00:00')
insert into author (name, created_on, updated_on) values ('Gary Writer', '2013-03-01 19:00:00', '2013-03-01 19:00:00')

insert into book (title, description, isbn, published, publisher, price, available, category_id, created_on, updated_on) values ('Learn to Program', 'This is a description of the book Learn to Program. It will take us through the process of learning to program in simple easy to understand steps.', '1234561231', '2013-03-01 19:00:00', 'Computer Printing House', 23.54, TRUE, 1, '2013-03-01 19:00:00', '2013-03-01 19:00:00')
insert into book (title, description, isbn, published, publisher, price, available, category_id, created_on, updated_on) values ('Code in C', 'Go in depth in understanding how to program in C with this amazing companion book for anyone learning and using C in their daily lives.', '3214561231', '2013-01-01 19:00:00', 'Computer Printing House', 35.65, TRUE, 1, '2013-03-01 19:00:00', '2013-03-01 19:00:00')
insert into book (title, description, isbn, published, publisher, price, available, category_id, created_on, updated_on) values ('History of Programming', 'From the beginning of programming right up to the present day. Learn all there is to know about the development of programming languages over the decades.', '3214554331', '2012-08-01 19:00:00', 'Historical Society Publishing', 45.99, TRUE, 3, '2013-03-01 19:00:00', '2013-03-01 19:00:00')

insert into book_author (book_id, author_id) values (1, 1)
insert into book_author (book_id, author_id) values (2, 2)
insert into book_author (book_id, author_id) values (3, 1)
insert into book_author (book_id, author_id) values (3, 2)

insert into user (name, email, role, hashed_password, created_on, updated_on) values ('Admin', 'admin@bookstore.com', 3, 'Md/9oPSvwWLkfqdwuVQk5JB7Dbtt/nwdN3clrQxfMeUZsFatNS/DGjAFUlYBDGPN', '2013-03-01 19:00:00', '2013-03-01 19:00:00')
