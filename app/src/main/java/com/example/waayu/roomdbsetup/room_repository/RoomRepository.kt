package com.example.waayu.roomdbsetup.room_repository

import com.example.waayu.data.historymodel.HistoryRoomData
import com.example.waayu.data.product.Product


interface RoomRepository {
    suspend fun getHistory () :List<HistoryRoomData>

    suspend fun addData(history: HistoryRoomData)

    suspend fun  getCart() : List<Product>

    suspend fun addToCart(product: Product)
    suspend fun removeFromCart(product: Product)
}