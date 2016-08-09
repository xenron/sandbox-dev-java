<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.io.*, java.util.*, java.sql.Connection,javax.sql.DataSource, javax.naming.InitialContext, 
net.sf.jasperreports.engine.*, net.sf.jasperreports.engine.design.JasperDesign,net.sf.jasperreports.engine.xml.JRXmlLoader,
net.sf.jasperreports.engine.export.*" 
%>
<%

  InputStream input=new FileInputStream(new File("C:/jasperreports/catalog.xml"));
  JasperDesign design = JRXmlLoader.load(input);
  
  JasperReport report = JasperCompileManager.compileReport(design);
  Map parameters = new HashMap();
  parameters.put("ReportTitle", "Excel JasperReport");

    InitialContext initialContext = new InitialContext();
    DataSource ds = (DataSource)initialContext.lookup("jdbc/OracleDS");
    Connection conn = ds.getConnection();
    
    
    JasperPrint print = JasperFillManager.fillReport(report, 
     parameters, conn);
         OutputStream ouputStream=new FileOutputStream(new File("C:/jasperreports/catalog.xls"));
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

   
         JRXlsExporter exporterXLS = new JRXlsExporter();
         exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
         exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
         
         exporterXLS.exportReport();
         ouputStream.write(byteArrayOutputStream.toByteArray()); 
         ouputStream.flush();
         ouputStream.close();
         out.println("Excel Report generated");
%>


