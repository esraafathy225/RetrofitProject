package com.esraa.hp.retrofitproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button button;
    ListView listView;
    ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn);
        listView=findViewById(R.id.list);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit=new Retrofit.Builder().baseUrl("https://pastebin.com/raw/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                RetrofitService retrofitService=retrofit.create(RetrofitService.class);
                retrofitService.getPosts().enqueue(new Callback<ArrayList<Post>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                        try {
                            posts=response.body();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        UserAdapter adapter=new UserAdapter(MainActivity.this,posts);
                        listView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                    }
                });
            }
        });
    }


}
