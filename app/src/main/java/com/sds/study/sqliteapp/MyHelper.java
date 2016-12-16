package com.sds.study.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 안드로이드에서는 SQLITE 데이터베이스의 위치가 이미 data/data/앱패키지/databases로
 * 정해져있기 때문에 오직 Sqliteopenhelper라는 클래스를 통해 접근 및 제어 해야 한다.
 * 즉! 임의로 개발자가 디렉토리에 접근 불가
 */

public class MyHelper extends SQLiteOpenHelper{
    String TAG;

    //String name: 생성할 db파일명
    //int version: 최초의 버전 넘버
    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        TAG=this.getClass().getName();
    }

    //데이터베이스가 최초에 생성될 때 호출됨..
    //즉! 파일이 존재하지 않을 때 이 메서드가 호출됨.
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuffer sql=new StringBuffer();
        sql.append("create table member(");
        sql.append("member_id integer primary key autoincrement");
        sql.append(",id varchar(20)");
        sql.append(",password varchar(20)");
        sql.append(");");

        sqLiteDatabase.execSQL(sql.toString());

        Log.d(TAG,"데이터 베이스 구축");
    }

    //해당 파일이 이미 존재하나, 버전 숫자가 다른경우우
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"upgrade");
    }
}
