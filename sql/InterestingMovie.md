# 有趣的电影
* 题目要求：有一个cinema表，包含id、movie、description、rating等列，要求找出所有影片描述为非boring（不无聊）的并且id为奇数的影片，返回结果按rating降序排列。

原始表：

|id|movie|description|rating|
|---|---|---|---|
|1|Avatar|interesting|8.5|
|2|Titanic|boring|6.0|
|3|Inception|interesting|8.8|
|4|The Dark Knight|boring|7.5|
|5|Interstellar|interesting|8.6|
|6|Jurassic Park|boring|7.2|

查询结果
|id|movie|description|rating|
|---|---|---|---|
|3|Inception|interesting|8.8|
|5|Interstellar|interesting|8.6|
|1|Avatar|interesting|8.5|

* 解题思路：使用AND连接两个筛选条件，即description!='boring'和mod(id,2)=1，然后用ORDER BY rating DESC进行降序排列。
* 查询语句
```
select id,movie,description,rating from cinema where description != 'boring' order by rating DESC;
```
* 测试环境初始代码

-- 创建 cinema 表用于存储电影信息
```
CREATE TABLE cinema (
    id INT COMMENT '电影的唯一标识，用于区分不同的电影记录',
    movie VARCHAR(255) COMMENT '电影名称，记录电影的具体名字',
    description VARCHAR(255) COMMENT '电影描述，用于判断是否有趣',
    rating DECIMAL(3, 1) COMMENT '电影评分，反映受欢迎程度'
) COMMENT '存储电影信息的表';
```
-- 插入测试数据，包含不同电影的信息
```
INSERT INTO cinema (id, movie, description, rating) VALUES
(1, 'Avatar', 'interesting', 8.5),
(2, 'Titanic', 'boring', 6.0),
(3, 'Inception', 'interesting', 8.8),
(4, 'The Dark Knight', 'boring', 7.5),
(5, 'Interstellar', 'interesting', 8.6),
(6, 'Jurassic Park', 'boring', 7.2);
```