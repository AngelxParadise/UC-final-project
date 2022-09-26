package com.example.foodtrucks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsActivity2 extends AppCompatActivity {

    ArrayList<foodtrucks> foodtruckslist = new ArrayList<>();

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://foodtruckslist-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("cuisinetype");

        RecyclerView recycler = findViewById(R.id.Recycler3);
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);

        ItemAdapter3 adapter = new ItemAdapter3(foodtruckslist, this);
        recycler.setAdapter(adapter);

        final Query mytrucklist = dbRef.child("Foodtrucklist").orderByChild("truckcuisinetype").equalTo(name);
        mytrucklist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot a :snapshot.getChildren()) {
                    foodtrucks truckslist = a.getValue(foodtrucks.class);
                    foodtruckslist.add(truckslist);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}