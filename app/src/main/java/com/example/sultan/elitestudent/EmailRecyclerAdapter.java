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
public class EmailRecyclerAdapter extends RecyclerView.Adapter<EmailRecyclerAdapter.MyViewHolder>{

    // emptyList takes care of null pointer exception
    List<EmailRecyclerInfo> data = Collections.emptyList();
    LayoutInflater inflator;

    public EmailRecyclerAdapter( Context context, List<EmailRecyclerInfo> data){
        inflator = LayoutInflater.from(context);
        this.data = data;
    }

    // Called when the recycler view needs to create a new row
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflator.inflate(R.layout.email_custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    // Setting up the data for each row
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // This gives us current information list object
        EmailRecyclerInfo current = data.get(position);

        holder.title.setText(current.title);
        holder.subject.setText(current.subject);
        holder.body.setText(current.body);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // Created my custom view holder
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subject;
        TextView body;



        // itemView will be my own custom layout View of the row
        public MyViewHolder(View itemView) {
            super(itemView);

            //Link the objects
            title = (TextView) itemView.findViewById(R.id.emailTitleText);
            subject = (TextView) itemView.findViewById(R.id.emailSubjectText);
            body = (TextView) itemView.findViewById(R.id.emailBodyText);

        }
    }
}
