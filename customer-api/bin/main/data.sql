insert into CUSTOMER (ID, NAME, PASSWORD, EMAIL) VALUES (0, 'Bruce', 'pass', 'bruce@a.com');
insert into CUSTOMER (ID, NAME, PASSWORD, EMAIL) VALUES (1, 'Paul', 'pass', 'paul@b.com');
insert into CUSTOMER (ID, NAME, PASSWORD, EMAIL) VALUES (2, 'Rick', 'pass', 'rick@c.com');

insert into EVENT (ID, CODE, TITLE, DESCRIPTION ) VALUES (0, 'CNF001', 'All-Java Conference', 'Lectures and exhibits covering all Java topics' );
insert into EVENT (ID, CODE, TITLE, DESCRIPTION ) VALUES (1, 'WKS002', 'Spring Boot Workshop', 'Hands-on Spring Boot Workshop' );
insert into EVENT (ID, CODE, TITLE, DESCRIPTION ) VALUES (2, 'TRN003', 'Angular Training Course', 'Five day introductory training in Angular' );

-- Registration for event 1
insert into REGISTRATION (ID, EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES ) 
values ( 0, 1, 0, '2019-01-15 00:00:00.0', 'please email me the event details' );

insert into REGISTRATION (ID, EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES ) 
values ( 1, 1, 1, '2019-01-17 00:00:00.0', 'looking for info on local hotels' );

insert into REGISTRATION (ID, EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES ) 
values ( 2, 1, 2, '2019-01-13 00:00:00.0', 'na' );

insert into REGISTRATION (ID, EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES ) 
values ( 3, 2, 2, '2019-01-13 00:00:00.0', 'na' );