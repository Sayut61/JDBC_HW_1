package myJoinsDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThirdDBWorker {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/MyJoinsDB?serverTimezone=UTC";
    private final String LOGIN = "sayut61";
    private final String PASSWORD = "Root1993";

    public ThirdDBWorker(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver loading");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<ThirdRequest> getThirdRequest(){
        Connection connection = null;
        Statement statement = null;
        List<ThirdRequest> thirdRequests = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT birthday, phone FROM family LEFT OUTER JOIN namenum ON family.idNM = namenum.idNM LEFT OUTER JOIN salary ON family.idNM = salary.idNM WHERE position = 'Manager'");

            String birthday;
            String phone;
            while (resultSet.next()){
                birthday = resultSet.getString("birthday");
                phone = resultSet.getString("phone");
                thirdRequests.add(new ThirdRequest(birthday, phone));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return thirdRequests;
    }
}
