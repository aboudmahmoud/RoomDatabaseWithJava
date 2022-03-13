package com.example.roomdatabasewithjaba.Database;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date LongToDate(Long millsecond)
    {
        return millsecond==null?null:new Date(millsecond);
    }

    @TypeConverter
    public static Long DateTolong(Date date)
    {
        return date==null?null:date.getTime();
    }

}
