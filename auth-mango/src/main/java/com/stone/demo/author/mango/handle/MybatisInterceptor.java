package com.stone.demo.author.mango.handle;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

/***
 *
 * @Class MybatisInterceptor
 * @Descrip TODO
 * @author Stone
 * @data 21-1-19  下午8:52
 * @Version 1.0
 */

@Component
@Intercepts({@org.apache.ibatis.plugin.Signature(type=org.apache.ibatis.executor.statement.StatementHandler.class, method="prepare", args={Connection.class,Integer.class})})
public class MybatisInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(MybatisInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object target = invocation.getTarget(); //被代理对象
        if (target instanceof StatementHandler) {
            StatementHandler delegate = (StatementHandler)invocation.getTarget();
            BoundSql boundSql = delegate.getBoundSql();
            String sql = boundSql.getSql();
            logger.info("SQL: {}", sql.replace("   "," ").replace("  "," ").replace("\n",""));
        }
        Object result = invocation.proceed();
        long duration = System.currentTimeMillis() - start;
        logger.info("Time elapsed: {}ms", duration);
        return result;
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
