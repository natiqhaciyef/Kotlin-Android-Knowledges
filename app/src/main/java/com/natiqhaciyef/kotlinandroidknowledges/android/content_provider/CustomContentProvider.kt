package com.natiqhaciyef.kotlinandroidknowledges.android.content_provider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri

class CustomContentProvider : ContentProvider() {
    companion object {
        private const val CUSTOM_PROVIDER_NAME = "com.natiqhaciyef.kotlinandroidknowledges"
        private const val URL = "content://$CUSTOM_PROVIDER_NAME/users"
        private var db: SQLiteDatabase? = null

        val CONTENT_URI: Uri = Uri.parse(URL)
        const val id = "id"
        const val name = "name"
        const val uriCode = 1
        private var uriMatcher: UriMatcher? = null
        private val values: HashMap<String, String>? = null

        // declaring name of the database
        const val DATABASE_NAME = "UserDB"

        // declaring table name of the database
        private const val TABLE_NAME = "Users"

        // declaring version of the database
        const val DATABASE_VERSION = 1

        // sql query to create the table
        const val CREATE_DB_TABLE =
            (" CREATE TABLE " + TABLE_NAME
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " name TEXT NOT NULL);")

        init {

            // to match the content URI
            // every time user access table under content provider
            uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

            // to access whole table
            uriMatcher!!.addURI(
                CUSTOM_PROVIDER_NAME,
                "users",
                uriCode
            )

            // to access a particular row
            // of the table
            uriMatcher!!.addURI(
                CUSTOM_PROVIDER_NAME,
                "users/*",
                uriCode
            )
        }
    }

    override fun onCreate(): Boolean {
        val context = context
        if (context != null) {
            val dbHelper =
                DatabaseHelper(context)
            db = dbHelper.writableDatabase
        }
        return db != null
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, str: String?
    ): Cursor? {
        var sortOrder = str
        val qb = SQLiteQueryBuilder()
        qb.tables = TABLE_NAME
        when (uriMatcher!!.match(uri)) {
            uriCode -> qb.projectionMap = values
            else -> throw IllegalArgumentException("Unknown URI $uri")
        }
        if (sortOrder == null || sortOrder === "") {
            sortOrder = id
        }
        val c = qb.query(
            db, projection, selection, selectionArgs, null,
            null, sortOrder
        )
        c.setNotificationUri(context!!.contentResolver, uri)
        return c
    }

    override fun getType(p0: Uri): String =
        when (uriMatcher?.match(p0)) {
            uriCode -> "vnd.android.cursor.dir/users"
            else -> throw IllegalArgumentException("Unsupported URI: $p0")
        }

    override fun insert(p0: Uri, values: ContentValues?): Uri {
        val rowID = db!!.insert(TABLE_NAME, "", values)
        if (rowID > 0) {
            val uri =
                ContentUris.withAppendedId(CONTENT_URI, rowID)
            context!!.contentResolver.notifyChange(uri, null)
            return uri
        }
        throw SQLiteException("Failed to add a record into $p0")
    }

    override fun delete(
        uri: Uri,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        val count = when (uriMatcher!!.match(uri)) {
            uriCode -> db!!.delete(TABLE_NAME, selection, selectionArgs)
            else -> throw IllegalArgumentException("Unknown URI $uri")
        }
        context!!.contentResolver.notifyChange(uri, null)
        return count
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        val count = when (uriMatcher!!.match(uri)) {
            uriCode -> db!!.update(TABLE_NAME, values, selection, selectionArgs)
            else -> throw IllegalArgumentException("Unknown URI $uri")
        }
        context!!.contentResolver.notifyChange(uri, null)
        return count
    }
}