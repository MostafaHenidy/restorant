package com.example.firststep;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper extends SQLiteOpenHelper {
    Context context;
    public static final String DataBase_Name ="Hotel";
    public static final int DataBase_version =1;

    public dbhelper(Context context){
        super(context,DataBase_Name,null,DataBase_version);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Customer("
                +"_id integer primary key autoincrement,"
                +"name varchar(50),"
                +"age varchar(50)"
                +"payment_number varchar(50))";
//        String sql2 = "CREATE TABLE hotel ("+
//                "id INT PRIMARY KEY," +
//                "name VARCHAR(255)," +
//                "number_of_rooms INT," +
//                "price FLOAT )";
        db.execSQL(sql);
//        db.execSQL(sql2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists students");
        onCreate(db);
    }
}
