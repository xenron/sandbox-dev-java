package net.ensode.jasperbook;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class ReportVariableModificationScriptlet extends JRDefaultScriptlet {

    @Override
    public void afterReportInit() throws JRScriptletException {
        setVariableValue("someVar", new String(
                "This value was modified by the scriptlet."));
    }
}