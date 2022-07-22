package com.example.ejemploreciclwview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReciclewViewAdapter extends RecyclerView.Adapter<ReciclewViewAdapter.NumerosViewHolder> {
    private  int mNumerosItems;
    final private listItemClick mOnClickListener;

    public ReciclewViewAdapter(int numeroDeItems,listItemClick listener){
        mNumerosItems = numeroDeItems;
        mOnClickListener = listener;
    }

    public interface listItemClick{
        void onListItemClick(int clickedItem);

    }

    @NonNull
    @Override
    public NumerosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        int layoutIdParaListItem = R.layout.lista_numeros_row;
        LayoutInflater INFLATER = LayoutInflater.from(mContext);
        boolean attachToParentRapido = false;

        View view = INFLATER.inflate(layoutIdParaListItem,parent,attachToParentRapido);
        NumerosViewHolder viewHolder = new NumerosViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumerosViewHolder holder, int position) {

        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumerosItems;
    }

    class NumerosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView mTvListaNumeros;
        public NumerosViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvListaNumeros = itemView.findViewById(R.id.tv_lista_numeros);
            itemView.setOnClickListener(this);
        }
        void bind(int listaIndex){
            mTvListaNumeros.setText(String.valueOf((listaIndex)));

        }

        @Override
        public void onClick(View v) {
           int clickedItem = getAdapterPosition();
           mOnClickListener.onListItemClick(clickedItem);


        }
    }

}
