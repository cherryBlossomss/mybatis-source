##  执行流程


### 从 XML 中构建 SqlSessionFactory

解析所有classpath地下的所有xml为Configuration，，且构建为DefaultSqlSessionFactory

```java
Reader reader = Resources.getResourceAsReader("Configuration.xml")
SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
```


### 准备执行器execute  ==>DefaultSqlSession

```java
SqlSession session = sqlMapper.openSession()
```

### 执行sql

```java
User user = session.selectOne("org.github.baker.internal.inter.UserMapper.selectById", 1L)
```