## DBMS

###### (Data Base Managemnet System)

데이터베이스를 관리하기 위한 컴퓨터 시스템

DBMS 가 없는 데이터 관리 시스템의 단점

1.  다수의 사람이 데이터를 고유하기 어렵다.
2.  대량의 데이터를 다루기 어려운 형태
3.  읽기/쓰기를 자동화하려면 프로그래밍 기술이 필요
4. 만일의 사고에 대비하기 어렵다.

이러한 단점들을 해결하기 위해 나온것이 DBMS 이다.

###### 다양한 종류의 DBMS

데이터의 저장형식에 따라 분류된다.

- 계층형 DB

  가장 오래된 형태, 데이터를  계층 구조(트리)로 표현

- 관계형 DB

  관계 (Relation)DB라고도 불리며 열과 행, 2차원 표 형식으로 관리하기 때문에 이해하기 쉽다.

  `SQL` 이라는 전용 언어를 사용한다.

- 객체지향 DB

  데이터와 데이터 처리를 모아서 `객체` 단위로 관리한다.

- XML DB

  XML 형식을사용하고, 대량으로 빠르게처리 하기 위해 고안됐다.

- 키 - 밸류 형 데이터 스토어

  Key - Value 로 조합해 단순한 형태로 저장하는 DB. 해시(Hash)와 비슷한 구조

  대량의 데이터를 초고속으로 검색하는 서비스 등에 사용

  

## RDBMS

2차원 구조인 `테이블`로 데이터를 저장한다.

레코드( 행, 가로)

칼럼(열 , 세로)

## SQL

###### (Structed Query Language)

관계형 데이터베이스 구성에 사용되는 언어.

###### 종류

- DDL (Data Definition Lang)

  - CREATE - DB 나 테이블 생성한다.

  - DROP - DB 나 테이블 삭제한다.

  - ALTER - DB 나 테이블 등의 구성을 변경 한다.

    

- DML (Data Menipulation L)

  - SELECT

  - INSERT

  - DELETE

  - UPDATE

    

- DCL (Data Control L)

  - COMMIT - 데이터베이스 변경 내용을 확정한다. - Transaction 에 사용
  - ROLLBACK - 데이터베이스 변경 내용을 취소한다.  - Transaction 에 사용
  - GRANT - 사용자에게 권한을 부여
  - REVOKE - 사용자에게 권한을 제거



```sql
/*테이블 생성*/
CREATE TABLE T_USER(
    ID VARCHAR2(10), 
    PWD VARCHAR2(10),
    NAME VARCHAR2(20),
    AGE NUMBER(3),
    BALANCE NUMBER(10 , 4)
);
/*
CHAR- 고정 문자열 -- 글자수가 정해져있음
VARCHAR - 가변 문자열 -- 넣은 만큼 글자수를 가짐
NUMBER(10 , 4) -- 소숫점 4자리 까지 표현가능한 실수
*/
DESC T_USER; /*테이블 구성 출력*/
SELECT * FROM T_USER; /*테이블 내용 출력*/
DROP TABLE T_USER; /* 테이블 삭제 (데이터 모두 삭제)*/

CREATE TABLE T_PRODUCT(
   ID VARCHAR2(10) PRIMARY KEY,
NAME VARCHAR2(10) NOT NULL,
PRICE NUMBER(10,1) NOT NULL
);

ALTER TABLE T_PRODUCT ADD (REGDATE DATE); /*컬럼 추가*/

ALTER TABLE T_PRODUCT DROP (REGDATE); /*컬럼 삭제*/

ALTER TABLE T_PRODUCT RENAME COLUMN NAME TO UNAME; /* 컬럼 이름 변경*/

ALTER TABLE T_PRODUCT TO N_PRODUCT;/*테이블 이름 변경*/

ALTER TABLE T_PRODUCT ADD PRIMARY KEY(ID); /*Primary Key 추가*/

/*데이터베이스에 입력 insert*/
INSERT INTO T_USER( ID , PWD) VALUES( 'ID01' , 'PWD01');
INSERT INTO T_USER VALUES( 'ID01' , 'PWD01','이말년');

/*데이타 타입 변경 modify*/
ALTER TABLE T_PRODUCT MODIFY (NAME CHAR (10)); 
ALTER TABLE T_USER MODIFY (PWD NOT NULL);
ALTER TABLE T_PRODUCT MODIFY PRICE NUMBER  NULL;
ALTER TABLE T_PRODUCT MODIFY (PRICE DEFAULT 1000); /* 기본 값 설정( NOT NULL 인 것에 사용하면 좋음*/
/*데이터 삭제 delete */
DELETE FROM T_PRODUCT WHERE ID = 'ID02';
DELETE FROM T_PRODUCT;
/*데이터 갱신 update*/
UPDATE T_USER SET PWD = '111' WHERE ID = 'ID01';
UPDATE T_USER SET PWD = '111', NAME = '공말년' WHERE ID = 'ID01';

```










