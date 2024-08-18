package com.example.aopdemo.aspect;

import com.example.aopdemo.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Emre Dinç
 */
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.aopdemo.service.*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        System.out.println("Method executed: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.example.aopdemo.service.UserService.login(..))")
    public void logBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            Object firstArg = args[0];
            if (firstArg instanceof User) {
                User user = (User) firstArg;
                System.out.println("Kullanıcı: " + user.getUsername()); // User nesnesinden bir alanı loglayın
            }
        }
        System.out.println("Yöntem çağrılıyor: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.aopdemo.service.UserService.login(..))")
    public void logAfter(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            Object firstArg = args[0];
            if (firstArg instanceof User) {
                User user = (User) firstArg;
                System.out.println("Kullanıcı: " + user.getUsername()); // User nesnesinden bir alanı loglayın
            }
        }
        System.out.println("Yöntem tamamlandı: " + joinPoint.getSignature().getName());
    }
}
