package pe.joedayz.api.domain.model.entities;






import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.enums.GeneralTableStatusEnum;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the GENERAL_TABLE database table.
 * 
 */
@Entity
@Table(name="general_table")
@NamedQuery(name="GeneralTable.findAll", query="SELECT g FROM GeneralTable g")
public class GeneralTable extends AuditingEntity implements Serializable, BaseEntity{
	private static final long serialVersionUID = 1L;

	@Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="general_table_id")
	private long generalTableId;

	private String code;

	@Column(name="sort_order")
	private BigDecimal sortOrder;


	@Column(name="status")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType",
			parameters = {@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.GeneralTableStatusEnum")})
	private GeneralTableStatusEnum status;



	@Column(name="table_name")
	private String tableName;

	@Column(name="\"value\"")
	private String value;




	public GeneralTable() {
	}

	public long getGeneralTableId() {
		return this.generalTableId;
	}

	public void setGeneralTableId(long generalTableId) {
		this.generalTableId = generalTableId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(BigDecimal sortOrder) {
		this.sortOrder = sortOrder;
	}

	public GeneralTableStatusEnum getStatus() {
		return status;
	}

	public void setStatus(GeneralTableStatusEnum status) {
		this.status = status;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}