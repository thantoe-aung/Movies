package com.mvp.movies.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mvp.movies.data.vos.GenreVO
import java.lang.reflect.Type

class GenreListTypeConverter {

    @TypeConverter
    fun genreListToJson(genreList : List<GenreVO>) : String{
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun jsonToGenreList(jsonString : String): List<GenreVO>{
       val type=object :TypeToken<List<GenreVO>>(){}.type
        return Gson().fromJson(jsonString,type)
    }
}