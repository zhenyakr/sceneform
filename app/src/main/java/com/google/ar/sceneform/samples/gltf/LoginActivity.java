package com.google.ar.sceneform.samples.gltf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.cirLoginButton).setOnClickListener(this);
        /*ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);
        stub.setLayoutResource(R.layout.layout_login);
        View inflated = stub.inflate();
*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cirLoginButton:
                Intent intent = new Intent(this, ModelsActivity.class);
                startActivity(intent);
                break;
            case R.id.textView2:
                break;

        }
    }
}