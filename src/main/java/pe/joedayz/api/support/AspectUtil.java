package pe.joedayz.api.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

public class AspectUtil {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String getObjectAsString(Object obj){

        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            //TODO ET show error as warning
            //e.printStackTrace();
        }

        return null;
    }


    public static String getParameterTypes(ProceedingJoinPoint proceedingJoinPoint){
        StringBuilder sb= new StringBuilder();
        final Signature signature = proceedingJoinPoint.getStaticPart().getSignature();
        if(signature instanceof MethodSignature){
            final MethodSignature ms = (MethodSignature) signature;
            final Class<?>[] parameterTypes = ms.getParameterTypes();
            if(parameterTypes!=null ){
                int paramIndex=1;
                for(final Class<?> pt : parameterTypes){
                    sb.append("\n").append("* Param Type "+paramIndex+":" + pt);
                    paramIndex++;
                }

            }

        }

        return sb.toString();
    }


    public static  String getParameterValues(ProceedingJoinPoint proceedingJoinPoint){
        StringBuilder sb= new StringBuilder();
        if(proceedingJoinPoint.getArgs()!=null && proceedingJoinPoint.getArgs().length>0){
            int paramIndex=1;
            for(final Object argument : proceedingJoinPoint.getArgs()){
                sb.append("\n");
                sb.append(" * Param "+paramIndex+" value:"+getObjectAsString(argument)).append("\n");
                paramIndex++;
            }
        }

        return sb.toString();
    }
}
