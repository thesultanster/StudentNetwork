package com.example.sultan.elitestudent;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


// the <> contains my custom viewholder; MyViewHolder, and this class will return MyViewHolder as well
public class ClassesRecyclerAdapter extends RecyclerView.Adapter<ClassesRecyclerAdapter.MyViewHolder>{

    // emptyList takes care of null pointer exception
    List<ClassesRecyclerInfo> data = Collections.emptyList();
    LayoutInflater inflator;

    public ClassesRecyclerAdapter(Context context, List<ClassesRecyclerInfo> data){
        inflator = LayoutInflater.from(context);
        this.data = data;
    }

    // Called when the recycler view needs to create a new row
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflator.inflate(R.layout.classes_custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    // Setting up the data for each row
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // This gives us current information list object
        ClassesRecyclerInfo current = data.get(position);

        holder.title.setText(current.title);
        holder.location.setText(current.location);
        holder.timeStart.setText(current.timeStart);
        holder.timeEnd.setText(current.timeEnd);
        holder.days.setText(current.days);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // Created my custom view holder
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView location;
        TextView timeStart;
        TextView timeEnd;
        TextView days;


        // itemView will be my own custom layout View of the row
        public MyViewHolder(View itemView) {
            super(itemView);

            //Link the objects
            title = (TextView) itemView.findViewById(R.id.titleText);
            location = (TextView) itemView.findViewById(R.id.locationText);
            timeStart = (TextView) itemView.findViewById(R.id.startTimeText);
            timeEnd = (TextView) itemView.findViewById(R.id.endTimeText);
            days = (TextView) itemView.findViewById(R.id.daysText);
        }
    }
}
