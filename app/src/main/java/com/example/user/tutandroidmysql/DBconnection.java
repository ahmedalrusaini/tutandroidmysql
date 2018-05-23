package com.example.user.tutandroidmysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


/**
 * Created by user on 9/13/2017.
 */

class DBconnection {
    DBInfo DbInfo;
    public DBconnection(Context context) {
            DbInfo=new DBInfo(context);
    }

    public  long dataInsert(String name, String username, String password){

        SQLiteDatabase sqLiteDatabase=DbInfo.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBInfo.names,name);
        contentValues.put(DBInfo.username,username);
        contentValues.put(DBInfo.password,password);
        long id=sqLiteDatabase.insert(DbInfo.tblname,null,contentValues);
        return id;
    }

    public String viewData(){
        SQLiteDatabase sqLiteDatabase=DbInfo.getWritableDatabase();

        String[]columns={DBInfo.uid, DBInfo.names, DBInfo.username, DBInfo.password};
        Cursor cursor= sqLiteDatabase.query(DBInfo.tblname,columns,null,null,null,null,null);

        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
            int uid=cursor.getInt(0);
            String name=cursor.getString(1);
            String username=cursor.getString(2);
            String password=cursor.getString(3);

            buffer.append(uid+" "+name+" "+username+" "+password+"\n");
        }
        return buffer.toString();
    }

    public String searchdata(String input, char type){
        SQLiteDatabase sqLiteDatabase=DbInfo.getWritableDatabase();
        String[]columns={DBInfo.names, DBInfo.username, DBInfo.password};
        Cursor cursor=null;
        if (type == 'U'){
            cursor= sqLiteDatabase.query(DBInfo.tblname,columns, DBInfo.username+" = '"+input+"' ",null,null,null,null,null);
        }else if (type == 'F'){
            cursor= sqLiteDatabase.query(DBInfo.tblname,columns, DBInfo.names+" = '"+input+"' ",null,null,null,null,null);
        }
        StringBuffer stringBuffer=new StringBuffer();
        while (cursor.moveToNext()){
            int index1=cursor.getColumnIndex(DBInfo.names);
            int index2=cursor.getColumnIndex(DBInfo.username);
            int index3=cursor.getColumnIndex(DBInfo.password);
            String f=cursor.getString(index1);
            String u=cursor.getString(index2);
            String p=cursor.getString(index3);
            stringBuffer.append(f+" "+u+" "+p+"\n");
        }
        cursor.close();
        return stringBuffer.toString();
    }

    public int updatename(String OLD, String NEW){
        SQLiteDatabase sqLiteDatabase=DbInfo.getWritableDatabase();
        String[]whereArgs={OLD};
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBInfo.username , NEW);
        int count=sqLiteDatabase.update(DBInfo.tblname,contentValues, DBInfo.username+" LIKE ? ",whereArgs);
        return count;
    }

    public int deletename(String name){
        SQLiteDatabase sqLiteDatabase=DbInfo.getWritableDatabase();
        String[]whereArgs={name};
        int count=sqLiteDatabase.delete(DBInfo.tblname, DBInfo.username+" =? ",whereArgs);
        return count;
    }

    static class DBInfo extends SQLiteOpenHelper
    {
        private static final String dbname="ahmedb";
        private static final String tblname="ahmedtbl";
        private static final int dbver=4;
        private static final String uid="Id";
        private static final String names="Name";
        private static final String username="Username";
        private static final String password="Password";
        private static final String drop_table="DROP TABLE IF EXISTS "+tblname;
        private static final String create_table="CREATE TABLE "+tblname+
                " ("+uid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+names+" VARCHAR(255), "+username+" VARCHAR(255), "+password+" VARCHAR(255));";
        private Context context;


        public DBInfo(Context context) {
            super(context, dbname, null, dbver);
            this.context=context;
            Toast.makeText(context,"this constructor", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(create_table);
                Toast.makeText(context,"this onCreate", Toast.LENGTH_LONG).show();
            }catch (SQLException e){
                Toast.makeText(context,"due to: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {
                db.execSQL(drop_table);
                onCreate(db);
                Toast.makeText(context,"this onUpgrade", Toast.LENGTH_LONG).show();
            }catch (SQLException e){
                Toast.makeText(context,"due to: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }



        }
    }


}