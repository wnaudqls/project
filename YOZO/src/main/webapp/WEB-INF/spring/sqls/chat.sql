DROP TABLE CHAT;
CREATE SEQUENCE LIKE_BOARDSEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE CHAT(

	BROADCAST_NO NUMBER NOT NULL,
	CHAT_TITLE VARCHAR2(2000) NOT NULL,
	USER_ID VARCHAR2(2000) NOT NULL,
	CHAT_CONTENT VARCHAR2(2000) NOT NULL
    
    
);
ALTER TABLE CHAT ADD TYPE VARCHAR2(500)
ALTER TABLE CHAT ADD REGDATE DATE 

SELECT * FROM CHAT
ORDER BY REGDATE
