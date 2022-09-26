package com.example.foodtrucks.ui.cuisine;

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
import com.example.foodtrucks.ItemAdapter2;
import com.example.foodtrucks.R;
import com.example.foodtrucks.cuisines;
import com.example.foodtrucks.databinding.FragmentCuisineBinding;
import com.example.foodtrucks.foodtrucks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CuisineFragment extends Fragment {

    private FragmentCuisineBinding binding;
    ArrayList<cuisines> cuisineslist = new ArrayList<>();

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://foodtruckslist-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CuisineViewModel cuisineViewModel =
                new ViewModelProvider(this).get(CuisineViewModel.class);

        binding = FragmentCuisineBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textViewtitle4;
        cuisineViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        RecyclerView recycler = binding.Recycler2;
        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(manager);

        ItemAdapter2 adapter = new ItemAdapter2(cuisineslist, getContext());
        recycler.setAdapter(adapter);

        final Query mycuisineslist = dbRef.child("Cuisineslist");
        mycuisineslist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot a :snapshot.getChildren()) {
                    cuisines truckslist = a.getValue(cuisines.class);
                    cuisineslist.add(truckslist);
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