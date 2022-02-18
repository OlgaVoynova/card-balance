/*
insert into card
(id,balance,pin,number,expire_date)
values
    ('8437105d-5c23-4a6a-a481-99e1a3b2b9d1',1234,'1234','1234',to_timestamp('09.11.22 00:00:00', 'DD.MM.RR HH24:MI:SS')),
    ('8437105d-5c23-4a6a-a481-99e1a3b2b9d2',4567,'4567','4567',to_timestamp('09.11.21 00:00:00', 'DD.MM.RR HH24:MI:SS')),
    ('8437105d-5c23-4a6a-a481-99e1a3b2b9d3',-7890,'7890','7890',to_timestamp('10.12.22 00:00:00', 'DD.MM.RR HH24:MI:SS'));
commit;


insert into session (id,card_Guid,fail_Code,success_attempt,attempt_Timestamp)
values
    ('8437105d-5c23-4a6a-a481-99e1a3b2b9d1','8437105d-5c23-4a6a-a481-99e1a3b2b9d1',null,true,to_timestamp('09.01.22 01:00:00', 'DD.MM.RR HH24:MI:SS')),
    ('8437105d-5c23-4a6a-a481-99e1a3b2b9d2',null,'CARD_NOT_FOUND',false,to_timestamp('09.01.22 00:00:00', 'DD.MM.RR HH24:MI:SS'))
    ;
commit;
*/