package pe.joedayz.api.domain.model.base;

import pe.joedayz.api.enums.ActiveInactiveStatusEnum;

public interface ActiveInactiveEntity {
	ActiveInactiveStatusEnum getStatus();

	void setStatus(ActiveInactiveStatusEnum status);

}
