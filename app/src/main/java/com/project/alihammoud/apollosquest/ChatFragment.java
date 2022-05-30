package com.project.alihammoud.apollosquest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

public class ChatFragment extends Fragment implements View.OnClickListener {

    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private Button send;
    private EditText message;
    private RecyclerView ordersList;
    private Query mQueryCurrentUser;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        // firebase
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Chat");
        mDatabase.keepSynced(true);

        ordersList = (RecyclerView) view.findViewById(R.id.recycle_view);
        ordersList.setLayoutManager(new LinearLayoutManager(getActivity()));


        send = view.findViewById(R.id.send);
        message = view.findViewById(R.id.message);

        /*Bundle bundle = this.getArguments();
        String name = bundle.getString("Name");*/

        mQueryCurrentUser = mDatabase.orderByChild("timeStamp");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatHelper userInfo = new ChatHelper();
                userInfo.setName("Connor");
                userInfo.setTimeStamp(System.currentTimeMillis());
                userInfo.setMessage(message.getText().toString().trim());
                mDatabase.child(UUID.randomUUID().toString()).setValue(userInfo);
                message.setText("");

            }
        });

        return view;
    }


    @Override
    public void onClick(View v) {

    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<ChatHelper, ListViewHolder> firebaseRecyclerAdapter = new
                FirebaseRecyclerAdapter<ChatHelper, ListViewHolder>(ChatHelper.class, R.layout.card_view_dashboard, ListViewHolder.class, mQueryCurrentUser) {

                    @Override
                    protected void populateViewHolder(ListViewHolder viewHolder, ChatHelper model, int position) {

                        final String post_key = getRef(position).getKey();

                        viewHolder.setName(model.getName());
                        viewHolder.setMessage(model.getMessage());


                    }
                };
        ordersList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        View mView;
        Button viewOrder;
        private DatabaseReference reference;
        private FirebaseAuth auth;

        public ListViewHolder(@NonNull View itemView) {

            super(itemView);
            mView = itemView;

        }
        public void setName(String title){
            TextView post_title = (TextView) mView.findViewById(R.id.name);
            post_title.setText(title);
        }
        public void setMessage(String desc){
            TextView post_title = (TextView) mView.findViewById(R.id.message);
            post_title.setText(desc);
        }


    }

}