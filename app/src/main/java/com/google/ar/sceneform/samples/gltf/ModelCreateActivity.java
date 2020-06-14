package com.google.ar.sceneform.samples.gltf;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;


public class ModelCreateActivity extends AppCompatActivity {

    Uri uri;
    ImageView imageView;
    EditText editTextTitle;
    EditText editTextLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_create);
        Button btnAddImage = findViewById(R.id.btn_downloadImage);
        Button btnResetImage = findViewById(R.id.btn_ResetImage);
        imageView = findViewById(R.id.cropImageView);
        editTextTitle = findViewById(R.id.name_ti);

        btnResetImage.setOnClickListener(view -> {
            imageView.setImageBitmap(null);
        });
        btnAddImage.setOnClickListener(view -> {
            CropImage.startPickImageActivity(ModelCreateActivity.this);
        });
        String title = editTextTitle.getText().toString();
        Button buttonSave = findViewById(R.id.save_new_model_btn);
        buttonSave.setOnClickListener(view -> {
            //Model.modelArrayList().add(new Model(title, R.drawable.tigr));
            this.finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Uri imageuri = CropImage.getPickImageResultUri(this, data);
            if (CropImage.isReadExternalStoragePermissionsRequired(this,imageuri)){
                uri = imageuri;
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            }else {startCrop(imageuri);}
        }

        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
                imageView.setImageURI(result.getUri());
                Toast.makeText(this, "Image Update Successfully!", Toast.LENGTH_SHORT).show();

        }
    }

    private void startCrop(Uri imageuri){
        CropImage.activity(imageuri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMultiTouchEnabled(true)
                .start(this);
    }
}