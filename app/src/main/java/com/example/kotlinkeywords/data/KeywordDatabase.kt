package com.example.kotlinkeywords.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Keyword::class], version = 1, exportSchema = false)
abstract class KeywordDatabase : RoomDatabase() {
    abstract fun keywordDao(): KeywordDao

    companion object {
        private const val DATABASE_NAME = "keyword-db"

        @Volatile
        private var instance: KeywordDatabase? = null

        fun getInstance(context: Context): KeywordDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): KeywordDatabase {
            return Room.databaseBuilder(context, KeywordDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                        }
                    }
                )
                .build()
        }

        suspend fun fillData(context: Context) {
            val database = KeywordDatabase.getInstance(context)
            database.keywordDao().insert(keywords)
        }
    }
}