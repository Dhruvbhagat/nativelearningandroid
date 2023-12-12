package com.example.nativeandroid.utils

import android.content.Context
import java.io.IOException


class JsonUtil {
    fun loadJSONFromAsset(context: Context, fileName: String): String? {
        var json: String? = null
        json = try {
            val `is` = context.assets.open(fileName)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}