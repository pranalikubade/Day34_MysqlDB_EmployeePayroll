package connections;

import java.sql.*;

public class PayrollServicesJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");
        final String url = "jdbc:mysql://localhost:3306/payroll_service";
        final String userName = "root";
        final String password = "Panu@9146";
        Connection connection = DriverManager.getConnection(url,userName,password);
        Statement statement = connection.createStatement();

        //total and average Salary of female
        String queryOne = "select avg(Salary) as Average_pay, sum(Salary) as Total_pay from employee_payroll where Gender = 'F' group by Gender; ";

        ResultSet resultSetOne = statement.executeQuery(queryOne);
        while(resultSetOne.next()) {
            int Average_pay = resultSetOne.getInt("Average_pay");
            int Total_pay = resultSetOne.getInt("Total_pay");
            System.out.println(" Females :: ");
            System.out.println("Average_pay :: " + Average_pay + '\n'+
                    " Total_pay :: " + Total_pay);
        }

        //total and average Salary of males
        String queryTwo = "select avg(Salary) as Average_pay, sum(Salary) as Total_pay from employee_payroll where Gender = 'M' group by Gender; ";

        ResultSet resultSetTwo = statement.executeQuery(queryTwo);
        while(resultSetTwo.next()) {
            int Average_pay = resultSetTwo.getInt("Average_pay");
            int Total_pay = resultSetTwo.getInt("Total_pay");
            System.out.println('\n'+" Males :: ");
            System.out.println("Average_pay :: " + Average_pay + '\n'+
                    " Total_pay :: " + Total_pay);
        }

        //minimum
        String queryThree = "select * from employee_payroll where Salary = (select min(Salary) as minimum_pay from employee_payroll); ";

        ResultSet resultSetThree = statement.executeQuery(queryThree);
        while(resultSetThree.next()) {
            //int employeeID = resultSet.getInt("EmployeeID");
            String employeeName = resultSetThree.getString("EmployeeName");
            int Salary = resultSetThree.getInt("Salary");
            String startDate = resultSetThree.getString("StartDate");
            String city = resultSetThree.getString("City");
            String country = resultSetThree.getString("Country");
            String address = resultSetThree.getString("Address");
            String department = resultSetThree.getString("Department");
            int basicPay = resultSetThree.getInt("BasicPay");
            int deductions = resultSetThree.getInt("Deductions");
            int taxAblePay = resultSetThree.getInt("TaxablePay");
            int tax = resultSetThree.getInt("Tax");

            System.out.println('\n'+" Minimum salary :: ");
            System.out.println("employeeID=" + ", employeeName=" + employeeName
                    + ", Salary=" + Salary + ", startDate=" + startDate + ", city=" + city + ", country=" + country
                    + ", address=" + address + ", department=" + department + ", basicPay="
                    + basicPay + ", deductions=" + deductions + ", taxAblePay=" + taxAblePay + ", tax=" + tax);

        }

        //maximum
        String queryFour = "select * from employee_payroll where NetPay = (select max(Salary) as minimum_pay from employee_payroll);";

        ResultSet resultSetFour = statement.executeQuery(queryFour);
        while(resultSetFour.next()) {
            String employeeName = resultSetFour.getString("EmployeeName");
            int Salary = resultSetFour.getInt("Salary");
            String startDate = resultSetFour.getString("StartDate");
            String city = resultSetFour.getString("City");
            String country = resultSetFour.getString("Country");
            String address = resultSetFour.getString("Address");
            String department = resultSetFour.getString("Department");
            int basicPay = resultSetFour.getInt("BasicPay");
            int deductions = resultSetFour.getInt("Deductions");
            int taxAblePay = resultSetFour.getInt("TaxablePay");
            int tax = resultSetFour.getInt("Tax");

            System.out.println('\n'+" Maximum salary :: ");
            System.out.println("employeeID=" + ", employeeName=" + employeeName
                    + ",Salary=" + Salary + ", startDate=" + startDate + ", city=" + city + ", country=" + country
                    + ", address=" + address + ", department=" + department + ", basicPay="
                    + basicPay + ", deductions=" + deductions + ", taxAblePay=" + taxAblePay + ", tax=" + tax);

        }

        //count
        String queryFive = "select count(EmployeeID) as Total_Employees from employee_payroll; ";

        ResultSet resultSetFive = statement.executeQuery(queryFive);
        while(resultSetFive.next()) {
            int Total_Employees = resultSetFive.getInt("Total_Employees");
            System.out.println('\n' + " Count Of Total Employees");
            System.out.println(" Total_Employees :: " + Total_Employees);
        }


        statement.close();
        connection.close();


    }

}
