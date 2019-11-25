package com.amikom.two.dao;

import com.amikom.two.model.Jadwal;
import com.amikom.two.model.Presensi;

import java.util.ArrayList;
import java.util.List;

public class PresensiDAO {
    private List<Presensi> list = new ArrayList<>();

    public PresensiDAO() {
        list.add(new Presensi("Mobile Programming II", "14"));
        list.add(new Presensi("Mobile Programming II", "14"));
    }

    public void insert(Presensi presensi) {
        list.add(presensi);
    }

    public void update(int id, Presensi presensi) {
        Presensi old = list.get(id);
        old.setHadir(presensi.getHadir());
        old.setMataKuliah(presensi.getMataKuliah());
    }

    public void delete(int id) {
        list.remove(id);
    }

    public Presensi select(int id) {
        return list.get(id);
    }

    public List<Presensi> selectAll() {
        return list;
    }
}

