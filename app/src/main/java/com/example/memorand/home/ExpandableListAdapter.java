package com.example.memorand.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.memorand.R;
import java.util.List;
import java.util.Map;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private Map<String, List<String>> proyectosYtareas;
    private List<String> proyectos;

    ExpandableListAdapter(Context context, Map<String, List<String>> proyectosYtareas, List<String> proyectos) {
        this.context = context;
        this.proyectosYtareas = proyectosYtareas;
        this.proyectos = proyectos;
    }

    @Override
    public int getGroupCount() {
        return proyectos.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return proyectosYtareas.get(proyectos.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return proyectos.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return proyectosYtareas.get(proyectos.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String equipos = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_equipos, null);
        }

        // Encuentra los elementos de la vista dentro del diseño personalizado
        ImageView imageView = convertView.findViewById(R.id.imageViewP);
        TextView textViewProyecto = convertView.findViewById(R.id.textViewProyecto);

        // Asigna los valores correspondientes a los elementos
        imageView.setImageResource(R.drawable.img);
        textViewProyecto.setText(equipos);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String proyecto = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_proyectos, null);
        }
        ImageView imageView = convertView.findViewById(R.id.imageViewT);
        TextView textViewProyecto = convertView.findViewById(R.id.textViewProyecto);

        // Asigna los valores correspondientes a los elementos
        imageView.setImageResource(R.color.color_memorand); // Aquí debería ser setImageResource en lugar de setColorFilter
        textViewProyecto.setText(proyecto);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
