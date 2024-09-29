package com.natiqhaciyef.kotlinandroidknowledges.android.local_db.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {
    @Query("SELECT * FROM country_table")
    suspend fun getCountry(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountry(countryEntity: CountryEntity) //: Long

    @Delete
    suspend fun deleteCountry(countryEntity: CountryEntity) //: Long


    @Query("SELECT * FROM custom_field")
    suspend fun getCustomFields(): List<CustomField>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCustomField(customField: CustomField)

    @Delete
    suspend fun deleteCustomField(customField: CustomField)
}