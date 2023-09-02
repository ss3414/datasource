# datasource
持久层<br>

************************************************************************************************************************

# java_mybatis
①JDK8<br>
②Java直接整合MyBatis<br>
在Java中直接使用MyBatis框架需要读取配置，手动构造SqlSessionFactory/SqlSession<br>
③Spring整合MyBatis（传统写法）<br>
事务<br>

# ss_mybatis
①JDK6<br>
②Spring/SpringMVC整合原生MyBatis<br>
在Spring中配置SqlSessionFactoryBean/MapperScannerConfigurer（新版）<br>
③mybatis包<br>
Test1Mapper（系统学习）<br>
Test2Mapper（自行总结）<br>
④com包（原生MyBatis）<br>
Mybatis Generator Maven插件（打包时会调用此插件）<br>
PageHelper插件<br>
Druid监控（需要配置web.xml+数据源配置慢查询）<br>
Ehcache（Spring配置+ehcache.xml）<br>

# ss_mapper
①JDK6<br>
②Spring/SpringMVC整合通用Mapper<br>
在Spring中配置SqlSessionFactoryBean/MapperScannerConfigurer（TK版）/SqlSessionTemplate<br>
PageHelper插件<br>
MyMapper需要单独配置<br>

# ss_mybatisplus
①JDK8+Spring4+MyBatis-Plus3+MBP Generator（slf4j-api/freemarker/lombok）<br>
②Spring/SpringMVC整合MyBatis-Plus3<br>
在Spring中配置SqlSessionFactoryBean（MBP版）/MapperScannerConfigurer<br>
分页插件<br>

# ss_jpa
①JDK8<br>

# springboot_mybatis
①JDK8+SpringBoot+MyBatis+pagehelper<br>
②归档<br>
MyBatis注解/XML+CURD/关联<br>

# springboot_mybatisplus
①JDK8+SpringBoot2.1.3+mybatis-plus-boot-starter3.1.0+MBP Generator（freemarker/lombok）<br>
（不一定需要SQL XML）<br>
②SpringBoot整合mybatis-plus-boot-starter3.1.0<br>
推荐写法：DataSourceConfig（model/mapper/XML/分页）<br>
传统写法：Application（mapper/分页）+application.properties（XML）<br>
③多数据源/事务<br>

# springboot_jpa
①JDK8<br>
②JPA<br>
事务（@EnableTransactionManagement+@Transactional）<br>
关联（多对多：双向关联+关联插入/更新/查询）<br>

************************************************************************************************************************

# springboot_cache
①JDK8+MBP<br>
②缓存<br>
ConcurrentHashMap自定义缓存<br>
MBP二级缓存+Ehcache：@EnableCaching+@CacheConfig+@Cacheable+ehcache.xml<br>

# sharding_mybatisplus
①JDK8+MBP+sharding-jdbc<br>
②ShardingJDBC+MBP<br>
单库水平分表<br>
