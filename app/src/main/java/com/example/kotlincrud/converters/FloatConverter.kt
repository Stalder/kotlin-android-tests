package com.example.kotlincrud.converters

import com.tickaroo.tikxml.TypeConverter

class FloatConverter : TypeConverter<Float> {

    @Throws(Exception::class)
    override fun read(value: String): Float {
        return value.replace(',', '.').toFloat()
    }

    @Throws(Exception::class)
    override fun write(value: Float): String {
        return value.toString()
    }

}