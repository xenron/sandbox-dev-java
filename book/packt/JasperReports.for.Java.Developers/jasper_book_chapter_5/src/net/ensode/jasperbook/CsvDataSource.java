package net.ensode.jasperbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import au.com.bytecode.opencsv.CSVReader;

public class CsvDataSource implements JRRewindableDataSource
{
  private CSVReader csvReader;
  private List rows;
  private int currentRowIndex = -1;
  private int currentColIndex = 0;
  private int totalRows;

  public CsvDataSource(Reader reader)
  {
    try
    {
      csvReader = new CSVReader(reader);
      rows = csvReader.readAll();
      totalRows = rows.size();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public boolean next() throws JRException
  {
    boolean retVal = true;

    currentRowIndex++;
    currentColIndex = 0;

    if (currentRowIndex >= totalRows)
    {
      retVal = false;
    }

    return retVal;
  }

  public Object getFieldValue(JRField arg0) throws JRException
  {
    String value = null;
    String[] currentRow = (String[]) rows.get(currentRowIndex);

    value = currentRow[currentColIndex];
    currentColIndex++;

    return value;
  }

  public void moveFirst() throws JRException
  {
    currentRowIndex = 0;
    currentColIndex = 0;
  }
}
