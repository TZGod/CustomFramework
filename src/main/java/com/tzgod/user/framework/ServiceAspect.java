package com.tzgod.user.framework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class ServiceAspect {
    @Autowired
    private ApplicationContext applicationContext;

    @Pointcut("@annotation(com.tzgod.user.framework.Face)")
    public  void FaceCut(){
    }
    @Pointcut("@annotation(com.tzgod.user.framework.Impl)")
    public  String Implut(){
        return null;
    }


    @Around("FaceCut()")
    public  Object  Facesome(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
            System.out.println("获取签名:"+signature);
        Method method = signature.getMethod();
        String name1 = method.getName();
        System.out.println("获取方法:"+name1);
            System.out.println("获取方法:"+method.getParameters()[0]);
            System.out.println("获取方法:"+method.getParameters()[0].getType());
        Object[] args = joinPoint.getArgs();
            System.out.println("获取值"+args[0]);
        String name = method.getParameters()[0].getName();
            System.out.println("获取入参名:"+name);


        Class declaringType = signature.getDeclaringType();
            System.out.println("获取类"+declaringType);
        Impl annotation = (Impl) declaringType.getAnnotation(Impl.class);
            System.out.println("获取注解类上注解:"+annotation.value());
    //注入
        Class value = annotation.value();
        System.out.println(value);
        // 获取spring中的bean对象
        Object bean = applicationContext.getBean(value);
        System.out.println("bean::"+bean.toString());
        Method[] declaredMethods = value.getDeclaredMethods();
        for (Method f:declaredMethods) {
            if (f.getName().equals(name1)){
                Object invoke = f.invoke(bean, args[0]);
                System.out.println("结果=="+invoke);
                return invoke;
            }
            System.out.println(f.getName());
        }

        return null;
    }

}
