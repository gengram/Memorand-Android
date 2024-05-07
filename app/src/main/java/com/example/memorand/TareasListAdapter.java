package com.example.memorand;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
public class TareasListAdapter extends BaseAdapter {

    private Context context;
    private List<String> tareas;
    private List<String> fechasLimite;

    public TareasListAdapter(Context context, List<String> tareas, List<String> fechasLimite) {
        this.context = context;
        this.tareas = tareas;
        this.fechasLimite = fechasLimite;
    }

    @Override
    public int getCount() {
        return tareas.size();
    }

    @Override
    public Object getItem(int position) {
        return tareas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_tareas, parent, false);
        }

        TextView textViewTareaNombre = convertView.findViewById(R.id.textViewTareaNombre);
        TextView tvFechaLimite = convertView.findViewById(R.id.tvFechaLimite);

        textViewTareaNombre.setText(tareas.get(position));
        tvFechaLimite.setText(fechasLimite.get(position));

        return convertView;
    }
}
