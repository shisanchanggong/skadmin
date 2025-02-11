package com.dxj.quartz.util;

import com.dxj.common.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * 执行定时任务
 *
 * @author dxj
 * @date 2019-01-07
 */
@Slf4j
public class QuartzRunnable implements Runnable {

    private Object target;
    private Method method;
    private String param;

    QuartzRunnable(String beanName, String methodName, String param)
            throws NoSuchMethodException, SecurityException {
        this.target = SpringContextHolder.getBean(beanName);
        this.param = param;

        if (StringUtils.isNotBlank(param)) {
            this.method = target.getClass().getDeclaredMethod(methodName, String.class);
        } else {
            this.method = target.getClass().getDeclaredMethod(methodName);
        }
    }

    @Override
    public void run() {
        try {
            ReflectionUtils.makeAccessible(method);
            if (StringUtils.isNotBlank(param)) {
                method.invoke(target, param);
            } else {
                method.invoke(target);
            }
        } catch (Exception e) {
            log.error("定时任务执行失败", e);
        }
    }

}
