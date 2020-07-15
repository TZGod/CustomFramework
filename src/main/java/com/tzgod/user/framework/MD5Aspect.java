package com.tzgod.user.framework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
@Aspect
public class MD5Aspect {

    @Pointcut("@annotation(com.tzgod.user.framework.MD5)")
    public  void MD5Cut(){}
    @Around("MD5Cut()")

    public  Object  MD5some(ProceedingJoinPoint joinPoint) throws Throwable {
        int A =0;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MD5 annotation = method.getAnnotation(MD5.class);
        String password = annotation.password();
        if (!(password==null||password.equals(""))){
            DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
            String[] parameterNames = discoverer.getParameterNames(method);
            System.out.println("parameterNames"+parameterNames[0]);
            for (int i = 0; i < parameterNames.length; i++) {
                if (parameterNames[i].equals(password)){
                    A=i;
                }
            }
        }
//        Field[] args = (Field[]) joinPoint.getArgs();
//        System.out.println(args[0]);
//        try {
//            for (Field user : args) {
//                //字段名称
//                String name = user.getName();
//                if (name.equals("username")) {
//                    //用于获取private成员变量
//                    user.setAccessible(true);
//                    System.out.println("字段名称：" + name);
//                    //字段值
////                    Object o = user.get(day);
////                    System.out.println("要获取字段的值：" + o);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Object[] args = joinPoint.getArgs();
        args[A]=MD5Utis.utils((String) args[A]);
        Object returnValue = joinPoint.proceed(args);
        return returnValue;
    }


}