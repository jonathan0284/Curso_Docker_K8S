ALTER SESSION SET CONTAINER=CDB$ROOT;
ALTER DATABASE OPEN;
CREATE PLUGGABLE DATABASE XEPDB2 FROM XEPDB1;
ALTER PLUGGABLE DATABASE XEPDB2 OPEN;