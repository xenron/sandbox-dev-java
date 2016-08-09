<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Generate Report</title>
</head>
<body>
<p>Click on the button to generate the report.</p>
<html:form action="/generate_report">
	<html:submit />
</html:form>
</body>
</html>
