package com.amikom.two.jadwal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amikom.two.R;
import com.amikom.two.model.Jadwal;
import com.amikom.two.model.Presensi;
import com.amikom.two.room.AppDatabase;
import com.amikom.two.room.JadwalRoom;
import com.amikom.two.room.PresensiRoom;

public class TambahPresensiActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtMakul;
    EditText edtHadir;
    Button btnTambah;
    Button btnHapus;
    PresensiRoom presensiRoom;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_presensi);
        edtMakul = findViewById(R.id.presensi_tambah_makul);
        edtHadir = findViewById(R.id.presensi_tambah_hadir);
        btnTambah = findViewById(R.id.presensi_tambah);
        btnTambah.setOnClickListener(this);
        btnHapus = findViewById(R.id.presensi_hapus);

        presensiRoom = AppDatabase.db(this).presensiRoom();
        id = getIntent().getIntExtra("id", 0);
        if (id != 0) {
            Presensi presensi = presensiRoom.select(id);
            edtMakul.setText(presensi.getMataKuliah());
            edtHadir.setText(presensi.getHadir());
            btnTambah.setText("Update Presensi");
            btnHapus.setVisibility(View.VISIBLE);
            btnHapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Presensi presensi = presensiRoom.select(id);
                    presensiRoom.delete(presensi);
                    Intent result = new Intent();
                    setResult(Activity.RESULT_OK, result);
                    finish();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        Intent result = new Intent();
        Presensi presensi = new Presensi();
        if (id != 0) {
            presensi = presensiRoom.select(id);
        }
        presensi.setMataKuliah(edtMakul.getText().toString());
        presensi.setHadir(edtHadir.getText().toString());
        if (id != 0) {
            presensiRoom.update(presensi);
        } else {
            presensiRoom.insert(presensi);
        }
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
