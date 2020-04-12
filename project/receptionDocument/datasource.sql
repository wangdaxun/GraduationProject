DROP TABLE IF EXISTS student;
CREATE TABLE student(
	id INT PRIMARY KEY,
	name VARCHAR(20),
	age INT,
	mouth VARCHAR(20)
);
INSERT INTO student VALUES(1,'jwr',9,'6-10');

DROP TABLE IF EXISTS company;
CREATE TABLE company(
	company_id INT PRIMARY KEY AUTO_INCREMENT,
	company_name VARCHAR(50), 
	company_area VARCHAR(50),
	company_size VARCHAR(50),
	company_type VARCHAR(50),
	company_state INT,
	company_sort INT,
	company_viewnum INT,
	CHECK (company_state=1 or company_state=2 or company_state=3)
)AUTO_INCREMENT=1;
INSERT INTO company VALUES(1,'709软件公司','吉林长春','8人','软件',1,1,1000);

DROP TABLE IF EXISTS company_desc;
CREATE TABLE company_desc(
	company_id INT PRIMARY KEY NOT NULL,
	company_desc VARCHAR(500),
	company_img VARCHAR(500),
	created DATETIME,
	updated DATETIME
);
INSERT INTO company_desc VALUES (1,'<h2>这是一个很牛逼的公司</h2>','localhost:8081/img/709.jpg','2020-04-07 21:22:03','2020-04-07 21:22:03');

DROP TABLE IF EXISTS job;
CREATE TABLE job(
	job_id INT PRIMARY KEY AUTO_INCREMENT,
	company_id INT not null,
	job_cid INT,
	job_name VARCHAR(50),
	job_hiringnum INT,
	job_salary VARCHAR(20),
	job_area VARCHAR(255),
	job_desc VARCHAR(255),
	job_endtime DATE,
	job_state INT,
	CHECK (job_state=1 or job_state=2 or job_state=3)
)AUTO_INCREMENT=1;
INSERT INTO job VALUES(1,1,1,'前端工程师',2,'1w-1w5','吉林长春','招两个牛逼的程序员','2020-05-01',1);

DROP TABLE IF EXISTS job_cat;
CREATE TABLE job_cat(
	cid INT PRIMARY KEY,
	parent_cid INT,
	name VARCHAR(20),
	status INT,
	is_parent INT,
	created DATETIME,
	UPDATED DATETIME,
	CHECK (status=1 or status =0),
	CHECK (is_parent=1 or is_parent=0)
);
INSERT INTO job_cat VALUES(1,0,'互联网',1,1,'2020-04-07 21:22:03','2020-04-07 21:22:03');

DROP TABLE IF EXISTS job_apply;
CREATE TABLE job_apply(
	apply_id INT PRIMARY KEY AUTO_INCREMENT,
	job_id INT not null,
	applicant_id INT,
	apply_date DATETIME,
	apply_state INT,
	CHECK (apply_state=1 or apply_state=2 or apply_state=3)
)AUTO_INCREMENT=1;
INSERT INTO job_apply VALUES(1,1,1,'2020-04-07 21:22:03',1);

DROP TABLE IF EXISTS applicant;
CREATE TABLE applicant(
	applicant_id INT PRIMARY KEY AUTO_INCREMENT,
	applicant_email VARCHAR(50),
	applicant_pwd VARCHAR(50),
	applicant_registdate DATETIME
)AUTO_INCREMENT=1;
INSERT INTO applicant VALUES(1,'835321694@qq.com','jkjkjkjk','2020-04-07 21:22:03');

DROP TABLE IF EXISTS resume_basicinfo;
CREATE TABLE resume_basicinfo(
	basicinfo_id INT PRIMARY KEY AUTO_INCREMENT,
	applicant_id INT not null,
	realname VARCHAR(50) not null,
	gender VARCHAR(50),
	birthday DATE,
	current_loc VARCHAR(255),
	resident_loc VARCHAR(255),
	telephone VARCHAR(255),
	email VARCHAR(50),
	job_intension VARCHAR(50),
	job_experience VARCHAR(255),
	head_shot VARCHAR(255)
)AUTO_INCREMENT=1;
INSERT INTO resume_basicinfo VALUES(1,1,'jwr','男','1998-01-01','苏州','赤峰','13936597125','835321694@qq.com','前端工程师','1年','localhost:8080/img/jwr.jpg');

DROP TABLE IF EXISTS resume_education;
CREATE TABLE resume_education(
	education_id INT PRIMARY KEY AUTO_INCREMENT,
	basicinfo_id INT not null,
	graduate_school VARCHAR(50),
	time_duration DATE,
	education_degree VARCHAR(50),
	profession VARCHAR(50)
)AUTO_INCREMENT=1;
INSERT INTO resume_education VALUES(1,1,'长春工程学院','2020-06-10','本科','软件工程');

DROP TABLE IF EXISTS resume_project_experience;
CREATE TABLE resume_project_experience(
	project_id INT PRIMARY KEY AUTO_INCREMENT,
	basicinfo_id INT not null,
	project_name VARCHAR(50),
	project_period VARCHAR(50),
	JOB_TITLE VARCHAR(50),
	JOB_DESC VARCHAR(255)
)AUTO_INCREMENT=1;
INSERT INTO resume_project_experience VALUES(1,1,'橘子旅行','2019-2020','项目组长','担当主要c位');

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	apply_id INT,
	user_logname VARCHAR(50),
	user_pwd VARCHAR(50),
	user_email VARCHAR(50),
	user_role INT,
	user_state INT,
	check(user_role=0 or user_role=1 or user_role=2),
	check(user_state=1 or user_state=0)
)AUTO_INCREMENT=1;
INSERT INTO users VALUES(1,1,'jwr','jkjkjkjk','835321694@qq.com',2,1);


INSERT INTO company VALUES(2,'苏州大宇宙公司','江苏苏州','1000人','软件',1,1,1000);
INSERT INTO company VALUES(3,'方正普华','江苏苏州','50人','软件',1,1,1000);
INSERT INTO company VALUES(4,'阿里巴巴','吉林长春','1w人','软件',1,1,1000);
INSERT INTO company VALUES(5,'字节跳动','吉林长春','2w人','软件',1,1,1000);
INSERT INTO company VALUES(6,'腾讯','广东深圳','4人','软件',1,1,1000);

INSERT INTO job VALUES(2,1,1,'后端工程师',2,'3w-3w5','吉林长春','招两个牛逼的程序员','2020-05-01',1);
INSERT INTO job VALUES(3,1,1,'全栈工程师',2,'4w-4w4','吉林长春','招两个牛逼的程序员','2020-05-01',1);
INSERT INTO job VALUES(4,2,1,'后端工程师',2,'3w-3w5','吉林长春','招两个牛逼的程序员','2020-05-01',1);
INSERT INTO job VALUES(5,2,1,'后端工程师',2,'3w-3w5','吉林长春','招两个牛逼的程序员','2020-05-01',1);
INSERT INTO job VALUES(6,3,1,'后端工程师',2,'3w-3w5','吉林长春','招两个牛逼的程序员','2020-05-01',1);
INSERT INTO job VALUES(7,4,1,'后端工程师',2,'3w-3w5','吉林长春','招两个牛逼的程序员','2020-05-01',1);