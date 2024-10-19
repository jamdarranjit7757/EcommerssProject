package com.example.waayu.roomdbsetup.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.waayu.data.historymodel.HistoryRoomData
import com.example.waayu.data.product.Product

/*
@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class CartDataBase  : RoomDatabase(){
    abstract fun cartDao():CartDao

    companion object {

        @Volatile
        private var INSTANCE: CartDataBase? = null

        fun getDataBase(context: Context): CartDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartDataBase::class.java,
                    "tbl_cart"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}*/
