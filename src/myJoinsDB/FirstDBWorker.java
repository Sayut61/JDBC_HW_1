package myJoinsDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FirstDBWorker {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/MyJoinsDB?serverTimezone=UTC";
    private final String LOGIN = "sayut61";
    private final String PASSWORD = "Root1993";

    public FirstDBWorker(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver loading");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<FirstRequest> getFirstRequest() {
        Connection connection = null;
        Statement statement = null;
        List<FirstRequest> firstRequests = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT place, phone FROM nameNum INNER JOIN family on family.idNM = namenum.idNM");

            String place;
            String phone;
            while (resultSet.next()) {

                place = resultSet.getString("place");
                phone = resultSet.getString("phone");
                firstRequests.add(new FirstRequest(place, phone));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return firstRequests;
    }
}
