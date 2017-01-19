package com.models;

import com.tools.DBConnection;

import java.sql.SQLException;

/**
 * Created by pavel on 19.01.17.
 */

abstract class BaseModel {

    protected abstract String createTable();


    DBConnection mDatabase;

    BaseModel(DBConnection connection) {
        mDatabase = connection;
        try {
            mDatabase.getConnection().createStatement().executeUpdate(createTable());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
