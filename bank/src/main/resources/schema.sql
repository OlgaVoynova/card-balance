
DROP TABLE IF EXISTS card;

create table card (
   id UUID PRIMARY KEY,
   balance INTEGER,
   pin VARCHAR (4) NOT NULL,
   number VARCHAR (18) NOT NULL,
   expire_date TIMESTAMP NOT NULL
);

create table session (
  id UUID PRIMARY KEY,
  card_guid UUID,
  attempt_timestamp TIMESTAMP NOT NULL,
  success_attempt boolean NOT NULL,
  fail_code VARCHAR (20)
);