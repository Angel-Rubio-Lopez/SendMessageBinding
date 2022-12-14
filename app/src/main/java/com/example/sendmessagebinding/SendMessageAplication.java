package com.example.sendmessagebinding;

import android.app.Application;
import com.example.sendmessagebinding.data.User;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class SendMessageAplication extends Application {

    // Usuario que ha iniciado sesión. DATO GLOBAL porque siempre se va a acceder a él mediante
    // método getApplication().getUser()
    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("Se ha inicializado el objeto Application");
        user = new User("Ángel", "angelrubiolopez03@gmail.com");
    }

    public User getUser() {
        return user;
    }

}
