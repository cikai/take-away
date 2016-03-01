### 订餐统计系统 demo

前台：

 * HTML
 * jQuery 2-1-4
 * [Bootstrap 3](http://www.bootcss.com/)
 * [jQuery-datatables](http://www.datatables.net/)

后台：

 * spring mvc
 * spring jdbc
 * maven


数据库配置（spring-context.xml）:

```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	<property name="driverClassName" value="driver"></property>
	<property name="url" value="url"></property>
	<property name="username" value="username"></property>
	<property name="password" value="password"></property>
</bean>
```

后台搭好的spring mvc可供参考学习

#### 联系作者:

 * E-mail: [cikai0923@gmail.com](mailto://cikai0923@gmail.com)
 * Github: [cikai](https://github.com/cikai)
 * Facebook: [Ci.Kai.0923](https://www.facebook.com/Ci.Kai.0923)
 * 个人博客: [http://cikai.me](http://cikai.me)
