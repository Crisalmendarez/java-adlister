package com.codeup.adlister.dao;

import com.mysql.cj.jdbc.Driver;
import org.apache.taglibs.standard.tlv.JstlSqlTLV;

import java.sql.*;

public class PreparedStatements {

    public static void main(String[] args) {
        Config config = new Config();
//        try {
//            DriverManager.registerDriver(new Driver());
//            Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
//
//            String  sql = "SELECT * FROM albums WHERE artist = ?";
//
//            PreparedStatement stmt = connection.prepareStatement(sql);
//
//            stmt.setString(1, "Guns N' Roses");
//
//            ResultSet rs = stmt.executeQuery();
//
//            rs.next();
//            System.out.println("Album name: " + rs.getString("name"));
//            System.out.println("Album artist: " + rs.getString("artist"));
//
//        } catch(SQLException e) {
//            throw new RuntimeException("Sorry, could not connect to database!");
//        }

        try {
            // NEW DATABASE CONNECTION
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            // CREATE SQL STRING TO MAKE QUERY
            String insertSql = "INSERT INTO albums (artist, name, release_date, sales, genre) VALUES (?, ?, ?, ?, ?)";
            //INSTANTIATE PREPARED STATEMENT AND PASS SQL TO BE USED
            PreparedStatement stmt = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            // SET THE VALUE OF THE ?.
            stmt.setString(1, "Lil' Wayne");
            stmt.setString(2, "Tha Carter III");
            stmt.setInt(3, 2008);
            stmt.setDouble(4, 3.97);
            stmt.setString(5, "Rap");
            //EXECUTE PREPARED STATEMENT
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            //MOVE TO FIRST RESULT
            rs.next();
            //Print new ID
            System.out.println(rs.getLong(1));

        } catch(SQLException e){
            throw new RuntimeException("Sorry, error creating new album.");
        }
    }
}
