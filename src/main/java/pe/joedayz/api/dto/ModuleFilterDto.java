package pe.joedayz.api.dto;

/**
 * Created by josediaz on 17/08/2016.
 */
public class ModuleFilterDto extends PageableFilter {

	private String code;
	private String name;
	private String parentName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


}
