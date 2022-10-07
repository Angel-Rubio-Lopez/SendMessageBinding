package com.example.sendmessagebinding.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageAplication;
import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivitySendMessageBinding;

/**
 * <h1>Proyecto SendMessage</h1>
 * En este proyecto aprenderemos a realizar las siguientes operaciones
 * <ol>
 * <li>Crear un evento en un componente Button en codigo XML</li>
 * <li>Crear un escuchador/listener del evento OnClick()</li>
 * <li>Crear un Intent y un elemento Bundle para pasar información entre Activity</li>
 * <li>El ciclo de vida de una Activity</li>
 * <li>Manejar la pila de Actividades</li>
 * </ol>
 *
 * @author Angel Rubio
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */


public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG = "SendMessageActivity";
    private ActivitySendMessageBinding binding;

    //region CICLO DE VIDA DE LA ACTIVITY

    /*
     * Método que se ejecuta cuando se crea la Activity
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setMessage(new Message(((SendMessageAplication)getApplication()).getUser()));

        //Expresion lambda

        binding.btSend.setOnClickListener(view -> sendMessage());

        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }

    /**
     * Este método callback crea el menú de opciones en la vista. Se devuelve true para indicar al SO
     * que se ha realizado la opción de modificar el menú
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * Este método callback se llama cuando se pulsa sobre una de las opciones del manú de la
     * aplicación
     * @param item
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionAboutUs:
                //Toast.makeText(this, "Se ha pulsado sobre About Us", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    /*
     * Método que se ejecuta cuando se destruye la Activity
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }

    //endregion

    /**
     * Este método es el que se llama cuando se pulsa sobre el botón btSend definido en el XML
     * android:onclick="sendMessage"
     *
     * @param view
     */

    public void sendMessage(View view) {
        sendMessage();
    }

    public void sendMessage() {
        //TODO Se modificara este ejercicio para estudiar ViewBuilding y DataBinding
        //Toast.makeText(this, "Hemos pulsado el botón", Toast.LENGTH_SHORT).show();
        //1. Crear el contenedor para añadir datos
        Bundle bundle = new Bundle();

        //1.1 Crear un objeto Message
        //Message message = new Message(etUser.getText().toString(), etMessage.getText().toString());
        bundle.putParcelable("message", binding.getMessage());

        //2. Vamos a crear el objeto Intent explícito porque se conoce la actividad
        //destino
        Intent intent = new Intent(this, ViewMessageActivity.class);        //Sobre
        intent.putExtras(bundle);                                                        //Mensaje del sobre

        //3. Inicia la transición entre una vista y otra mediante StartActivity
        startActivity(intent);
    }
}