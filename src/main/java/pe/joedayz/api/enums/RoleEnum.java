package pe.joedayz.api.enums;


import java.util.ArrayList;
import java.util.List;

public enum RoleEnum {

    SYSTEM("ADMIN","systemAdministrator"),
    PRICING_ANALYST("PRIAN","pricingAnalyst"),
    SALES_ACCOUNT_MANAGER("SAACM","salesAccountManager"),
    PRICING_MANAGER("PRIMA","pricingManager"),
    BLOCKED_AT_OFFICE("BAOFF","blockedAtOffice"),
    ;

    private String code;
    private String label;

    RoleEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static List<RoleEnum> findAll(){
        List<RoleEnum> list= new ArrayList<RoleEnum>();

        for(RoleEnum status: RoleEnum.values()){
            list.add(status);
        }

        return list;
    }

    public static RoleEnum findByCode(String value){
        RoleEnum[] array= RoleEnum.values();
        RoleEnum result=null;
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
