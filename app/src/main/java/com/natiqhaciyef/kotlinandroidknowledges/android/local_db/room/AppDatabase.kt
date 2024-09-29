package com.natiqhaciyef.kotlinandroidknowledges.android.local_db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [CountryEntity::class, CustomField::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDao

    companion object {
        @Volatile   // for accessible every thread
        private var databaseInstance: AppDatabase? = null

        private const val lock = "Locked"
        operator fun invoke(context: Context) = databaseInstance ?: synchronized(lock) {
            databaseInstance ?: createInstance(context).also { databaseInstance = it }
        }

        private fun createInstance(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        )
            .addMigrations(MIGRATION_1_2)
            .build()

        // manual migration
        private const val DATABASE_NAME = "app_database.db"
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE notes_database ADD COLUMN creationDate INTEGER NOT NULL DEFAULT 0")
            }
        }
    }
}