# datasource
持久层<br>

************************************************************************************************************************

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

# springboot3_mybatisplus
①MBP<br>
推荐写法：DataSourceConfig（model/mapper/XML）<br>
传统写法：Application（mapper）+application.properties（XML）<br>
②多数据源/事务<br>

# springboot3_jpa
事务（@EnableTransactionManagement+@Transactional）<br>
关联（多对多：双向关联+关联插入/更新/查询）<br>

******************************************************************************************

# springboot3_caffeine
Caffeine缓存<br>
ConcurrentHashMap自定义缓存<br>
@EnableCaching+@CacheConfig<br>

# sharding_mybatisplus
MBP+ShardingJDBC<br>
单库水平分表<br>
