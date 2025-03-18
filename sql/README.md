一些常见的手写sql面试题实现
练习时需要使用docker建立一个mysql容器，可参考以下命令
```
docker run -d \
  --name mysql-container \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=%jf_}GVU.}31qM \
  -e MYSQL_USER=smallCookie \
  -e MYSQL_PASSWORD=%jf_}GVU.}31qM \
  -e MYSQL_DATABASE=small_cookie \
  mysql
```