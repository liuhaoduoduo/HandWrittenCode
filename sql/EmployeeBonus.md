# 员工奖金
* 题目要求：有Employee表和Bonus表，Employee表包含empId、name、salary、managerId等列，Bonus表包含empId和bonus列。要求报告每个奖金少于1000的员工的姓名和奖金数额。

原始表：Employee表
|empId|name|salary|managerId|
|---|---|---|---|
|1|Alice|5000.00|NULL|
|2|Bob|6000.00|1|
|3|Charlie|4500.00|1|
|4|David|7000.00|2|
|5|Eve|5500.00|2|

Bonus表
|empId|bonus|
|---|---|
|1|1500.00|
|2|800.00|
|3|NULL|
|4|2000.00|
|5|300.00|


查询结果
|empId|bonus|
|---|---|
|2|800.00|
|3|NULL|
|5|300.00|

* 解题思路：通过empId将两张表进行左连接，然后在WHERE子句中筛选出bonus<1000或bonus为NULL的记录。
* 查询语句
```
select e.empId,b.bonus from Employee e join Bonus b on e.empId = b.empId where b.bonus < 1000 or b.bonus is NULL;
```
* 测试环境初始代码
-- 创建 Employee 表，用于存储员工信息
```
CREATE TABLE Employee (
    empId INT PRIMARY KEY COMMENT '员工的唯一标识',
    name VARCHAR(50) COMMENT '员工姓名',
    salary DECIMAL(10, 2) COMMENT '员工薪水',
    managerId INT COMMENT '员工的上级经理 ID'
);
```

-- 创建 Bonus 表，用于存储员工的奖金信息
```
CREATE TABLE Bonus (
    empId INT COMMENT '员工的唯一标识，与 Employee 表的 empId 关联',
    bonus DECIMAL(10, 2) COMMENT '员工获得的奖金数额',
    FOREIGN KEY (empId) REFERENCES Employee(empId)
);
```

-- 向 Employee 表插入测试数据
```
INSERT INTO Employee (empId, name, salary, managerId) VALUES
(1, 'Alice', 5000.00, NULL),
(2, 'Bob', 6000.00, 1),
(3, 'Charlie', 4500.00, 1),
(4, 'David', 7000.00, 2),
(5, 'Eve', 5500.00, 2);
```

-- 向 Bonus 表插入测试数据
```
INSERT INTO Bonus (empId, bonus) VALUES
(1, 1500.00),
(2, 800.00),
(3, NULL),
(4, 2000.00),
(5, 300.00);
```