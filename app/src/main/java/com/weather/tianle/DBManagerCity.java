package com.weather.tianle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import com.weather.tianle.R;


public class DBManagerCity {

    private final int BUFFER_SIZE = 400000;
    public static final String DB_NAME = "city.db"; //保存的数据库文件名
    public static final String PACKAGE_NAME = "com.weather.tianle/databases/";
    public static final String DB_PATH = Environment.getDataDirectory().getAbsolutePath() + "/data/"
            + PACKAGE_NAME;  //在手机里存放数据库的位置(/data/data/com.cssystem.activity/cssystem.db)

    private SQLiteDatabase database;

    private Context context;

    public DBManagerCity(Context context) {
        this.context = context;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }

    public void openDatabase() {
        //System.out.println(DB_PATH + "/" + DB_NAME);

        this.database = this.openDatabase(DB_PATH + DB_NAME);
    }

    private SQLiteDatabase openDatabase(String dbfile) {

        try {
            if (!(new File(dbfile).exists())) {
                //判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
                InputStream is = this.context.getResources().openRawResource(
                        R.raw.city); //欲导入的数据库
                FileOutputStream fos = new FileOutputStream(dbfile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile,null);
            return db;
        } catch (FileNotFoundException e) {
            Log.e("Database", "File not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Database", "IO exception");
            e.printStackTrace();
        }
        return null;
    }
    public void closeDatabase() {
        this.database.close();
    }


}