package com.example.diegotakei.broadcastreceiver;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Avaliacao avaliacao = new Avaliacao();
    private EditText avaliadorEt;
    private EditText tituloEt;
    private EditText notaEt;
    private EditText comentariosEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button avaliar = (Button)findViewById(R.id.avaliar);
        Button consulta = (Button)findViewById(R.id.avaliacoes);


        avaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                avaliadorEt = (EditText) findViewById(R.id.avaliador);
                tituloEt = (EditText) findViewById(R.id.titulo);
                notaEt = (EditText) findViewById(R.id.nota);
                comentariosEt = (EditText) findViewById(R.id.comentarios);

                avaliacao.setAvaliador(avaliadorEt.getText().toString());
                avaliacao.setTitulo(tituloEt.getText().toString());
                avaliacao.setNota(notaEt.getText().toString());
                avaliacao.setComentario(comentariosEt.getText().toString());

                BD bd = new BD(MainActivity.this);
                bd.inserir(avaliacao);
                Toast.makeText(MainActivity.this, "Avaliação feita com sucesso" , Toast.LENGTH_SHORT).show();

            }
        });

        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarNotificacao();
            }
        });


    }

    protected void criarNotificacao()  {

        BD bd = new BD(MainActivity.this);

        int notificationId = 001;

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.img1)
                        .setContentTitle("Número de avaliações")
                        .setContentText("Foram feitas "+ bd.buscar()+" avaliações.");

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(MainActivity.this);

        notificationManager.notify(notificationId, notificationBuilder.build());

        }

}
