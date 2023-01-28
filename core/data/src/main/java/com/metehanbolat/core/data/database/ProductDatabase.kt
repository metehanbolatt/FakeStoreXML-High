package com.metehanbolat.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.metehanbolat.core.data.database.dao.ProductDao
import com.metehanbolat.core.domain.model.ProductDbModel

@Database(entities = [ProductDbModel::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}