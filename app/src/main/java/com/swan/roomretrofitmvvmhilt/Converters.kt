package com.swan.roomretrofitmvvmhilt

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.swan.roomretrofitmvvmhilt.models.Rating

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromRatingToString(rating: Rating):String{
        return gson.toJson(rating)
    }

    @TypeConverter
    fun fromStringToRating(string: String):Rating{
        return gson.fromJson(string,Rating::class.java)
    }

}