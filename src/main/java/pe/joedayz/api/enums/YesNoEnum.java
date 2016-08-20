package pe.joedayz.api.enums;


import java.util.List;

import pe.joedayz.api.util.EnumBase;
import pe.joedayz.api.util.EnumUtils;

public enum YesNoEnum implements EnumBase {
    YES("Y", "Yes"),
    NO("N", "No");

    private String code;
    private String label;

    YesNoEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }
    public static YesNoEnum resolve(boolean flag) {
        return flag?YES:NO ;
    }

    public static List<YesNoEnum> findAll() {
        return EnumUtils.findAll(YesNoEnum.class);
    }

    public static YesNoEnum findByCode(String value) {
        YesNoEnum result = EnumUtils.findByCode(YesNoEnum.class, value);
        if (result==null && value!=null && value.equals("1"))return YES;
        else if (result==null && value!=null && value.equals("0"))return NO;
        return result;
    }



    public static YesNoEnum findByValue(String value){
        YesNoEnum[] array= YesNoEnum.values();
        YesNoEnum result=null;
        for (int i=0;i<array.length;i++){
            if(array[i].getLabel().equalsIgnoreCase(value)){
                result=array[i];
                break;
            }
        }
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean asBool() {
        return this.equals(YES);
    }
}
