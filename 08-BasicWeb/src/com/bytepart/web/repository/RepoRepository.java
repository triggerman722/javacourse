package com.bytepart.web.repository;

import com.bytepart.web.models.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.bytepart.web.repository.BaseRepository.*;

public class RepoRepository {


    public void addRepo(Repository repo) throws SQLException, ClassNotFoundException {
        String query = "insert into repo (title, description) values ('"+repo.getName()+"', '"+repo.getDescription()+"')";
        Class.forName(DB_DRIVER);
        Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        connection.createStatement().execute(query);
        connection.close();
    }

    public Repository getRepo(int i) throws ClassNotFoundException, SQLException {
        String query = "select * from repo where thingid = " + i;
        Class.forName(DB_DRIVER);
        Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        ResultSet resultSet = connection.createStatement().executeQuery(query);

        Repository repository = new Repository();
        while (resultSet.next()) {
            repository.setName(resultSet.getString("title"));
            repository.setDescription(resultSet.getString("description"));
        }
        connection.close();
        return repository;
    }
}
