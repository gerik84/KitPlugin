package com.controllers;

import com.models.User;
import com.tools.Tools;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

/**
 * Created by pavel on 19.01.17.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        Tools.init(this);

        new User(Tools.getInstance().getDBConnection()).insert(UUID.randomUUID(), 1);

//
//        getLogger().info("Start KIT plugin");
//
//        File db_source = new File(getDataFolder() + "/db_source.db");
//        if (!db_source.isFile()) {
//            saveConfig();
//        }
//
//        Db db = new Db(db_source.getAbsolutePath());
//        Connection con = db.open();
//        getLogger().info(db.checkConnection() ? "connect" : "failed");
//        try {
//            Statement stmt = con.createStatement();
//            //   CREATE TABLE `users` ( `uuid` VARCHAR(128) NOT NULL , `status` INT NOT NULL , PRIMARY KEY (`uuid`))
//            String sql = "CREATE TABLE `users` ( `uuid` VARCHAR(128) NOT NULL , `status` INT NOT NULL , PRIMARY KEY (`uuid`))";
//            stmt.executeUpdate(sql);
//            stmt.close();
////            stmt.execute("");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        db.closeConnection(con);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

