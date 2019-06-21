--계정 생성
CREATE USER exLogin IDENTIFIED BY exLogin;
--계정에 권한 부여
GRANT connect, dba TO exLogin;
