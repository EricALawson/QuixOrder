CREATE TABLE account (
  id UUID NOT NULL PRIMARY KEY,
  type VARCHAR(6) NOT NULL,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(32) NOT NULL,
  CONSTRAINT uc_account UNIQUE (type, username)
);