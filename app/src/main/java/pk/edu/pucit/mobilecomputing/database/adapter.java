package pk.edu.pucit.mobilecomputing.database;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Muhammad ali on 1/26/2018.
 */

public class adapter extends RecyclerView.Adapter<adapter.ProrammingViewHolder>
{
    //private String[] data;
    String[] data;


    public adapter( String[] s)
    {
        data=s;


    }

    @Override
    public adapter.ProrammingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      /*  LayoutInflater inflator34=LayoutInflater.from(parent.getContext());
        View v= inflator34.inflate(R.layout.list_items_layout,parent,false);
        return new ProrammingViewHolder(v);
        */
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items_layout, null);

        // create ViewHolder

        ProrammingViewHolder  viewHolder = new ProrammingViewHolder (itemLayoutView);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ProrammingViewHolder holder, int position) {
        String s=data[position];
        holder.name.setText(s);



    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public class ProrammingViewHolder extends RecyclerView.ViewHolder
    {
        EditText name;
        EditText amount;

        public ProrammingViewHolder( View itemview)
        {
            super(itemview);
            name=itemview.findViewById(R.id.name);
            amount=itemview.findViewById(R.id.amount);
        }

    }

}
