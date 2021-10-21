package com.example.f21comp1011gctest1student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String pw = "student";
    private static String connectUrl = "jdbc:mysql://localhost:3306/javaTest";
    public int count;

    public static ArrayList<NetflixShow> getNetflixShow()
    {
        ArrayList<NetflixShow> netflixShows = new ArrayList<>();

        String sql = "SELECT showId, type, title, rating, director, cast\n" +
                "FROM netflix";

        try(
                Connection conn = DriverManager.getConnection(connectUrl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while(resultSet.next())
            {
                String showId = resultSet.getString("showId");
                String type = resultSet.getString("type");
                String title = resultSet.getString("title");
                String rating = resultSet.getString("rating");
                String director = resultSet.getString("director");
                String cast = resultSet.getString("cast");

                NetflixShow netflixShow = new NetflixShow(showId, type, title, rating, director, cast);
                netflixShows.add(netflixShow);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return netflixShows;
    }
}
