package com.example.ejemploreciclwview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ReciclewViewAdapter.listItemClick{
    private RecyclerView RVnumeros;
    private static final int Lista_Numeros = 100;
    private Toast mTOAST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RVnumeros = findViewById(R.id.rVNumeros);
        RVnumeros.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        RVnumeros.setLayoutManager(linearLayout);

        ReciclewViewAdapter mAdapter = new ReciclewViewAdapter(Lista_Numeros,this);
        RVnumeros.setAdapter(mAdapter);

    }

    @Override
    public void onListItemClick(int clickedItem) {

        if (mTOAST != null){
            mTOAST.cancel();
        }

 
        String mensajeToast ="item #"+ clickedItem + "clicado";
        mTOAST = Toast.makeText(this,mensajeToast,Toast.LENGTH_SHORT);
        mTOAST.show();
    }
}