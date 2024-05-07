package com.example.memorand.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.memorand.R;

import java.util.ArrayList;

public class Perfil extends Fragment {

    private ListView listView;
    private ProfileAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        listView = view.findViewById(R.id.profileListView);
        adapter = new ProfileAdapter(getActivity(), new ArrayList<>());
        listView.setAdapter(adapter);

        // Simular la obtención de información del usuario con un correo fijo
        String nombre = "Nicolas Juarez";
        String correo = "nicotest@gmail.com";
        String estado = "Activo";

        // Agregar datos del perfil con el texto correspondiente
        adapter.add(new ProfileItem("Nombre: ", nombre));
        adapter.add(new ProfileItem("Correo: ", correo));
        adapter.add(new ProfileItem("Estado: ", estado));

        // Puedes agregar más datos del usuario aquí según sea necesario

        return view;
    }

}
