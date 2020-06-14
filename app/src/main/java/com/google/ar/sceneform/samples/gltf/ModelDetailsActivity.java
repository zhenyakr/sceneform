package com.google.ar.sceneform.samples.gltf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ModelDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton arBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_details);

        TextView textView = findViewById(R.id.tv_title_modelDetails);
        ImageView imageView = findViewById(R.id.main_backdrop);


        findViewById(R.id.fab_ar).setOnClickListener(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra("selected_model_title");
        int image = intent.getIntExtra("selected_model_image", R.drawable.ic_launcher_background);

        textView.setText(title);
        imageView.setImageResource(image);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_ar:
                Intent intent = new Intent(this, GltfActivity.class);
                startActivity(intent);
                break;

        }
    }
}