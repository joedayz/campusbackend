package pe.joedayz.api.enums;

import java.util.ArrayList;
import java.util.List;


public enum ActiveInactiveStatusEnum {
    ACTIVE("A","Active"),
    INACTIVE("I","Inactive")
    ;

    private String code;
    private String label;

    ActiveInactiveStatusEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public boolean isActive(){
        return this.equals(ACTIVE);
    }
    public boolean isInactive(){
        return this.equals(INACTIVE);
    }
    public static List<ActiveInactiveStatusEnum> findAll(){
        List<ActiveInactiveStatusEnum> list= new ArrayList<ActiveInactiveStatusEnum>();

        for(ActiveInactiveStatusEnum status: ActiveInactiveStatusEnum.values()){
            list.add(status);
        }

        return list;
    }

    public static ActiveInactiveStatusEnum findByCode(String value){
        ActiveInactiveStatusEnum[] array= ActiveInactiveStatusEnum.values();
        ActiveInactiveStatusEnum result=null;
        for (int i=0;i<array.length;i++){
            if(array[i].getCode().equals(value)){
                result=array[i];
                break;
            }
        }
        return result;
    }




    public static ActiveInactiveStatusEnum findByValue(String value){
        ActiveInactiveStatusEnum[] array= ActiveInactiveStatusEnum.values();
        ActiveInactiveStatusEnum result=null;
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
}
