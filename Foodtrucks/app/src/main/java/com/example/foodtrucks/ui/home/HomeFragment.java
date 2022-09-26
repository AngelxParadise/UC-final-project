package com.example.foodtrucks.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtrucks.ItemAdapter;
import com.example.foodtrucks.MainActivity;
import com.example.foodtrucks.MainActivity2;
import com.example.foodtrucks.R;
import com.example.foodtrucks.databinding.FragmentHomeBinding;
import com.example.foodtrucks.foodtrucks;
import com.example.foodtrucks.ui.logout.LogoutFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    ArrayList<foodtrucks> foodtruckslist = new ArrayList<>();

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://foodtruckslist-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textViewtitle1;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //HOME ItemAdapter for all trucks
        RecyclerView recycler = binding.Recycler1;
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(manager);

        ItemAdapter adapter = new ItemAdapter(foodtruckslist, getContext());
        recycler.setAdapter(adapter);

        final Query mytrucklist = dbRef.child("Foodtrucklist");
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

        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }

}