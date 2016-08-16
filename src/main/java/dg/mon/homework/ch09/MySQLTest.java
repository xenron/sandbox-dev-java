package dg.mon.hw.ch09;

import java.sql.*;

public class MySQLTest
{
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "python";
        String userName = "root";
        String passwrod = "xuran123456";
        String url = "jdbc:mysql://192.168.101.81:3306/" + dbName;
        String tableName = "person";
        search(driver, userName, passwrod, url, tableName);
    }

    private static void search(String driver, String userName, String passwrod, String url, String tableName) {
        String sql = "select * from " + tableName;

        System.out.println("Table name is : " + tableName);

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userName, passwrod);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                StringBuffer buffer = new StringBuffer();
                for ( int i=1;i<=rsmd.getColumnCount();i++){
                    String colName = rsmd.getColumnName(i);
                    String value = rs.getString(i);
                    buffer.append(colName).append(" : ").append(value).append(" ; ");
                }
                System.out.println(buffer.toString());
            }

            // 关闭记录集
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // 关闭声明
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // 关闭链接对象
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
