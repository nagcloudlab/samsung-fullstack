
package com.example.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger("money-transfer-service");

    // @Before("execution(* com.example.service.UPITransferService.*(..))")
    // public void logBefore(JoinPoint joinPoint) {
    // logger.info(joinPoint.getSignature().getName() + " called...");
    // }

    // @AfterReturning(pointcut = "execution(*
    // com.example.service.UPITransferService.*(..))", returning = "result")
    // public void logAfterReturning(JoinPoint joinPoint, Object result) {
    // logger.info(joinPoint.getSignature().getName() + " returned " + result);
    // }

    // @AfterThrowing(pointcut = "execution(*
    // com.example.service.UPITransferService.*(..))", throwing = "exception")
    // public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
    // logger.error(joinPoint.getSignature().getName() + " threw " + exception);
    // }

    // @After("execution(* com.example.service.UPITransferService.*(..))")
    // public void logAfter(JoinPoint joinPoint) {
    // logger.info(joinPoint.getSignature().getName() + " completed...");
    // }

    @Around("execution(* com.example.service.UPITransferService.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            logger.info(joinPoint.getSignature().getName() + " before...");
            joinPoint.proceed();
            logger.info(joinPoint.getSignature().getName() + " after returning...");
        } catch (Exception e) {
            logger.error(joinPoint.getSignature().getName() + " after throwing " + e);
        } finally {
            logger.info(joinPoint.getSignature().getName() + " after...");
        }
    }

}
