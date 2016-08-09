/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ensode.jasperbook;

import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import org.apache.commons.lang.ArrayUtils;

public class ListOfArraysDataSource implements JRRewindableDataSource {

    private List<String[]> listOfArrays;
    private String[] fieldNames;
    private int index = -1;

    public ListOfArraysDataSource(List<String[]> listOfArrays) {
        this.listOfArrays = listOfArrays;
    }

    public void moveFirst() throws JRException {
        index = 0;
    }

    public boolean next() throws JRException {
        index++;
        boolean returnVal = true;

        if (index >= listOfArrays.size()) {
            returnVal = false;
        }

        return returnVal;
    }

    public Object getFieldValue(JRField jrField) throws JRException {

        int fieldIndex = ArrayUtils.indexOf(fieldNames, jrField.getName());

        if (fieldIndex == ArrayUtils.INDEX_NOT_FOUND) {
            throw new JRException("Invalid field: " + jrField.getName());
        }

        return listOfArrays.get(index)[fieldIndex];
    }

    public void setListOfArrays(List<String[]> listOfArrays) {
        this.listOfArrays = listOfArrays;
    }

    public void setFieldNames(String[] fieldNames) {
        this.fieldNames = fieldNames;
    }
}
