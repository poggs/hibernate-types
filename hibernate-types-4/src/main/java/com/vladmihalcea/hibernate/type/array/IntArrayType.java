package com.vladmihalcea.hibernate.type.array;

import com.vladmihalcea.hibernate.type.array.internal.ArraySqlTypeDescriptor;
import com.vladmihalcea.hibernate.type.array.internal.IntArrayTypeDescriptor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * Maps an int[] array on a PostgreSQL ARRAY type.
 *
 *  @see <a href="https://vladmihalcea.com/2017/06/21/how-to-map-java-and-sql-arrays-with-jpa-and-hibernate/">this article</a> for more info.
 *
 * @author Vlad Mihalcea
 */
public class IntArrayType
        extends AbstractSingleColumnStandardBasicType<int[]>
        implements DynamicParameterizedType {

    public IntArrayType() {
        super(ArraySqlTypeDescriptor.INSTANCE, IntArrayTypeDescriptor.INSTANCE);
    }

    public String getName() {
        return "int-array";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((IntArrayTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}