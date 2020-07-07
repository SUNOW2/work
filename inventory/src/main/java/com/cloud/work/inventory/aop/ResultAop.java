package com.cloud.work.inventory.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 描述：添加切面
 *
 * @ClassName ResultAop
 * @Author 徐旭
 * @Date 2020-07-02 17:39
 * @Version 1.0
 */
@Component
@Aspect
@Slf4j
public class ResultAop {

    /**
     * execution：用于匹配方法执行的连接点
     * within：用于匹配指定类型中的方法执行
     * this：用于匹配当前AOP代理对象类型的执行方法
     * target：用于匹配当前目标对象的执行方法
     * args：用于匹配当前执行的方法传入的参数
     * @within：用于匹配所有持有指定注解类型内的方法
     * @target：用于匹配当前目标对象类型的执行方法，其中目标对象持有指定的注解
     * @args：用于匹配当前执行的方法传入的参数持有指定注解的执行
     * @annotation：用于匹配当前执行方法持有指定注解的方法
     */
    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController)")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public void handleResult(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();

        if (result != null) {
            String message = JSON.toJSONString(result);
            log.info("返回值 = " + message);
        }
    }
}
