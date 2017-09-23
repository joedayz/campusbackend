package pe.joedayz.api.enums;

import java.util.ArrayList;
import java.util.List;


public enum GeneralTableStatusEnum {

    ACTIVE("A","Active"),
    INACTIVE("I","Inactive")
    ;

    private String code;
    private String label;

    GeneralTableStatusEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static List<GeneralTableStatusEnum> findAll(){
        List<GeneralTableStatusEnum> list= new ArrayList<GeneralTableStatusEnum>();

        for(GeneralTableStatusEnum status: GeneralTableStatusEnum.values()){
            list.add(status);
        }

        return list;
    }

    public static GeneralTableStatusEnum findByCode(String value){
        GeneralTableStatusEnum[] array= GeneralTableStatusEnum.values();
        GeneralTableStatusEnum result=null;
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
