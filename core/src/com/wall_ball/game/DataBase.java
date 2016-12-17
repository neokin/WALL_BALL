package com.wall_ball.game;

import com.badlogic.gdx.Game;

/**
 * Created by kaliuser on 17.12.16.
 */



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.sql.DatabaseFactory;
import com.badlogic.gdx.sql.SQLiteGdxException;
import com.badlogic.gdx.sql.DatabaseCursor;

class DataBase extends Game {

    Database database;

    public static final String TABLE_COMMENTS = "total";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "score";

    private static final String DATABASE_NAME = "wallball.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table if not exists "
            + TABLE_COMMENTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null);";

    @Override
    public void create() {
        Gdx.app.log("Database WallBall", "creation started");

        database = DatabaseFactory.getNewDatabase(DATABASE_NAME,
                DATABASE_VERSION, DATABASE_CREATE, null);

        database.setupDatabase();
        try {
            database.openOrCreateDatabase();
            database.execSQL(DATABASE_CREATE);
        } catch (SQLiteGdxException e) {
            e.printStackTrace();
        }

        Gdx.app.log("Database WallBall", "created successfully");

    }

    public void close() {
        try {
            database.closeDatabase();
        } catch (SQLiteGdxException e) {
            e.printStackTrace();
        }
        database = null;
        Gdx.app.log("Database WallBall", "dispose");
    }

    public void insert(String score) {
        try {
            database.execSQL("INSERT INTO total ('score') VALUES ('" + score + "')");
        } catch (SQLiteGdxException e) {
            e.printStackTrace();
        }
    }

    public void read(Array<String> records) {
        DatabaseCursor cursor = null;

        try {
            cursor = database.rawQuery("SELECT * FROM total");
        } catch (SQLiteGdxException e) {
            e.printStackTrace();
        }
        while (cursor.next()) {
            records.add(String.valueOf(cursor.getString(1)));
            Gdx.app.log("From database WallBall ", String.valueOf(cursor.getString(1)));
        }
    }
}
