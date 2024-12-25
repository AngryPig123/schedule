package com.schedule.schedule.config.mybatis;

import com.schedule.schedule.config.security.MemberDetails;
import com.schedule.schedule.entity.CommonEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Properties;

/**
 * packageName    : com.schedule.schedule.interceptor
 * fileName       : MybatisCommonEntityInterceptor
 * author         : AngryPig123
 * date           : 24. 12. 25.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 25.        AngryPig123       최초 생성
 */
@Slf4j
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class MybatisCommonEntityInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String method = invocation.getMethod().getName();
        Object[] args = invocation.getArgs();
        if ("update".equals(method)) commonEntityDateSet(args);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }

    private void commonEntityDateSet(Object[] args) {
        Long defaultMemberId = getCurrentMemberId();
        if (args != null) {
            for (Object arg : args) {
                if (arg != null && CommonEntity.class.isAssignableFrom(arg.getClass())) {
                    CommonEntity commonEntity = (CommonEntity) arg;
                    commonEntity.setCreatedBy(defaultMemberId);
                    commonEntity.setCreateAt(LocalDateTime.now());
                    commonEntity.setLastModifiedBy(defaultMemberId);
                    commonEntity.setLastModifiedAt(LocalDateTime.now());
                }
            }
        }
    }

    private Long getCurrentMemberId() {
        Authentication authentication = null;
        boolean valid = false;
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null) authentication = context.getAuthentication();
        if (authentication != null) valid = authentication.isAuthenticated();
        Long defaultMemberId = 0L;
        if (valid) {
            if (authentication.getPrincipal() instanceof MemberDetails) {
                defaultMemberId = ((MemberDetails) authentication.getPrincipal()).getMemberId();
            }
        }
        return defaultMemberId;
    }

}
