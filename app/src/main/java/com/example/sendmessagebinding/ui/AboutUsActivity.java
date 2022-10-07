package com.example.sendmessagebinding.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageAplication;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                //.setCover()
                .setName(((SendMessageAplication)getApplication()).getUser().getName())
                .setSubTitle(getResources().getString(R.string.aboutSubTitle))
                .setBrief(getResources().getString(R.string.aboutBrief))
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("---")
                .addGitHubLink("https://github.com/Angel-Rubio-Lopez")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        setContentView(view);

    }
}