package com.example.zakatapp3.Adapters;

import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firematch.MessageModel;
import com.example.firematch.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

public class MessagesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<MessageModel> mDataset;


    private static int TYPE_NORMAL_ITEM_GRAY = 1;
    private static int TYPE_NORMAL_ITEM = 2;


    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private View view;
        private TextView name;
        private TextView desc;
        private ConstraintLayout parentLayout;

        public MessageViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.item_name);
            desc = v.findViewById(R.id.item_desc);
        }
    }


    public MessagesRecyclerAdapter(ArrayList<MessageModel> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View view;
        if (viewType == TYPE_NORMAL_ITEM) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.messages_item, parent, false);
            MessageViewHolder viewHolder = new MessageViewHolder(view);
            return viewHolder;
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.messages_item_gray, parent, false);
            MessageViewHolder viewHolder = new MessageViewHolder(view);
            return viewHolder;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageViewHolder viewHolder = null;
        if (getItemViewType(position) == TYPE_NORMAL_ITEM || getItemViewType(position) == TYPE_NORMAL_ITEM_GRAY) {
            viewHolder = (MessageViewHolder) holder;
        }

        viewHolder.name.setText(mDataset.get(position).getName());
        viewHolder.desc.setText(mDataset.get(position).getDesc());

        MessageViewHolder finalViewHolder = viewHolder;


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_NORMAL_ITEM_GRAY;
        } else {
            return TYPE_NORMAL_ITEM;
        }
    }
}
