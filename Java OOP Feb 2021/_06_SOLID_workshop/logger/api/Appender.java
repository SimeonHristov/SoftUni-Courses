package _06_SOLID_WORKSHOP.logger.api;


import _06_SOLID_WORKSHOP.logger.enums.ReportLevel;

public interface Appender {
    void appendMessage(String datetime, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);
}