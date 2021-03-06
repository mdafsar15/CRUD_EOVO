package model.common;

import java.util.Date;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Aug 27 13:06:24 IST 2020
// ---------------------------------------------------------------------
public interface AppModule extends ApplicationModule {
    void createRow(String empEmail, String sal, Date from, Date to);

    void updateRowby_EFFDT_UPDATE_MODE(String empEmail, String sal,
                                       Date effectiveDate);

    void updateRowby_EFFDT_UPDATE_CORRECTION(String empEmail, String sal,
                                             Date effectiveDate);

    void deleteRow(String empEmail, Date from, Date to);
}
