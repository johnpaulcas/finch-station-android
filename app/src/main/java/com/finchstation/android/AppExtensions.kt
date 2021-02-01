package com.finchstation.android

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */


fun Int.toDateFormat(): String {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
    val date = Date(this.toLong() * 1000)
    return simpleDateFormat.format(date)
}