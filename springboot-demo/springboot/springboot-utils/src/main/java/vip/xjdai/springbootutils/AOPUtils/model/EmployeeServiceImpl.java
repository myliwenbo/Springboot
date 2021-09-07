package vip.xjdai.springbootutils.AOPUtils.model;


public class EmployeeServiceImpl implements IEmployeeService {

    @Override
    public void someLogic() {
        System.out.println("do something");
    }

}