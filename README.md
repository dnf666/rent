# dinner

一个带后台管理的简单点餐系统

# 技术选型
 前端：vue+elementui
 后台：spring+springmvc+mybatis+mybatis-generator
 
# 部署方法

1. 创建数据库 dinner，导入doc/SQL/dinner.sql
2. 修改src/main/resources/springconfig.xml的数据库连接，用户名，密码
3. 打一个war包。打包成功可得到一个dinner.war
4. 拷贝dinner.war到tomcat服务器的webapps目录
5. 点击tomcat的bin目录下的.start.bat(windows平台)。启动tomcat
6. 访问http://ip:port/dinner/index.html .ip是tomcat所在的服务器ip.本地请用localhost
port是tomcat服务器的端口号

# 注意事项
1. 需要java8，mysql5.7 。不能是mysql8，会报错
2. 由于没有图片服务器，图片保存在photo目录下，重新部署会导致photo目录的图片丢失
注意保存
3. 前端界面网址 https://github.com/dnf666/dinnerhtml.git。如何和javaweb项目合并，自己百度
4. 默认管理员账号 admin 密码 admin。 可在数据库修改账号和密码
