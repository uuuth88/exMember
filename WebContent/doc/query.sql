--계정 생성
CREATE USER exLogin IDENTIFIED BY exLogin;

--계정에 권한 부여
GRANT connect, dba TO exLogin;

--테이블 생성
CREATE TABLE memberInfo(
   id varchar2(50) not null,
   pw varchar2(100) not null,
   name varchar2(100) not null,
   nickname varchar2(100)
);

--기본키 제약 부여
ALTER TABLE memberInfo ADD CONSTRAINT pk_member PRIMARY KEY(id);

--테이블 제거
DROP TABLE memberInfo CASCADE CONSTRAINT;

--회원 정보 등록하는 쿼리
INSERT INTO memberInfo(id, pw, name, nickname) values(?, ?, ?, ?);﻿