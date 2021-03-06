package model;

import java.util.Date;

import model.common.AppModule;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Aug 27 13:05:12 IST 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }

    /**
     * Container's getter for EntityObjectVO1.
     * @return EntityObjectVO1
     */
    public ViewObjectImpl getEntityObjectVO1() {
        return (ViewObjectImpl)findViewObject("EntityObjectVO1");
    }
    
    
    public void createRow(String empEmail, String sal, Date from, Date to) {
        
        Number salary = Integer.parseInt(sal);
        ViewObject vo= findViewObject("EntityObjectVO1");
        Row row=vo.createRow();
        row.setAttribute("EmpEmail", empEmail);
        row.setAttribute("Salary", salary);
        row.setAttribute("FromDate", from);
        row.setAttribute("ToDate", to);
        vo.insertRow(row);
        getDBTransaction().commit();
        
    }
    
    public void updateRowby_EFFDT_UPDATE_MODE(String empEmail, String sal, Date effectiveDate) {
        
        ViewObject vo= findViewObject("EntityObjectVO1");
        setProperty(ApplicationModule.EFF_DT_PROPERTY_STR, effectiveDate);
        vo.setWhereClause("EMP_EMAIL='"+empEmail+"'");
        vo.executeQuery();
        Row row=vo.next();
        row.setEffectiveDateMode(Row.EFFDT_UPDATE_MODE);
        row.setAttribute("Salary", sal);
        getDBTransaction().commit();
        
    }
    
    public void updateRowby_EFFDT_UPDATE_CORRECTION(String empEmail, String sal, Date effectiveDate) {
        
        ViewObject vo= findViewObject("EntityObjectVO1");
        setProperty(ApplicationModule.EFF_DT_PROPERTY_STR, effectiveDate);
        vo.setWhereClause("EMP_EMAIL='"+empEmail+"'");
        vo.executeQuery();
        Row row=vo.next();
        row.setEffectiveDateMode(Row.EFFDT_UPDATE_CORRECTION);
        row.setAttribute("Salary", sal);
        getDBTransaction().commit();
        
    }
    
    public void deleteRow(String empEmail, Date from, Date to) {
        
        ViewObject vo= findViewObject("EntityObjectVO1");
        Key key = new Key(new Object[]{empEmail,from,to});
                                                         
        setProperty(ApplicationModule.EFF_DT_PROPERTY_STR, from);
        vo.setWhereClause("EMP_EMAIL='"+empEmail+"'");
        vo.executeQuery();
        Row row=vo.first();
        row.remove();
        getDBTransaction().commit();
        
    }
}

