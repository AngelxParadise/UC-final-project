package com.example.foodtrucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details1);

        TextView truckname = findViewById(R.id.textViewtruckname);
        TextView truckinsta = findViewById(R.id.textViewinsta);
        TextView truckloc = findViewById(R.id.textViewloc);
        TextView truckcuis = findViewById(R.id.textViewcuis);
        ImageView truckimg = findViewById(R.id.imageViewtruckimg);

        Bundle bundle = getIntent().getExtras();

        foodtrucks sendft = (foodtrucks) bundle.getSerializable("foodtrucks");

        truckname.setText(sendft.getFoodtruckName());
        truckinsta.setText("@" + sendft.getFoodtruckInstagram());
        truckloc.setText(sendft.getFoodtruckLocation());
        truckcuis.setText(sendft.getTruckcuisinetype());

        Picasso.with(this).load(sendft.getFoodtruckImg()).into(truckimg);

        truckinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentinsta = new Intent(Intent.ACTION_VIEW);
                intentinsta.setData(Uri.parse("http://www.instagram.com/" + sendft.getFoodtruckInstagram()));
                startActivity(intentinsta);
            }
        });

    }
}