package myJoinsDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SecondDBWorker {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/MyJoinsDB?serverTimezone=UTC";
    private final String LOGIN = "sayut61";
    private final String PASSWORD = "Root1993";

    public SecondDBWorker(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver loading");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<SecondRequest> getSecondRequest(){
        Connection connection = null;
        Statement statement = null;
        List<SecondRequest> secondRequests = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT birthday, phone FROM family LEFT OUTER JOIN namenum ON family.idNM = namenum.idNM WHERE maritalStat = 'unmarried'");

            String birthday;
            String phone;
            while (resultSet.next()){
                birthday = resultSet.getString("birthday");
                phone = resultSet.getString("phone");
                secondRequests.add(new SecondRequest(birthday, phone));
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
        return secondRequests;
    }
}
