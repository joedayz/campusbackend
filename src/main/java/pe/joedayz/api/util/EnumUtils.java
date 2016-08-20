package pe.joedayz.api.util;


import java.util.ArrayList;
import java.util.List;

public class EnumUtils {


    public static <StatusEnum extends EnumBase> List<StatusEnum> findAll(Class<StatusEnum> enumClass){
        List<StatusEnum> list= new ArrayList<StatusEnum>();

        for(StatusEnum status: enumClass.getEnumConstants()){
            list.add(status);
        }

        return list;
    }

    public static <StatusEnum extends EnumBase> StatusEnum findByCode(Class<StatusEnum> enumClass, String value){
        StatusEnum[] array= enumClass.getEnumConstants();
        StatusEnum result=null;
        for (int i=0;i<array.length;i++){
            if(array[i].getCode().equals(value)){
                result=array[i];
                break;
            }
        }
        return result;
    }

}
