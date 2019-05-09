package com.babyapp;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UsersInfo.db";
    public static final String TABLE_NAME = "UsersInfo_table";
    private static final String COLUMN_1 = "ID";
    private static final String COLUMN_2 = "PRODUCTO";
    private static final String COLUMN_3 = "TIENDA";
    private static final String COLUMN_4 = "SUCURSAL";
    private static final String COLUMN_5 = "OFERTA";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteOpenHelper){
        sqLiteOpenHelper.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUCTO TEXT, TIENDA TEXT, SUCURSAL TEXT, OFERTA TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean insertData(String editProducto, String editTienda, String editSucursal, String editOferta){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_2, editProducto);
        contentValues.put(COLUMN_3, editTienda);
        contentValues.put(COLUMN_4, editSucursal);
        contentValues.put(COLUMN_5, editOferta);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM  " + TABLE_NAME, null);
        return result;
    }

    public boolean updateData(String id, String editProducto, String editTienda, String editSucursal, String editOferta){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_2, editProducto);
        contentValues.put(COLUMN_3, editTienda);
        contentValues.put(COLUMN_4, editSucursal);
        contentValues.put(COLUMN_5, editOferta);
        long result = sqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }
}
