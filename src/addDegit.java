/*
public class addDegit {
}


    super_digit(9875) = super_digit(9+8+7+5)
        = super_digit(29)
        = super_digit(2+9)
        = super_digit(11)
        = super_digit(1+1)
        = super_digit(2)
        = 2.

        Public int getSuperDigit(Integer n){//12
        if(n<=9)
        Return n;

        Int sum=0;
        while(n>0){//12
        sum+= n%10;//3
        n/=10;//0
        }
        Return getSuperDigit(sum);
        }
@test
Public void testSuperDigit(){
        AssertEquals(“”, 2, 2);
        AssertEquals(“ ”, 3, 12);
        AssertEquals(“ ”, 2, 9875);

        }
// DB

        Employee Table
        id     name     department

        Salary Table
        Id    emp_id  salary

        1) Top 5 salaries of all
        2) Top 5 salaries in each department



        Select s.Emp_id, e.department, e.salary from Salary  order by salary s join Employee e on s.id==e.emp_id desc where


        1. This is something I was thinking about,
        select * from employee EMP, Salary sal where EMP.id=sal.emp_id
        and sal.salary in
        (select salary from employee e, Salary s where s.emp_id=e.id and e.department = EMP.department order by salary limit 5)
        order by department;

        But it will not work on mysql, So looking for other option…

        2.  <Works on MSSQL>
        SELECT * FROM(
        SELECT DISTINCT DEPARTMENT, salary,row_number() OVER (PARTITION BY DEPARTMENT ORDER BY salary DESC) row_no
        FROM employee e
        join salary s on e.id=s.id
        ) where row_no<=5
        order by department




















*/
