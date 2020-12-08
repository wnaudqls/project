DROP TABLE BROADCAST;


CREATE SEQUENCE BROAD_SEQ;
CREATE TABLE BROADCAST(

	BROADCAST_NO NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(50) NOT NULL,
	MEMBER_NICK VARCHAR2(50) NOT NULL,
    BROADCAST_TITLE VARCHAR2(2000) NOT NULL,
    BROADCAST_PASSWORD VARCHAR2(2000),
    BROADCAST_MAXCLIENT NUMBER NOT NULL,
    BROADCAST_CURRENTCLIENT NUMBER NOT NULL,
    BROADCAST_DATE DATE NOT NULL,
    BROADCAST_PUBLIC VARCHAR2(2000) CHECK(BROADCAST_PUBLIC IN ('Y','N')),
    BROADCAST_ANYONE VARCHAR2(2000) CHECK(BROADCAST_ANYONE IN ('Y','N'))

    
);

INSERT INTO BROADCAST
VALUES(BROAD_SEQ.NEXTVAL,'wnaudqls','asddfg','실험방',NULL, 10,0,SYSDATE, 'Y', 'N');

ALTER TABLE BROADCAST ADD BROADCAST_PUBLIC VARCHAR2(2000) CHECK(BROADCAST_PUBLIC IN ('Y','N'))

ALTER TABLE BROADCAST ADD BROADCAST_ANYONE VARCHAR2(2000) CHECK(BROADCAST_ANYONE IN ('Y','N'))




DELETE FROM BROADCAST

SELECT * FROM
BROADCAST;