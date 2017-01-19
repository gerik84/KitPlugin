package com.models;

import com.tools.DBConnection;
import com.tools.Tools;

import javax.tools.Tool;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * Created by pavel on 19.01.17.
 */

public class User extends BaseModel {

    public UUID uuid;
    public String status;

    public User(DBConnection connection) {
        super(connection);
    }

    @Override
    protected String createTable() {
        return "CREATE TABLE IF NOT EXISTS `users` ( `uuid` VARCHAR(128) NOT NULL , `status` INT NOT NULL , PRIMARY KEY (`uuid`))";
    }

    public Boolean insert(UUID uuid, int status) {
        int insert = 0;
        try {

            String sql = "INSERT INTO users(uuid, status) VALUES (?,?)";
            PreparedStatement preparedStatement = mDatabase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setInt(2, status);
            insert = preparedStatement.executeUpdate();
            Tools.Log().info("Record is inserted into users table!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return insert > 0;
    }

}
