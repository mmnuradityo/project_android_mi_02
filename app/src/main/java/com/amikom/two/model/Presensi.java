package com.amikom.two.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Presensi {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "makul")
    public String mataKuliah;

    @ColumnInfo(name = "hadir")
    public String hadir;

    public Presensi() {

    }

    public Presensi(String mataKuliah, String hadir) {
        this.mataKuliah = mataKuliah;
        this.hadir = hadir;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getHadir() {
        return hadir;
    }

    public void setHadir(String hadir) {
        this.hadir= hadir;
    }



}
