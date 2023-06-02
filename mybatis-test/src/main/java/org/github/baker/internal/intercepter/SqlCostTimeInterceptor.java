package org.github.baker.internal.intercepter;

import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

//@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class,
//        Object.class, RowBounds.class,ResultHandler.class}),
//})
public class SqlCostTimeInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(SqlCostTimeInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        long startTime = System.currentTimeMillis();
        Executor executor = (Executor) target;
        try {
            return invocation.proceed();
        } finally {
            long costTime = System.currentTimeMillis() - startTime;
//            BoundSql boundSql = executor.
//            String sql = boundSql.getSql();
            logger.info("执行 SQL：[ {} ]执行耗时[ {} ms]");
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息："+properties);
    }
}

