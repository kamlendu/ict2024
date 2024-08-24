/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author root
 */
public class Employee implements Serializable {
    
    int empno;
    String ename;
    double salary;
    HashMap errors;

    public Employee() {
        
        this.empno = 0;
        this.ename="";
        this.salary=0.0;
        errors = new HashMap();
    }

    public boolean validate()
    {
        boolean allOK = true;
        
        if(empno==0)
        {
            errors.put("empno", "Employee No can not be zero");
            allOK=false;
            empno=0;
        }
        if(ename.equals(""))
        {
            errors.put("ename", "Employee Name can not be blank");
            allOK=false;
            ename="";
        }
         if(salary==0.0)
        {
            errors.put("salary", "Employee salary can not be zero");
            allOK=false;
            salary=0.0;
        }
    
    return allOK;
    }
    
    public String getError(String s)
    {
        String error = (String) errors.get(s.trim());
        
        return (error==null)? "":error;
    }
   
    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "empno=" + empno + ", ename=" + ename + ", salary=" + salary + ", errors=" + errors + '}';
    }
    
    
    
    
    
    
}
