package com.example.firematch;

import android.os.Bundle;

import com.example.zakatapp3.Adapters.MessagesRecyclerAdapter;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MessagesActivity extends AppCompatActivity {
    ArrayList<MessageModel> messageArrayList = new ArrayList<>();


    public MessagesActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        messageArrayList.add(new MessageModel("Alex Marchall", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Norma Wilson", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Morris Murphy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Kylie Lane", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Ted Stewart", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));
        messageArrayList.add(new MessageModel("Wade Mccoy", "Hello, we have a meeting at..."));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        MessagesRecyclerAdapter adapter = new MessagesRecyclerAdapter(messageArrayList);
        recyclerView.setAdapter(adapter);



    }
}
