maven project, empty project template.
spring mvc
spring data jpa
mysql


数据库配置====
	<!-- 默认链接 -->
    <!-- <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${db.driver}"/>
        <property name="url" value="${db.url}"/>
        <property name="username" value="${db.className}"/>
        <property name="password" value="${db.password}"/>
    </bean> -->

    <!-- bonecp connection pool -->
    <bean id="dataSource" class="com.jolbox.bonecp.BoneCPDataSource" destroy-method="close">
   		<property name="driverClass" value="${db.className}" />
        <property name="jdbcUrl" value="${db.url}" />
        <property name="username" value="${db.username}" />
        <property name="password" value="${db.password}" />

        <!-- 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0 -->
        <property name="idleConnectionTestPeriodInSeconds" value="120" />
        <!-- 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0 -->
        <property name="idleMaxAgeInSeconds" value="60" />
        <!-- 每个分区最大的连接数 -->
        <property name="maxConnectionsPerPartition" value="10" />
        <!-- 每个分区最小的连接数 -->
        <property name="minConnectionsPerPartition" value="1" />
     	<!-- 分区数 ，默认值2，最小1，推荐3-4，视应用而定 -->
        <property name="partitionCount" value="2" />
        <!-- 每次去拿数据库连接的时候一次性要拿几个,默认值：2 -->
        <property name="acquireIncrement" value="1" />
       	<!-- 缓存prepared statements的大小，默认值：0 -->
        <property name="statementsCacheSize" value="20" />
    </bean>
    
    <!-- alibaba druid -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close"> 
	    <!-- 基本属性 url、user、password -->
	    <property name="url">
	    	<value>jdbc:mysql://localhost:3306/emtpyWebTest?useUnicode=true&amp;characterEncoding=utf-8</value>
	    </property>
	    <property name="username">
	    	<value>root</value>
	    </property>
	    <property name="password">
	    	<value>Jose1123</value>
	    </property>
	
	    <!-- 配置初始化大小、最小、最大 -->
	    <property name="initialSize" value="1" />
	    <property name="minIdle" value="1" /> 
	    <property name="maxActive" value="20" />
	
	    <!-- 配置获取连接等待超时的时间 -->
	    <property name="maxWait" value="60000" />
	
	   <!--  配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
	    <property name="timeBetweenEvictionRunsMillis" value="60000" />
	
	    <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
	    <property name="minEvictableIdleTimeMillis" value="300000" />
	
	    <property name="validationQuery" value="SELECT 'x'" />
	    <property name="testWhileIdle" value="true" />
	    <property name="testOnBorrow" value="false" />
	    <property name="testOnReturn" value="false" />
	
	    <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
	    <property name="poolPreparedStatements" value="true" />
	    <property name="maxPoolPreparedStatementPerConnectionSize" value="20" />
	
	    <!-- 配置监控统计拦截的filters -->
	    <property name="filters" value="stat" />
	</bean>


