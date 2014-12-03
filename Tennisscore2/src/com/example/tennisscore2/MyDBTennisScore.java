package com.example.tennisscore2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBTennisScore extends SQLiteOpenHelper {

	public MyDBTennisScore(Context context) {
		super(context, "tennisDB", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE tennisTB (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," + "title TEXT , value REAL);" );
		//db.execSQL(ÅgCREATE TABLE  tennisDB(_id INTEGER PRIMARY KEY, comment TEXT)Åh);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
