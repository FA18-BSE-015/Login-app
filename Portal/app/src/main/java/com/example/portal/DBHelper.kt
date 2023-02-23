package com.example.portal

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.os.Debug
import android.widget.Toast

class DBHelper(context: Context):SQLiteOpenHelper(context,"Userdatat", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table Userdatat(username Text primary key, password TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       db?.execSQL("drop table if exists UserDatat")
    }
    fun insertdata(uname: String, upassword: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("username", uname)
        cv.put("password", upassword)
        val result = db.insert(" Userdatat", null, cv)

        Log.d("TAG", "message")

        if(result==-1 .toLong()){
            return false
        }
            return true
    }
    fun checkuserpress(username: String, password: String): Boolean {
        val db = this.writableDatabase
        val query = "select * from Userdatat where username='$username' and password='$password'"
        val cursor =db.rawQuery(query, null)
        if(cursor.count<=0){
                cursor.close()
                return false

        }
        cursor.close()
        return true
    }
}