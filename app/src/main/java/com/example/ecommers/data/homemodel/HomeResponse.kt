package com.example.ecommers.data.data_models.login.response

import com.google.gson.annotations.SerializedName

data class HomeResponse (

    @SerializedName("sliderArray"        ) var sliderArray        : ArrayList<SliderArray>       = arrayListOf(),
    @SerializedName("topCategoryArray"   ) var topCategoryArray   : ArrayList<ProductResponse>  = arrayListOf(),
    @SerializedName("topBrandArray"      ) var topBrandArray      : ArrayList<ProductResponse>     = arrayListOf(),
    @SerializedName("groceryItemsArray"  ) var groceryItemsArray  : ArrayList<ProductResponse> = arrayListOf(),
    @SerializedName("homePageCallStatus" ) var homePageCallStatus : Boolean?                     = null

)
data class SliderArray (

    @SerializedName("image" ) var image : String? = null

)

data class ProductResponse (

    @SerializedName("_id"   ) var Id    : String? = null,
    @SerializedName("name"  ) var name  : String? = null,
    @SerializedName("image" ) var image : String? = null

)





