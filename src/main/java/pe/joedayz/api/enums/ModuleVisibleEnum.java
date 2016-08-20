package pe.joedayz.api.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JULIO JUAREZ on 05/05/2016.
 */
public enum ModuleVisibleEnum {
    VISIBLE("1","True - Visible"),
    NO_VISIBLE("0","False - No Visible")
    ;

    private String code;
    private String label;

    ModuleVisibleEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static List<ModuleVisibleEnum> findAll(){
        List<ModuleVisibleEnum> list= new ArrayList<ModuleVisibleEnum>();

        for(ModuleVisibleEnum status: ModuleVisibleEnum.values()){
            list.add(status);
        }

        return list;
    }

    public static ModuleVisibleEnum findByCode(String value){
        ModuleVisibleEnum[] array= ModuleVisibleEnum.values();
        ModuleVisibleEnum result=null;
        for (int i=0;i<array.length;i++){
            if(array[i].getCode().equals(value)){
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
}
