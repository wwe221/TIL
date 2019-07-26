```mysql
CREATE TABLE T_USER
(
    ID          VARCHAR(20)    NOT NULL, 
    PWD         VARCHAR(20)    NOT NULL, 
    EMAIL       VARCHAR(20)    NOT NULL, 
    NICKNAME    NVARCHAR(20)    NOT NULL, 
    ICON        VARCHAR(20)    NULL, 
    ADMIN       int          NULL  
);

CREATE TABLE CATEGORY
(
    ID      int primary key auto_increment NOT NULL, 
    NAME    NVARCHAR(20)    NOT NULL 
);

CREATE TABLE STAR
(
    ID        int  primary key auto_increment NOT NULL, 
    USERID    VARCHAR(20)    NOT NULL, 
    POSTID    int          NOT NULL, 
    SCORE     int          NOT NULL     
);

CREATE TABLE POST
(
    ID          int  primary key auto_increment            NOT NULL, 
    TITLE       NVARCHAR(100)     NOT NULL, 
    TEXT        NVARCHAR(4000)    NOT NULL, 
    PDATE       DATE              NOT NULL, 
    CATEGORY    int            NOT NULL, 
    WRITER      NVARCHAR(20)      NOT NULL, 
    IMG01       NVARCHAR(20)      NULL, 
    IMG02       NVARCHAR(20)      NULL, 
    IMG03       NVARCHAR(20)      NULL, 
    CONTENTS    int            NULL, 
    REID        int            NULL   
);

CREATE TABLE CONTENT
(
    ID          int    primary key auto_increment       NOT NULL, 
    CATEGORY    int          NOT NULL, 
    TITLE       NVARCHAR(100)    NOT NULL, 
    OPEN        NVARCHAR(20)            NULL, 
    CLOSE       NVARCHAR(20)            NULL, 
    GENRE       NVARCHAR(20)    NULL, 
    POSTER      NVARCHAR(100)    NULL, 
    PLACE       NVARCHAR(50)    NULL, 
    LOCX        int          NULL, 
    LOCY        int          NULL, 
    DIRECTOR    NVARCHAR(50)    NULL, 
    ACTOR1      NVARCHAR(50)    NULL, 
    ACTOR2      NVARCHAR(50)    NULL, 
    ACTOR3      NVARCHAR(50)    NULL, 
    TIME        int          NULL, 
    COUNTRY    	NVARCHAR(20)    NULL, 
    GRADE       NVARCHAR(50)    NULL
);

```

