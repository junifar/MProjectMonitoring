package com.prasetia.mprojectmonitoring.config

import android.util.Base64


/**
 * Created by junifar on 12/1/2017.
 */
class Encrypt {
    companion object {
        fun encrypt(input:String): String{
            return Base64.encodeToString(input.toByteArray(Charsets.UTF_8), Base64.DEFAULT).toString()
        }

        fun decrypt(input:String): String{
            return String(Base64.decode(input, Base64.DEFAULT))
        }
    }
}