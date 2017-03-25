package pe.joedayz.api.support;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class ExtendedBeanPropertyRowMapper<T> extends BeanPropertyRowMapper<T> {
    //Contains valid true values
    //private static final Set<String> TRUE_SET = new HashSet<String>(Arrays.asList("y", "yes", "true"));
    private Class<T> mappedClass;

    public ExtendedBeanPropertyRowMapper(Class<T> class1) {
        super(class1);
        mappedClass=class1;
    }

    @Override
    public T mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Assert.state(this.mappedClass != null, "Mapped class was not specified");
        T mappedObject = BeanUtils.instantiate(this.mappedClass);
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(mappedObject);
        initBeanWrapper(bw);

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        Set<String> populatedProperties = (isCheckFullyPopulated() ? new HashSet<String>() : null);

        for (int index = 1; index <= columnCount; index++) {
            String column = JdbcUtils.lookupColumnName(rsmd, index);
            //String field = lowerCaseName(column.replaceAll(" ", ""));

            if ( !bw.isWritableProperty(column))
                continue;
            bw.setPropertyValue(column, rs.getObject(index));

        }



        return mappedObject;
    }
}
