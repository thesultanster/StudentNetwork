package com.example.sultan.elitestudent;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


// the <> contains my custom viewholder; MyViewHolder, and this class will return MyViewHolder as well
public class ChatRecyclerAdapter extends RecyclerView.Adapter<ChatRecyclerAdapter.MyViewHolder> {

    // emptyList takes care of null pointer exception
    List<ChatRecyclerInfo> data = Collections.emptyList();
    LayoutInflater inflator;

    public ChatRecyclerAdapter(Context context, List<ChatRecyclerInfo> data) {
        inflator = LayoutInflater.from(context);
        this.data = data;
    }

    // Called when the recycler view needs to create a new row
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflator.inflate(R.layout.chat_custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    // Setting up the data for each row
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // This gives us current information list object
        ChatRecyclerInfo current = data.get(position);

        holder.imageId.setImageResource(current.imageId);
        holder.name.setText(current.name);
        holder.message.setText(current.message);
        holder.major.setText(current.major);
        holder.color.setBackgroundColor(Color.parseColor(current.color));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // Created my custom view holder
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name ;
        TextView major;
        TextView message;
        View color ;
        ImageView imageId ;


        // itemView will be my own custom layout View of the row
        public MyViewHolder(View itemView) {
            super(itemView);

            //Link the objects
            name = (TextView) itemView.findViewById(R.id.chatNameText);
            major = (TextView) itemView.findViewById(R.id.chatMajorText);
            message = (TextView) itemView.findViewById(R.id.chatMessageText);
            color = itemView.findViewById(R.id.chatColorBar);
            imageId = (ImageView) itemView.findViewById(R.id.profileImage);

        }
    }
}
