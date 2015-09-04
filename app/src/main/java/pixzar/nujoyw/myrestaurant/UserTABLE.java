package pixzar.nujoyw.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by SCIENCE on 9/3/2015.
 */
public class UserTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String USER_TABLE = "userTABLE";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USER = "User";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";

    public UserTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }//Constructor เป็นMethod ที่เดียวกับ Class
    public long addNewUser(String strUser, String strPassword, String strName) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER, strUser);
        objContentValues.put(COLUMN_PASSWORD, strPassword);
        objContentValues.put(COLUMN_NAME, strName);

        return readSqLiteDatabase.insert(USER_TABLE, null, objContentValues);
    }

    public String[] searchUser(String strUser) {
        try {
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(USER_TABLE,
                    //หาที่ไหน
                    new String[]{COLUMN_ID_USER,COLUMN_USER,COLUMN_PASSWORD,COLUMN_NAME},
                    //หาอะไร
                    COLUMN_USER + "=?",
                    //กำหนดว่า เอาคำไหนไปหา
                    new String[]{String.valueOf(strUser)},
                    null,null,null,null);
            if (objCursor != null) {
                if (objCursor.moveToFirst()) {
                    strResult = new String[4];
                    strResult[0] = objCursor.getString(0);
                    strResult[1] = objCursor.getString(1);
                    strResult[2] = objCursor.getString(2);
                    strResult[3] = objCursor.getString(3);
                }
            }
            objCursor.close();
            return strResult;
        } catch (Exception e) {
            return null;
        }

       //return new String[0];
    }


}//Main Class
