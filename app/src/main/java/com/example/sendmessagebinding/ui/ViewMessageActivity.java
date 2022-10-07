package com.example.sendmessagebinding.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivityViewMessageBinding;

/**
 * Clase que muestra un mensaje de un usuario. Recoge un mensaje que implementa la interdaz
 * Parcelable
 */

public class ViewMessageActivity extends AppCompatActivity {

    private static final String TAG = "ViewMessageActivity";
    private ActivityViewMessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding
        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1. Recoge el Bundle que me han enviado en el Intent que ha iniciado
        //esta actividad
        Bundle bundle = getIntent().getExtras();
        Message message = bundle.getParcelable("message");
        binding.setMessage(message);

        binding.tvUserContent.setText(message.getUser().getName());
        binding.tvMessageContent.setText(message.getContent());
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }

}