package com.dia.mous.lecteurdenews;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        // On récupère l'intent qui a lancé cette activité
        Intent i = getIntent();
        // Puis on récupère le htmlContent donné dans l'autre classe.
        String[] htmlContent = i.getStringArrayExtra(MonAdapter.strMonHtmlContent);
        //Titre
        ActionBar ab = getSupportActionBar();
        ab.setTitle(htmlContent[0]);

        //insertion de contenu dans la webview
        WebView wv = (WebView)findViewById(R.id.ma_webview);
        String cont = "<html><body style=text-align:justify>";
        cont += htmlContent[1];
        cont += "</body></html>";
        wv.loadData(cont, "text/html; charset=UTF-8", null);


    }
}
