package com.example.memorand.Ideas;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.memorand.R;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CrearIdeas extends Fragment {

    private EditText addNoteDesc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_crear_ideas, container, false);

        // Obtener referencias a los elementos de la interfaz de usuario
        addNoteDesc = view.findViewById(R.id.addNoteDesc);
        Button crearIdeaButton = view.findViewById(R.id.crearidea);

        // Configurar el listener para el botón de creación de ideas
        crearIdeaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descripcion = addNoteDesc.getText().toString().trim();

                if (!descripcion.isEmpty()) {
                    // Enviar los datos al backend
                    new CrearIdeaTask().execute(descripcion);
                } else {
                    // Manejar el caso en el que el campo esté vacío
                    Toast.makeText(getActivity(), "Por favor, ingrese una descripción", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private class CrearIdeaTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String descripcion = params[0];

            try {
                // Establecer la URL del punto final (endpoint) para crear ideas
                URL url = new URL("http://10.0.2.2:8080/memorand/api");

                // Abrir una conexión HTTP
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                // Construir el cuerpo de la solicitud JSON
                String body = "{\"descripcion\": \"" + descripcion + "\"}";

                // Enviar los datos al servidor
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(body.getBytes());
                outputStream.flush();
                outputStream.close();

                // Obtener el código de respuesta HTTP
                int responseCode = connection.getResponseCode();

                // Comprobar si la idea se creó exitosamente (código de respuesta HTTP 200)
                return responseCode == HttpURLConnection.HTTP_OK;

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                // Manejar el caso en el que la idea se haya creado exitosamente
                Toast.makeText(getActivity(), "Idea creada exitosamente", Toast.LENGTH_SHORT).show();
                // Puedes regresar a la actividad anterior o realizar alguna otra acción aquí
            } else {
                // Manejar el caso en el que ocurra un error al crear la idea
                Toast.makeText(getActivity(), "Error al crear la idea", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
