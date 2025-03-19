# 学生参加测试的次数
* 题目要求：有Students表、Subjects表和Examinations表，Students表包含student_id、student_name等列，Subjects表包含subject_name列，Examinations表包含student_id、subject_name等列。要求查询出每个学生参加每一门科目测试的次数，结果按student_id和subject_name排序。

原始表：Students（学生表）
|student_id|student_name|
|-|-|
|1|Alice|
|2|Bob|
|3|Charlie|

原始表：Subjects（科目表）
|subject_name|
|-|
|Math|
|Physics|
|Chemistry|

原始表：Examinations（参加考试的记录表）
|student_id|subject_name|
|-|-|
|1|Math|
|1|Physics|
|2|Math|
|2|Math|
|3|Chemistry|

查询结果
|student_id|student_name|subject_name|attended_exams|
|-|-|-|-|
|1|Alice|Chemistry|0|
|1|Alice|Math|1|
|1|Alice|Physics|1|
|2|Bob|Chemistry|0|
|2|Bob|Math|2|
|2|Bob|Physics|0|
|3|Charlie|Chemistry|1|
|3|Charlie|Math|0|
|3|Charlie|Physics|0|

* 解题思路：
    * 第一步，根据题意要求需要查询出每个学生的每一科目，那就意味着需要对Students（学生表）和Subjects（科目表）做一个笛卡尔积。
    * 第二步，在Examinations（参加考试的记录表）表中统计出每名学生参加每个科目的次数（使用group by 对student_id和subject_name进行分组后使用聚合函数count(*)进行统计）。
    * 第三步，利用左联查询保留第一步的笛卡尔积全部结果的前提下，与第二步的统计结果进行连接，连接条件是student_id和subject_name都相等。第四部
    * 第四步，这里需要用到一个ifnull函数，因为可能有的学生为参加任何考试，无法统计出其参加次数，在进行左联时将用null来填充结果。所以此时需要将null通过ifnull函数来将其替换成0.ifnull函数有两个参数，其作用是当第一个参数所代表的列值为null时将使用第二个参数的值来代替null。所以在解本题时需要这样写IFNULL(e.attended_exams, 0)
    * 第五步，根据student_id和subject_name字段进行一个排序
* 查询语句
```
select 
    s.student_id,
    s.student_name,
    sub.subject_name,
    IFNULL(e.attended_exams, 0) AS attended_exams 
from 
    Students s 
cross join 
    Subjects sub 
left join 
    (select
         student_id,
         subject_name,
         count(*) as attended_exams
     from 
        Examinations 
     group by 
        student_id,subject_name
    ) e on s.student_id=e.student_id and sub.subject_name=e.subject_name 
order by s.student_id,sub.subject_name;
```


* 测试环境初始代码
```
-- 创建 Students 表，用于存储学生信息
CREATE TABLE Students (
    student_id INT PRIMARY KEY COMMENT '学生的唯一标识',
    student_name VARCHAR(50) COMMENT '学生姓名'
);
```
```
-- 创建 Subjects 表，用于存储科目信息
CREATE TABLE Subjects (
    subject_name VARCHAR(50) PRIMARY KEY COMMENT '科目名称'
);
```
```
-- 创建 Examinations 表，用于存储学生参加考试的记录
CREATE TABLE Examinations (
    student_id INT COMMENT '学生的唯一标识，与 Students 表的 student_id 关联',
    subject_name VARCHAR(50), COMMENT '科目名称，与 Subjects 表的 subject_name 关联'
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (subject_name) REFERENCES Subjects(subject_name)
);
```

```
-- 向 Students 表插入测试数据
INSERT INTO Students (student_id, student_name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Charlie');
```

```
-- 向 Subjects 表插入测试数据
INSERT INTO Subjects (subject_name) VALUES
('Math'),
('Physics'),
('Chemistry');
```

```
-- 向 Examinations 表插入测试数据
INSERT INTO Examinations (student_id, subject_name) VALUES
(1, 'Math'),
(1, 'Physics'),
(2, 'Math'),
(2, 'Math'),
(3, 'Chemistry');
```