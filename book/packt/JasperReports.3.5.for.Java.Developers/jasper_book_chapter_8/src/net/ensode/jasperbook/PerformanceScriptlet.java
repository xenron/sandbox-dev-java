package net.ensode.jasperbook;

import net.sf.jasperreports.engine.JRAbstractScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class PerformanceScriptlet extends JRAbstractScriptlet {

    private long reportInitStartTime;
    private long reportInitEndTime;
    private long pageInitStartTime;
    private long pageInitEndTime;
    private long columnInitStartTime;
    private long columnInitEndTime;
    private long groupInitStartTime;
    private long groupInitEndTime;
    private long detailEvalStartTime;
    private long detailEvalEndTime;

    public void beforeReportInit() throws JRScriptletException {
        reportInitStartTime = System.currentTimeMillis();

    }

    public void afterReportInit() throws JRScriptletException {
        reportInitEndTime = System.currentTimeMillis();

        System.out.println("Report initialization took " + (reportInitEndTime - reportInitStartTime) + " milliseconds.");
    }

    public void beforePageInit() throws JRScriptletException {
        pageInitStartTime = System.currentTimeMillis();

    }

    public void afterPageInit() throws JRScriptletException {
        pageInitEndTime = System.currentTimeMillis();
        Integer pageNum = (Integer) getVariableValue("PAGE_NUMBER");

        System.out.println("Page " + pageNum + " initialization took " + (pageInitEndTime - pageInitStartTime) + " milliseconds.");
    }

    public void beforeColumnInit() throws JRScriptletException {
        columnInitStartTime = System.currentTimeMillis();

    }

    public void afterColumnInit() throws JRScriptletException {
        columnInitEndTime = System.currentTimeMillis();
        Integer columnNum = (Integer) getVariableValue("COLUMN_NUMBER");

        System.out.println("Column " + columnNum + " initialization took " + (columnInitEndTime - columnInitStartTime) + " milliseconds.");

    }

    public void beforeGroupInit(String groupName) throws JRScriptletException {
        groupInitStartTime = System.currentTimeMillis();
    }

    public void afterGroupInit(String groupName) throws JRScriptletException {
        groupInitEndTime = System.currentTimeMillis();

        System.out.println("Group " + groupName + " initialization took " + (groupInitEndTime - groupInitStartTime) + " milliseconds.");
    }

    public void beforeDetailEval() throws JRScriptletException {
        detailEvalStartTime = System.currentTimeMillis();
    }

    public void afterDetailEval() throws JRScriptletException {
        detailEvalEndTime = System.currentTimeMillis();

        System.out.println("Detail evaluation took " + (detailEvalEndTime - detailEvalStartTime) + " milliseconds.");
    }
}
