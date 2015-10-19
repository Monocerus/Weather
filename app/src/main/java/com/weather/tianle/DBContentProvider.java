package com.weather.tianle;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DBContentProvider extends ContentProvider {
    public DBContentProvider() {
    }
    private DBWeatherHelper dbOpenHelper;
    private static final UriMatcher MATCHER=new UriMatcher(UriMatcher.NO_MATCH);
    private static final int WEATHERS=1;
    private static final int WEATHER=2;
    private static final String  AUTHORITY= "com.tianle.weath.dbweather";
    static{
        MATCHER.addURI(AUTHORITY, "weathers", WEATHERS);
//        MATCHER.addURI(AUTHORITY, "weather/#", WEATHER);
    }
    //往ContentProvider（数据库）删除数据
    @Override
    public int delete(Uri uri, String  selection, String[] selectionArgs) {
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        int count=0;
        switch(MATCHER.match(uri)){
            case WEATHERS:
                count=db.delete("tb_week_weather", selection, selectionArgs);
                return count;
//            case WEATHER:
//                long id= ContentUris.parseId(uri);
//                String where="personid="+id;
//                if(selection!=null&&!"".equals(selection)){
//                    where=selection+"and"+where;
//                }
//                count=db.delete("person", where, selectionArgs);
//                return count;
            default:
                throw new IllegalArgumentException("Unknow Uri:"+uri.toString());
        }
    }

    @Override
    public String getType(Uri uri) {
        switch(MATCHER.match(uri)){
            case WEATHERS:
                return "vnd.android.cursor.dir/com.tianle.dbweather";
            case WEATHER:
                return "vnd.android.cursor.item/com.tianle.dbweather";
            default:
                throw new IllegalArgumentException("Unknow Uri:"+uri.toString());
        }
    }
    //往ContentProvider添加数据
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        switch(MATCHER.match(uri)){
            case WEATHERS:
                Long rovid=db.insert("tb_week_weather",null, values);
                if(rovid > 0)
                {
                    Uri insertUri=ContentUris.withAppendedId(uri, rovid);
                    this.getContext().getContentResolver().notifyChange(uri, null);
                    return insertUri;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknow Uri:"+uri.toString());
        }
        return  null;
    }

    @Override
    public boolean onCreate() {
        this.dbOpenHelper=new DBWeatherHelper(this.getContext());
        return true;
    }
    //往ContentProvider查询数据
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        switch(MATCHER.match(uri)){
            case WEATHERS:
                return db.query("tb_week_weather", projection, selection, selectionArgs, null, null, sortOrder);
//            case WEATHER:
//                long id=ContentUris.parseId(uri);
//                String where="personid="+id;
//                if(selection!=null&&!"".equals(selection)){
//                    where=selection+"and"+where;
//                }
//                return db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
            default:
                throw new IllegalArgumentException("Unknow Uri:"+uri.toString());
        }
    }
    //往ContentProvider更新数据
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        int count=0;
        switch(MATCHER.match(uri)){
            case WEATHERS:
                count=db.update("tb_week_weather", values, selection, selectionArgs);
                return count;

//            case WEATHER:
//                long id=ContentUris.parseId(uri);
//                String where="personid="+id;
//                if(selection!=null&&!"".equals(selection)){
//                    where=selection+"and"+where;
//                }
//                count=db.update("person", values, where, selectionArgs);
//                return count;
            default:
                throw new IllegalArgumentException("Unknow Uri:"+uri.toString());
        }
    }

}