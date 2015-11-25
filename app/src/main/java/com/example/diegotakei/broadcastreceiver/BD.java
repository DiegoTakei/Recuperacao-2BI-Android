package com.example.diegotakei.broadcastreceiver;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Diego Takei on 23/11/2015.
 */
public class BD {

    private SQLiteDatabase bd;

    public BD(Context context){
        SQLHelper auxBd = new SQLHelper(context);
        bd = auxBd.getWritableDatabase();
    }

    public void inserir(Avaliacao avaliacao){
        ContentValues valores = new ContentValues();
        valores.put("avaliador", avaliacao.getAvaliador());
        valores.put("titulo", avaliacao.getTitulo());
        valores.put("nota", avaliacao.getNota());
        valores.put("comentario", avaliacao.getComentario());


        bd.insert("TB_AVALIACAO",null,valores);

    }

    public int buscar(){
        String[] colunas = new String[]{"_id"};
        Cursor cursor = bd.query("TB_AVALIACAO", colunas, null, null, null, null, "_id");
        int tam = cursor.getCount();
        return tam;
    }
}
