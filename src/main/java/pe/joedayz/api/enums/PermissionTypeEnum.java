package pe.joedayz.api.enums;

import java.util.ArrayList;
import java.util.List;


public enum PermissionTypeEnum {
    NONE_NO_ACCESS("N","None (No Access)"),
    READ_ONLY("R","Read Only"),
    EDIT_WRITE_ACCESS("W","Edit (Write access)"),
    EDIT_SAME_OFFICE_ONLY("O","Edit (Same office only)"),
    READ_SAME_OFFICE_ONLY("V","Read (Same office only)")
    ;

    private String code;
    private String label;

    PermissionTypeEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static List<PermissionTypeEnum> findAll(){
        List<PermissionTypeEnum> list= new ArrayList<PermissionTypeEnum>();

        for(PermissionTypeEnum status: PermissionTypeEnum.values()){
            list.add(status);
        }

        return list;
    }

    public static PermissionTypeEnum findByCode(String value){
        PermissionTypeEnum[] array= PermissionTypeEnum.values();
        PermissionTypeEnum result=null;
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
