package pe.joedayz.api.domain.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;



/**
 * The persistent class for the ZIP database table.
 * 
 */
@Entity
@NamedQuery(name="ResetRegistry.findAll", query="SELECT r FROM ResetRegistry r")
@Table(name="reset_registry")
public class ResetRegistry extends AuditingEntity implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reset_id")
	private long resetId;

	@Column(name="token")
	private String token;

	@Column(name="user_name")
	private String userName;

	@Column(name="status")
	private String status;



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getResetId() {
		return resetId;
	}

	public void setResetId(long resetId) {
		this.resetId = resetId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}