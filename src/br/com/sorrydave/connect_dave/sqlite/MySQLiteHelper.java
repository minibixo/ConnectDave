package br.com.sorrydave.connect_dave.sqlite;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper{

	private static final String TABLE_CONNECTIONS = "connections";
    private static final String KEY_ID = "id";
    private static final String KEY_WEBSITE = "website";
    private static final String KEY_CONTENT = "content";
    private static final String[] COLUMNS = {KEY_ID, KEY_WEBSITE,KEY_CONTENT};
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ConnectionDB";
	
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
	public void onCreate(SQLiteDatabase db) {		
		String CREATE_CONNECTION_TABLE = "CREATE TABLE connections ( " +
        "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
        "website TEXT, "+
        "content TEXT )";

		String CREATE_LOG_TABLE = "CREATE TABLE log ( " +
		        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
		        "time DATETIME DEFAULT CURRENT_TIMESTAMP, " +
		        "id_website INTEGER )";
		
		db.execSQL(CREATE_CONNECTION_TABLE);
		db.execSQL(CREATE_LOG_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	public void addConnection(Connection connection){
		Log.d("addConnection", connection.toString()); 	
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_WEBSITE, connection.getWebsite());  
		values.put(KEY_CONTENT, connection.getContent()); 
		
		db.insert(TABLE_CONNECTIONS, 
		        null,
		        values); 		
		db.close(); 
	}	
	
	public Connection getConnection(int id){
		 
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    Cursor cursor = 
	            db.query(TABLE_CONNECTIONS, 
	            COLUMNS, 
	            " id = ?",  
	            new String[] { String.valueOf(id) }, 
	            null, 
	            null, 
	            null, 
	            null); 
	 
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    Connection connection = new Connection();
	    connection.setId(Integer.parseInt(cursor.getString(0)));
	    connection.setWebsite(cursor.getString(1));
	    connection.setContent(cursor.getString(2));
	 
	    Log.d("getConnection("+id+")", connection.toString());
	    return connection;
	}
	
	public List<Connection> getAllConnections() {
	       List<Connection> connections = new LinkedList<Connection>();
	 
	       String query = "SELECT  * FROM " + TABLE_CONNECTIONS;
	 
	       SQLiteDatabase db = this.getWritableDatabase();
	       Cursor cursor = db.rawQuery(query, null);
	 
	       Connection connection = null;
	       if (cursor.moveToFirst()) {
	           do {
	               connection = new Connection();
	               connection.setId(Integer.parseInt(cursor.getString(0)));
	               connection.setWebsite(cursor.getString(1));
	               connection.setContent(cursor.getString(2));
	 
	               connections.add(connection);
	           } while (cursor.moveToNext());
	       }
	 
	       Log.d("getAllBooks()", connections.toString());	 
	       return connections;
	   }
	
	public int updateConnection(Connection connection) {
		 
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put("title", connection.getWebsite());  
	    values.put("author", connection.getContent());
	 
	    int i = db.update(TABLE_CONNECTIONS, 
	            values, 
	            KEY_ID+" = ?", 
	            new String[] { String.valueOf(connection.getId()) }); 
	 
	    db.close();	 
	    return i;
	 
	}
	
	public void deleteConnection(Connection connection) {
		 
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONNECTIONS, 
                KEY_ID+" = ?",  
                new String[] { String.valueOf(connection.getId()) }); 
 
        db.close();
        Log.d("deleteBook", connection.toString());
 
    }
	
	
}
