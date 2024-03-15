package com.natiqhaciyef.kotlinandroidknowledges.android.content_provider

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "your_database_name.db"
        private const val DATABASE_VERSION = 1 // Change this when making schema changes
    }

    // Define table creation queries here (optional)
    private val CREATE_TABLE_QUERY = """
      CREATE TABLE IF NOT EXISTS your_table_name (
          column1_name TEXT PRIMARY KEY,
          column2_name INTEGER,
          ...
      )
  """.trimIndent()

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_QUERY) // Execute table creation query
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database schema upgrades here (if needed)
        // Example: Drop the old table and recreate it with a new schema
        db.execSQL("DROP TABLE IF EXISTS your_table_name")
        onCreate(db)
    }

    // Add methods for CRUD (Create, Read, Update, Delete) operations on your table (optional)
    fun <T> insertData(data: T) {
        // Implement logic to insert data into your table using ContentValues
    }

    fun getData(id: Long): Cursor? {
        return null
    }

    // ... other methods for update, delete, etc.
}
