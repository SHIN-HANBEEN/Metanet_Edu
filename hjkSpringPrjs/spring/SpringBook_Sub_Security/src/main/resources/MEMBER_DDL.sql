DROP TABLE MEMBER;
CREATE TABLE MEMBER (
	USERID VARCHAR2(50) CONSTRAINT PK_MEMBER PRIMARY KEY,
	NAME VARCHAR2(50) NOT NULL,
	PASSWORD VARCHAR2(100) NOT NULL,
	EMAIL VARCHAR2(100) NOT NULL,
	PHONE VARCHAR2(50),
	ROLE VARCHAR2(50) DEFAULT 'ROLE_USER'
);

ALTER TABLE MEMBER 
 ADD CONSTRAINT UK_MEMBER_EMAIL UNIQUE (EMAIL) 
 USING INDEX
;

INSERT INTO member (userid, name, password, email, phone)
VALUES ('user', '사용자', '{bcrypt}$2a$10$hv0WHs5hsZ489idbpq1oseyaDrw0puzgypVdlywLZ85qAGXq5xNDK', 'user@user.com', '010-1111-2222');

INSERT INTO member (userid, name, password, email, phone, role)
VALUES ('admin', '사용자', '{bcrypt}$2a$10$786rBTGQvOfUjfoTpWtFi.yWD0cZ6hwKpnS3X8GEj9erMAvvHTtkC', 'admin@myapp.com', '010-3333-4444', 'ROLE_ADMIN,ROLE_USER');

COMMIT;