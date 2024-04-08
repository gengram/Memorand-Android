package com.example.memorand;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {

    TextInputLayout usuarioTextField, contrasenaTextField;
    Button inicioSesionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        usuarioTextField = findViewById(R.id.usuarioTextField);
        contrasenaTextField = findViewById(R.id.contrasenaTextField);
        inicioSesionButton = findViewById(R.id.inicioSesion);

        inicioSesionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = usuarioTextField.getEditText().getText().toString().trim();
                String contrasena = contrasenaTextField.getEditText().getText().toString().trim();

                if (!usuario.isEmpty() && !contrasena.isEmpty()) {
                    new PostDataTask().execute(usuario, contrasena);

                } else {

                }

            }
        });
    }

    private class PostDataTask extends AsyncTask<String, Void, Boolean>
    {
        @Override
        protected Boolean doInBackground(String... params) {
            String usuario = params[0];
            String contrasena = params[1];
            boolean autenticado = false;

            try
            {
                String urlServidor = "http://10.0.2.2:8080/memorand/api/login";

                URL url = new URL(urlServidor);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                String body = "{\"user_email\": \"" + usuario + "\", \"user_pass\": \"" + contrasena + "\"}";

                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(body.getBytes());
                outputStream.flush();
                outputStream.close();

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK)
                {
                    autenticado = true;
                }

                connection.disconnect();

            } catch (IOException e)
            {
                e.printStackTrace();
            }

            return autenticado;
        }

        @Override
        protected void onPostExecute(Boolean autenticado) {

            if (autenticado)
            {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else{
                Toast.makeText(Login.this, "Error de autenticación. Verifique " +
                        "sus credenciales e inténtelo de nuevo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}