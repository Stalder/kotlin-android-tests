package com.example.kotlincrud.converters

import com.tickaroo.tikxml.TypeConverter

class IntConverter : TypeConverter<Int> {

    @Throws(Exception::class)
    override fun read(value: String): Int {
        return value.toInt()
    }

    @Throws(Exception::class)
    override fun write(value: Int): String {
        return value.toString()
    }

}