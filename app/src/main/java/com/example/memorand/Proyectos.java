package com.example.memorand;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Arrays;
import java.util.List;

public class Proyectos extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proyectos, container, false);

        ListView listViewTareas = view.findViewById(R.id.listViewTareas);

        // Obtener las tareas para mostrar (por ejemplo, desde un origen de datos)
        List<String> tareas = Arrays.asList("Tarea 1", "Tarea 2", "Tarea 3");
        List<String> fechalimite = Arrays.asList("23 de abril", "23 de abril", "2 de abril");

        // Crear y establecer el adaptador para el ListView
        TareasListAdapter adapter = new TareasListAdapter(requireContext(), tareas, fechalimite);
        listViewTareas.setAdapter(adapter);

        return view;
    }
}
