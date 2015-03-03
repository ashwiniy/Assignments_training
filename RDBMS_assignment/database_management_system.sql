creation of tables:
------------------------------
 CREATE TABLE `users` (
  `id` int(11) NOT NULL DEFAULT '0',
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
--------------------------------------
CREATE TABLE `answers` (
  `id` int(11) NOT NULL DEFAULT '0',
  `question_id` int(11) DEFAULT NULL,
  `correctoption` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `answers_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
);
---------------------------------------

CREATE TABLE `options` (
  `id` int(11) NOT NULL DEFAULT '0',
  `question_id` int(11) DEFAULT NULL,
  `option_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `options_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
);
-----------------------------------------
CREATE TABLE `questions` (
  `id` int(11) NOT NULL DEFAULT '0',
  `question` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
---------------------------------------------
CREATE TABLE `assignments` (
  `id` int(11) NOT NULL DEFAULT '0',
  `assignment_name` varchar(30) DEFAULT NULL,
  `admin_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `admin_user_id` (`admin_user_id`),
  CONSTRAINT `assignments_ibfk_1` FOREIGN KEY (`admin_user_id`) REFERENCES `users` (`id`)
);
----------------------------------------------
CREATE TABLE `assignment_questions` (
  `id` int(11) NOT NULL DEFAULT '0',
  `assignments_id` int(11) DEFAULT NULL,
  `questions_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `assignments_id` (`assignments_id`),
  KEY `questions_id` (`questions_id`),
  CONSTRAINT `assignment_questions_ibfk_1` FOREIGN KEY (`assignments_id`) REFERENCES `assignments` (`id`),
  CONSTRAINT `assignment_questions_ibfk_2` FOREIGN KEY (`questions_id`) REFERENCES `questions` (`id`)
);
-------------------------------------------------
CREATE TABLE `assignment_scores` (
  `id` int(11) NOT NULL DEFAULT '0',
  `assignments_id` int(11) DEFAULT NULL,
  `candidate_users_id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `assignments_id` (`assignments_id`),
  KEY `candidate_users_id` (`candidate_users_id`),
  CONSTRAINT `assignment_scores_ibfk_1` FOREIGN KEY (`assignments_id`) REFERENCES `assignments` (`id`),
  CONSTRAINT `assignment_scores_ibfk_2` FOREIGN KEY (`candidate_users_id`) REFERENCES `users` (`id`)
);
----------------------------------------------------
CREATE TABLE `assignments_allocations` (
  `id` int(11) NOT NULL DEFAULT '0',
  `assignment_id` int(11) DEFAULT NULL,
  `candidate_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `assignment_id` (`assignment_id`),
  KEY `candidate_user_id` (`candidate_user_id`),
  CONSTRAINT `assignments_allocations_ibfk_1` FOREIGN KEY (`assignment_id`) REFERENCES `assignments` (`id`));
-------------------------------------------------------
CREATE TABLE `candidate_submissions` (
  `id` int(11) NOT NULL DEFAULT '0',
  `assignments_id` int(11) DEFAULT NULL,
  `candidate_users_id` int(11) DEFAULT NULL,
  `questions_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `assignments_id` (`assignments_id`),
  KEY `candidate_users_id` (`candidate_users_id`),
  KEY `questions_id` (`questions_id`),
  CONSTRAINT `candidate_submissions_ibfk_1` FOREIGN KEY (`assignments_id`) REFERENCES `assignments` (`id`),
  CONSTRAINT `candidate_submissions_ibfk_2` FOREIGN KEY (`candidate_users_id`) REFERENCES `users` (`id`),
  CONSTRAINT `candidate_submissions_ibfk_3` FOREIGN KEY (`questions_id`) REFERENCES `questions` (`id`)
);
----------------------------------------------------------
 CREATE TABLE `candidate_submission_answers` (
  `id` int(11) NOT NULL DEFAULT '0',
  `candidate_submissions_id` int(11) DEFAULT NULL,
  `options_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `candidate_submissions_id` (`candidate_submissions_id`),
  KEY `options_id` (`options_id`),
  CONSTRAINT `candidate_submission_answers_ibfk_1` FOREIGN KEY (`candidate_submissions_id`) REFERENCES `candidate_submissions` (`id`),
  CONSTRAINT `candidate_submission_answers_ibfk_2` FOREIGN KEY (`options_id`) REFERENCES `options` (`id`)
);
-----------------------------------------------------------
CREATE TABLE `roles` (
  `id` int(11) NOT NULL DEFAULT '0',
  `rolename` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-----------------------------------------------------------
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  `roles_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roles_id` (`roles_id`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
);
------------------------------------------------------------------

insert into assignments values('01','oops','1');
insert into assignments values('02','programming_language','2');
insert into assignments values('03','RDBMS','1');

insert into questions values('001','what are the types of databases');
insert into questions values('002','what are the types of programming languages');
insert into questions values('003','which of these are procedural languages');

insert into assignment_questions values('11','01','001');
insert into assignment_questions values('12','02','001');
insert into assignment_questions values('13','01','001');

insert into assignments_allocations values('21','01','3');
insert into assignments_allocations values('22','02','3');
insert into assignments_allocations values('23','01','2');

insert into options values('31','001','relational databases');
insert into options values('32','001','transactional databases');
insert into options values('33','002','C');
insert into options values('34','002','CPP');
insert into options values('35','002','JAVA');
insert into options values('36','003','basic');
insert into options values('37','003','C');
insert into options values('38','003','C#');
insert into options values('39','003','JAVA');


insert into answers values('41','001','A');
insert into answers values('42','002','B');
insert into answers values('43','003','C');

-------------------------------------------------------------------------------
create view candidate_score AS
     select u.id,u.username,u.password,a.score
     from users u,assignment_scores a
     where u.id = a.candidate_user_id ;
-------------------------------------------------------------------------------

SET @sql = NULL;
SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT(
      '(IF(ticker = ''',
      ticker,
      ''', open, NULL)) AS ''',
      ticker,''''
    )
  ) INTO @sql
FROM
  prices;

SET @sql = CONCAT('SELECT dt, ', @sql, ' FROM prices');
-- SET @sql = CONCAT('SELECT dt, ', @sql, ' FROM prices GROUP BY dt');

  PREPARE stmt FROM @sql;
  EXECUTE stmt;


select group_concat(distinct concat(`id`,`username`,`question`))into @sql from pivot1;



SET @sql = NULL;
SELECT
GROUP_CONCAT(DISTINCT
CONCAT(
'(IF(pivot1.question = ''',
pivot1.question,
''', pivot1.option_name, NULL)) AS ',
question
)
) INTO @sql
FROM
pivot1;
SET @sql = CONCAT('SELECT id,user_name ', @sql, ' FROM pivot1 GROUP BY id');




select group_concat(distinct concat('if(p.question = ''',question,''',option_name,NULL) as ',quote(question))) into @sql from pivot1 p;



 select @sql;


mysql>  set @sql = concat('select p.id,p.username,',@sql,' from pivot1 p');
Query OK, 0 rows affected

prepare st from @sql;

execute st;


