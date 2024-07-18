package com.sri.weatherapp.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converter {

    @RequiresApi(Build.VERSION_CODES.O)
    fun StringToDate(date: String) : LocalDateTime {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        return date.format(formatter)

    }
}