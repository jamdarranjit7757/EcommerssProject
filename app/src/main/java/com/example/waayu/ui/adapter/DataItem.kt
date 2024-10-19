package com.example.waayu.ui.adapter

import com.example.waayu.data.data_models.login.response.ProductResponse

class DataItem (val viewType: Int) {

    var recyclerItemList: List<ProductResponse>? = null
    var banner: Banner? = null

    constructor(viewType: Int, recyclerItemList: List<ProductResponse>) : this(viewType) {
        this.recyclerItemList = recyclerItemList
    }

    constructor(viewType: Int, banner: Banner) : this(viewType) {
        this.banner = banner
    }

}

data class Banner(val image: Int)