package pe.joedayz.api.enums;

import java.util.ArrayList;
import java.util.List;

public enum TipoCursoEnum {
    PRESENCIAL("P","PRESENCIAL"),
    ONLINE("O","ONLINE"),
    VIDEO_CURSO("V", "VIDEO_CURSO");
    
    private String code;
    private String label;

    TipoCursoEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }
    public boolean isPresencial() {
        return this.equals(PRESENCIAL);
    }

    public boolean isOnline() {
        return this.equals(ONLINE);
    }
    
    public boolean isVideoCurso(){
    	return this.equals(VIDEO_CURSO);
    }
    
    public static List<TipoCursoEnum> findAll(){
        List<TipoCursoEnum> list= new ArrayList<TipoCursoEnum>();

        for(TipoCursoEnum status: TipoCursoEnum.values()){
            list.add(status);
        }

        return list;
    }

    public static TipoCursoEnum findByCode(String value){
    	TipoCursoEnum[] array= TipoCursoEnum.values();
    	TipoCursoEnum result=null;
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
