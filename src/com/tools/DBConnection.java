package com.tools;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.Connection;

/**
 * Created by pavel on 19.01.17.
 */
public class DBConnection<T extends JavaPlugin> {

    static DBConnection sInstance;
    T mContext;
    Db mDb;

    public static  <T extends JavaPlugin> DBConnection init (T context) {
        if (sInstance != null)
            throw new RuntimeException("Error init database connection");
        return sInstance = new DBConnection(context);
    }

    private DBConnection(T context) {

        File db_source = new File(context.getDataFolder() + "/db_source.db");
        if (!db_source.isFile()) {
            context.saveConfig();
        }

        mDb = new Db(db_source.getAbsolutePath());
        mDb.open();
        context.getLogger().info(mDb.checkConnection() ? "Database connect success" : "Database connect success failed");
    }

    public static DBConnection getInstance() {
        if (sInstance == null)
            throw new NullPointerException("Before need called init method");
        return sInstance;
    }

    public Connection getConnection() {
        return mDb.getConn();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        mDb.closeConnection(mDb.getConn());
    }
}
