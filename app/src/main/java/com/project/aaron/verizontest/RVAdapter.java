
package com.project.aaron.verizontest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Aaron Revilla on 11/13/2016.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{

    private List<AppInfo> appsList;
    private Context viewContext;

    public RVAdapter(List<AppInfo> appsList, Context viewContext){
        this.appsList = appsList;
        this.viewContext = viewContext;
    }

    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.viewContext);

        // Inflate the custom layout
        View appView = inflater.inflate(R.layout.view_holder_view, parent, false);

        // Return a new holder instance
        RVAdapter.ViewHolder viewHolder = new RVAdapter.ViewHolder(appView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {
        AppInfo app = appsList.get( position);

        holder.vh_app_img.setImageDrawable ( app.getAppImg());
        holder.vh_app_name.setText( app.getPkgName());
        holder.vh_time_onbattery.setText( app.getTimeOnBattery());
        holder.vh_cellular_data.setText( app.getMobileData());
        holder.vh_wifi_data.setText( app.getWifiData());
        holder.vh_pwer_darin.setText( app.getPowerDrain());

    }

    @Override
    public int getItemCount() {
        return appsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView vh_app_img;
        public TextView vh_app_name;
        public TextView vh_time_onbattery;
        public TextView vh_cellular_data;
        public TextView vh_wifi_data;
        public TextView vh_pwer_darin;


        public ViewHolder(View itemView){
            super(itemView);

            vh_app_img = (ImageView) itemView.findViewById(R.id.vh_app_img);
            vh_app_name = (TextView) itemView.findViewById(R.id.vh_app_name);
            vh_time_onbattery = (TextView) itemView.findViewById(R.id.vh_time_onbattery);
            vh_cellular_data = (TextView) itemView.findViewById(R.id.vh_cellular_data);
            vh_wifi_data = (TextView) itemView.findViewById(R.id.vh_wifi_data);
            vh_pwer_darin =(TextView) itemView.findViewById(R.id.vh_pwer_darin);
        }


    }
}
