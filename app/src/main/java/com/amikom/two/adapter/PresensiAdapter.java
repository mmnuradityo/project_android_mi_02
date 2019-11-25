package com.amikom.two.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.amikom.two.R;
import com.amikom.two.model.Jadwal;
import com.amikom.two.model.Presensi;

import java.util.List;

public class PresensiAdapter extends RecyclerView.Adapter<PresensiAdapter.ViewHolder> {
    private Context context;
    private List<Presensi> presensi;
    private AdapterView.OnItemClickListener listener;

    public PresensiAdapter(Context context, List<Presensi> presensi,
                         AdapterView.OnItemClickListener listener) {
        this.context = context;
        this.presensi = presensi;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_presensi, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        // pengecekan apakah datanya ada atau tidak
        if (presensi != null) {
            viewHolder.bind(presensi.get(i));
            viewHolder.onClickItem(i);
        }
    }

    @Override
    public int getItemCount() {
        return presensi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMakul;
        public TextView tvHadir;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMakul = itemView.findViewById(R.id.presensi_makul);
            tvHadir = itemView.findViewById(R.id.presensi_hadir);

        }

        public void bind(Presensi presensi) {
            // setdata kedalam list presensi
            tvMakul.setText(presensi.getMataKuliah());
            tvHadir.setText(presensi.getHadir());
        }

        public void onClickItem(final int i) {
            // set onClick item di pisah biar rapi
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(null, itemView, i, i);
                }
            });
        }

    }

}
