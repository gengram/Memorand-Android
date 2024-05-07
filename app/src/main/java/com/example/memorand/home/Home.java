package com.example.memorand.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.memorand.Proyectos;
import com.example.memorand.R;
import com.example.memorand.Tareas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home extends Fragment {

    ExpandableListView expandableListView;
    ExpandableListAdapter listAdapter;
    Map<String, List<String>> equiposYproyectos;
    List<String> equipos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        expandableListView = view.findViewById(R.id.expandableListView);

        // Crear y llenar la estructura de datos con proyectos y tareas asociadas
        equiposYproyectos = new HashMap<>();
        equiposYproyectos.put("Equipo 1", Arrays.asList("Proyecto 1", "Proyecto 2", "Proyecto 3"));
        equiposYproyectos.put("Equipo 2", Arrays.asList("Proyecto 1.1", "Proyecto 2.1"));
        // Agrega más proyectos y sus tareas aquí...

        // Inicializa la lista de proyectos con las claves del mapa
        equipos = new ArrayList<>(equiposYproyectos.keySet());

        // Crea un adaptador personalizado y establece la estructura de datos en él
        listAdapter = new ExpandableListAdapter(requireContext(), equiposYproyectos, equipos);

        // Establece el adaptador en el ExpandableListView
        expandableListView.setAdapter(listAdapter);

        // Expande todos los grupos después de configurar el adaptador
        int groupCount = listAdapter.getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            expandableListView.expandGroup(i);
        }

        // Configura el oyente para manejar clics en los elementos secundarios (proyectos)
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // Obtener el nombre del proyecto seleccionado
                String proyectoSeleccionado = (String) listAdapter.getChild(groupPosition, childPosition);

                // Crear e iniciar el Fragment correspondiente al proyecto seleccionado
                Proyectos fragment = new Proyectos();
                Bundle args = new Bundle();
                args.putString("proyectos_name", proyectoSeleccionado);
                fragment.setArguments(args);

                // Reemplazar el Fragment actual por el Fragment de detalles del proyecto
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .addToBackStack(null) // Opcional: añadir a la pila de retroceso para que el usuario pueda regresar
                        .commit();

                return true;
            }
        });


        // Configura el oyente para manejar clics en los grupos (equipos)
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition); // Contraer el grupo si ya está expandido
                } else {
                    parent.expandGroup(groupPosition); // Expandir el grupo si está contraído
                }
                return true; // Devolver true para evitar que el clic propague al contenido del grupo
            }
        });

        return view;
    }
}
