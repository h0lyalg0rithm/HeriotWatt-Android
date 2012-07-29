package com.yoarabia.heriotwatt;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {

	private static final String DATABASE_NAME = "ab";
	private static final int DATABASE_VERSION = 2;

	public MyDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);	
		//setForcedUpgradeVersion(2);
	}

	public Cursor getCourses(String course) {

		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		String [] sqlSelect = {"_id", "name"};
		String [] std = {course};
		String sqlTables = "schools";

		qb.setTables(sqlTables);
		/*Cursor c = qb.query(db, sqlSelect, null, null,
				null, null, null);*/
		Cursor c = qb.query(db, sqlSelect,"image =?",std, null, null, null, null);
		c.moveToFirst();
		return c;

	}
	public Cursor  getdetails(String id) {

		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		String [] sqlSelect = {"_id", "name","description"};
		String [] std = {id};
		String sqlTables = "schools";

		qb.setTables(sqlTables);
		/*Cursor c = qb.query(db, sqlSelect, null, null,
				null, null, null);*/
		Cursor c = qb.query(db, sqlSelect,"_id =?",std, null, null, null, null);
		c.moveToFirst();
		return c;
		

	}

}
