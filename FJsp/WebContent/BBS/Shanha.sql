create table member(
    userID varchar(20),
    userPassword varchar(20),
    userName varchar(20),
    userGender varchar(20),
    userEmail varchar(50),
    Primary key (userID));
    
select * from member;

insert into member VALUES('gildong', '1234', 'ȫ�浿', '����', 'gildong@naver.com');

select * from member;