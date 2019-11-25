package com.amikom.two.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amikom.two.R;
import com.amikom.two.adapter.JadwalAdapter;
import com.amikom.two.dao.JadwalDAO;
import com.amikom.two.jadwal.TambahJadwalActivity;
import com.amikom.two.model.Jadwal;
import com.amikom.two.room.AppDatabase;
import com.amikom.two.room.JadwalRoom;

import java.util.ArrayList;
import java.util.List;

public class JadwalUI extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private JadwalAdapter jadwalAdapter;
    private List<Jadwal> list = new ArrayList<>();
    // private JadwalDAO jadwalDAO;
    private JadwalRoom jadwalRoom;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // jadwalDAO = new JadwalDAO();
        jadwalRoom = AppDatabase.db(getContext()).jadwalRoom();
        // list = jadwalDAO.selectAll();
        list = jadwalRoom.selectAll();
        jadwalAdapter = new JadwalAdapter(getContext(), list, this);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_jadwal, container, false);
        recyclerView = view.findViewById(R.id.recycler_jadwal);
        recyclerView.setAdapter(jadwalAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(llm);
        FloatingActionButton fab = view.findViewById(R.id.fab_jadwal);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), TambahJadwalActivity.class);
        startActivityForResult(intent, 30);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            list.clear();
            list.addAll(jadwalRoom.selectAll());
            jadwalAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Jadwal jadwal = list.get(position);
        Toast.makeText(getContext(), jadwal.getHari(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getContext(), TambahJadwalActivity.class);
        intent.putExtra("id", jadwal.getId());
        startActivityForResult(intent, 50);
    }
}
