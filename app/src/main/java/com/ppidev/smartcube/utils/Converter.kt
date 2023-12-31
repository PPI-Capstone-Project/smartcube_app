package com.ppidev.smartcube.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.TimeZone


fun convertMillisecondsToHoursAndMinutes(milliseconds: Long): String {
    val seconds = milliseconds / 1000
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60

    return String.format("%02d hours %02d minutes", hours, minutes)
}


fun extractNumberFromString(inputString: String): Long? {
    return try {
        val number = inputString.split(" ")[0].toDouble().toLong()
        number
    } catch (e: NumberFormatException) {
        // Handle the case where the first part is not a valid number
        println("Invalid input: $inputString does not contain a valid number.")
        null
    }
}

fun extractFloatFromString(input: String): Float? {
    val regex = Regex("""\d+\.\d+""")
    val matchResult = regex.find(input)
    return matchResult?.value?.toFloatOrNull()
}

@SuppressLint("SimpleDateFormat")
fun isoDateFormatToStringDate(isoDate: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        inputFormat.timeZone = TimeZone.getDefault()
        val date = inputFormat.parse(isoDate) as Date
        val outputFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        outputFormat.timeZone = TimeZone.getDefault()
        outputFormat.format(date)
    } catch (e: Exception) {
        "-"
    }
}


fun isoDateToEpoch(isoDateString: String): Long {
    val instant = Instant.parse(isoDateString)
    return instant.epochSecond
}
