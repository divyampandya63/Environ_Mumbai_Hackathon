package tito.example.com.environ_mumbai_hackathon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import tito.example.com.environ_mumbai_hackathon.Helper.Common;
import tito.example.com.environ_mumbai_hackathon.Interface.ItemClickListener;
import tito.example.com.environ_mumbai_hackathon.Model.Records;
import tito.example.com.environ_mumbai_hackathon.R;

/**
 * Created by tito on 10/3/18.
 */

class SoilSourceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    ItemClickListener itemClickListener;
    TextView soilname,soil_index;



    public SoilSourceViewHolder(View itemView) {
        super(itemView);
        soilname=(TextView)itemView.findViewById(R.id.rivername);
        soil_index= itemView.findViewById(R.id.wqi);
        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false );
    }
}
public class SoilFragmentAdapter extends RecyclerView.Adapter<SoilSourceViewHolder>{
    private Context context;
    private List<Records> records;


    public SoilFragmentAdapter(Context context, List<Records> records) {
        this.context = context;
        this.records=records;
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    @Override
    public SoilSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.list_soil_item,parent,false);
        return new SoilSourceViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final SoilSourceViewHolder holder,  final int position) {
        holder.soilname.setText(records.get(position).getLocations());

    }
}
