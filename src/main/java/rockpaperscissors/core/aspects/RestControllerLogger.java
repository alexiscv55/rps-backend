package rockpaperscissors.core.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

/**
 * Log calls to rest controllers
 */
@Log
@Aspect
@Component
public class RestControllerLogger {
    
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void restControllers() {}

    @Pointcut("execution(public * *(..))")
    public void publicMethods() {}

    @Pointcut("restControllers() && publicMethods()")
    public void loggableMethods() {}

    @Around("loggableMethods()")
    public Object logMethod(ProceedingJoinPoint pjp) throws Throwable {
        logIt("Calling \"%s\" in %s", pjp);

        var returnValue = pjp.proceed();

        logIt("Exiting successfully call to \"%s\" in %s", pjp);

        return returnValue;
    }

    protected void logIt(String stringTemplate, ProceedingJoinPoint pjp) {
        var msg = String.format(stringTemplate,
            pjp.getSignature().getName(),
            pjp.getSignature().getDeclaringType()
        );
        log.info(msg);
    }
}
