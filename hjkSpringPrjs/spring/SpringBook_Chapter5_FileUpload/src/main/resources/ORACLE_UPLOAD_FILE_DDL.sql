CREATE TABLE UPLOAD_FILE (
	FILE_ID 			NUMBER(10) 		PRIMARY KEY,
	DIRECTORY_NAME 		VARCHAR2(128),
	FILE_NAME 			VARCHAR2(128) 	NOT NULL,
	FILE_SIZE 			NUMBER(10),
	FILE_CONTENT_TYPE 	VARCHAR2(500),
	FILE_UPLOAD_DATE 	TIMESTAMP		NOT NULL,
	FILE_DATA 			BLOB
);
