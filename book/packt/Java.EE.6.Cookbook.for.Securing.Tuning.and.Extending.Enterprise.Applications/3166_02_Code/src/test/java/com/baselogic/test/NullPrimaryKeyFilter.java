package com.baselogic.test;

import org.dbunit.dataset.Column;
import org.dbunit.dataset.filter.IColumnFilter;

/**
 * [Title]
 *
 * @author Mick Knutson (<a href="http://www.baselogic.com">http://www.baselogic.com</a>)
 * @since 2011
 */
public class NullPrimaryKeyFilter implements IColumnFilter {
    private String[] keys = null;

    public NullPrimaryKeyFilter(String... keys) {
        this.keys = keys;
    }

    public boolean accept(String tableName, Column column) {
        for(String key: keys){
            if(column.getColumnName().equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }
}
