package com.example.priya.androidfeemanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{

    public DatabaseHandler(Context context, Object name,
                           Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }
    String password;
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Mydatabase.db";
    // Contacts table name
    private static final String TABLE_REGISTER= "registeraccountant";
    public static final String KEY_ID = "AccountantID";
    public static final String KEY_NAME = " Name";
    public static final String KEY_PASSWORD = "Password";
    public static final String KEY_MOB_NO = "Contact";
    public static final String KEY_EMAIL_ID="Email";

    public static final String CREATE_TABLE="CREATE TABLE " + TABLE_REGISTER + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"+KEY_PASSWORD + " TEXT,"+KEY_MOB_NO+ " TEXT,"
            + KEY_EMAIL_ID + " TEXT" + ")";

    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);
    }
    void addregister(Registerdata registerdata)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, registerdata. getName() ); // register  name
        values.put(KEY_PASSWORD, registerdata.getPassword());
        values.put(KEY_MOB_NO, registerdata.getMobNo());//register mobile no
        values.put(KEY_EMAIL_ID, registerdata.getEmailId());//register email id

        // Inserting Row

        db.insert(TABLE_REGISTER, null, values);
        db.close(); // Closing database connection

    }
/*
    String getregister(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM registeraccountant";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);

        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }
        return password;


    }
*/

    public Registerdata validateAccountant(String userName,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM registeraccountant where Email='"+userName+"' and Password='"+password+"'";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {

            Registerdata reg = new Registerdata();
           // reg.setID(Integer.parseInt(cursor.getString(0)));
            reg.setName(cursor.getString(1));
            reg.setPassword(cursor.getString(2));
            reg.setCPassword(cursor.getString(3));
            reg.setMobNo(cursor.getString(4));
         //   reg.setEmailId(cursor.getString(5));
            return reg;
        }
        return null;
    }
    public String getDatabaseName ()
        {
            return DATABASE_NAME;
        }

        public static String getKeyId()
        {
            return KEY_ID;
        }

        public static String getTableContacts()
        {
            return TABLE_REGISTER;
        }

        public static int getDatabaseVersion()
        {
            return DATABASE_VERSION;
        }


}
