package pe.joedayz.api.enums;

import java.util.ArrayList;
import java.util.List;


public enum UserStatusEnum {
    ACTIVE("A","Active"),
    LOCKED("L","Locked"),
    INACTIVE("I","Inactive")
    ;

    private String code;
    private String label;

    UserStatusEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }
    public boolean isActive() {
        return this.equals(ACTIVE);
    }

    public static List<UserStatusEnum> findAll(){
        List<UserStatusEnum> list= new ArrayList<UserStatusEnum>();

        for(UserStatusEnum status: UserStatusEnum.values()){
            list.add(status);
        }

        return list;
    }

    public static UserStatusEnum findByCode(String value){
        UserStatusEnum[] array= UserStatusEnum.values();
        UserStatusEnum result=null;
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
