### 接入方式
本模块基于SpringBoot方式，在application.properties进行以下配置
spring.datasource.url=jdbc:mysql://localhost:3306/DemoDatabase?useSSL=false&useUnicode=true&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver



### 设计思路

引擎层。
将model层的数据转换成SQL进行执行。

------------------------------------------------

fieldCode校验
fieldCode只能是以下情况的值。
1，fieldCode一定是数据库对应的字段名，且名称相同。
避免随便传递fieldCode，造成SQL注入等问题。
2，用户注册过的值，如虚拟字段（由查询结果二次计算得到的字段）。

校验方式
将物理字段和虚拟字段全部加载到缓存中，然后校验。


