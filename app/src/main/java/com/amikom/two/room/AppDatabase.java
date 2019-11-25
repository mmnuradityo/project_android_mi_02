package com.amikom.two.room;

import android.content.Context;

import com.amikom.two.model.Jadwal;
import com.amikom.two.model.Presensi;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//menambahkan Presensi.class karna sebelmnya belum di panggil di databse
//setiap ada perubahan database vesinya di naikin 1
@Database(entities = {Jadwal.class, Presensi.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase db(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class, "amikom")
                .allowMainThreadQueries()
                .build();
    }

    public abstract JadwalRoom jadwalRoom();

    public abstract PresensiRoom presensiRoom();
}
