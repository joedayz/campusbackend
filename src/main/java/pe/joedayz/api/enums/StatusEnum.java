package pe.joedayz.api.enums;


import java.util.ArrayList;
import java.util.List;

public enum StatusEnum {
    ACTIVE("A","Active"),
    LOCKED("L","Locked"),
    INACTIVE("I","Inactive")
    ;

    private String code;
    private String label;

    StatusEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static List<StatusEnum> findAll(){
        List<StatusEnum> list= new ArrayList<StatusEnum>();

        for(StatusEnum status: StatusEnum.values()){
            list.add(status);
        }

        return list;
    }

    public static StatusEnum findByCode(String value){
        StatusEnum[] array= StatusEnum.values();
        StatusEnum result=null;
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
