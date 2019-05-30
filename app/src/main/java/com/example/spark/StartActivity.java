package com.example.spark;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("139.59.65.145:9090").
                addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        SparkAPICLient sparkAPICLient = retrofit.create(SparkAPICLient.class);
        Call<APIServer> call = sparkAPICLient.serverStatus();

        call.enqueue(new Callback<APIServer>() {
            @Override
            public void onResponse(Call<APIServer> call, Response<APIServer> response) {
                APIServer res = response.body();

                Toast.makeText(StartActivity.this,res.getServer_name(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<APIServer> call, Throwable t) {

                Toast.makeText(StartActivity.this,"error : (",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        addFragment();
    }

    private void addFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.add(R.id.framelayout_start_id,loginFragment);
        fragmentTransaction.commit();
    }
}
