package pe.joedayz.api.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.service.intf.DateTimeRetriever;
import pe.joedayz.api.support.LogContext;


@Component
public class ApiEntityInterceptorImpl extends EmptyInterceptor implements ApiEntityInterceptor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
    DateTimeRetriever dateTimeRetriever;

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof BaseEntity) {

            for (int i = 0; i < propertyNames.length; i++) {
                String propertyName = propertyNames[i];

                if (propertyName.equals("createdBy")) {
                    state[i] = LogContext.getUserIdSafe();
                } else if (propertyName.equals("createdDate")) {
                    state[i] = currentTime();
                }
            }

        }
        return true; //super.onSave(entity, id, state, propertyNames, types);
    }

    private Date currentTime() {
        if (dateTimeRetriever == null) return new Timestamp(System.currentTimeMillis());
        Date date = dateTimeRetriever.currentTime();
        return date;
    }


    @Override
    public boolean onFlushDirty(
            Object entity,
            Serializable id,
            Object[] currentState,
            Object[] previousState,
            String[] propertyNames,
            Type[] types) {
        if (entity instanceof BaseEntity) {

            for (int i = 0; i < propertyNames.length; i++) {
                String propertyName = propertyNames[i];

                if (propertyName.equals("updatedBy")) {
                    currentState[i] = LogContext.getUserIdSafe();
                } else if (propertyName.equals("updatedDate")) {
                    currentState[i] = currentTime();
                }
            }

        }


        return true;
    }
}