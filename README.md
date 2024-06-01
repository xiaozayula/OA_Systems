## OA系统-蓝山的考核项目：
<br>springboot3+mybatis+sa-token。  
### 功能：
<br>基础功能:登录功能,部门功能,工作功能,用户功能都完成了。
<br>略微不同的是，部门功能里的加入部门，转部门，请假这三个我写在一个请求表里来完成它。
<br>加分功能：
<br>1.将以上的各种流程操作记录都存在一个record表里，超级管理员可以通过查询这张表，看到所有的流程记录（请假、加入部门、转部门）。
<br>2.用户密码进行加盐加密，SaltMD5Util这个类使用了MD5哈希算法和一个随机生成的盐值来增加密码的安全性。
<br>3.使用的是sa-token框架来实现用户登录状态的保持。StpUtil.login(userId)方法在Session中设置了一个标识，表明用户已经登录，并且关联了用户的ID。之后，每当用户发送请求时，Sa-Token的拦截器会检查这个Session标识，如果存在且有效，则允许用户访问受保护的资源。  
### 鉴权：
<br>使用的是sa-token，原本我使用的shiro，结果config类我老是有bug就换了sa-token。。因为简单开始写的是注解鉴权，后面为了方便管理，改为了路由鉴权。  
### 学习心得：
<br>1.我还学到了枚举类，这是我第一次接触使用，感觉很方便。
<br>2.由于我的是Java 17，在pom.xml文件导入一些依赖有时候会因为版本有冲突而不行，我之前导入shiro依赖就遇到了这类问题，麻烦但至少学到了新知识。
