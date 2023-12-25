package com.natiqhaciyef.kotlinandroidknowledges.android.local_db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CountryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDao

    companion object {
        @Volatile   // for accessible every thread
        private var databaseInstance: AppDatabase? = null

        private const val lock = "Locked"
        operator fun invoke(context: Context) = databaseInstance ?: synchronized(lock) {
            databaseInstance ?: createInstance(context).also {  databaseInstance = it }
        }

        private fun createInstance(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}