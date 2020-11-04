package com.example.topstargithubrepos_javaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        final ArrayList<Model> GithubRepos=new ArrayList<>();
        //String url = "https://api.github.com/search/repositories?q=stars:%3E=100000";


          Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api=retrofit.create(API.class);

        Call<Model> call=api.getMyData();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model podaci=response.body();

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                t.printStackTrace();
            }
        });


        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Items demo1 = new Items("https://github.com/mgolem00.png", "TestRepo1", "mgolem00", 100);
        Items demo2 = new Items("https://github.com/jzelic00.png", "TestRepo2", "jzelic00", 200);
        ArrayList<Items> arrayList = new ArrayList<Items>();
        arrayList.add(demo1);
        arrayList.add(demo2);



        final RecyclerView.Adapter adapter = new MyAdapter(arrayList);
        recyclerView.setAdapter(adapter);


        /*JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                try {

                    JSONArray jsonArray = response.getJSONArray("items");
                    Log.d("a", "poruka");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        Model test = gson.fromJson(String.valueOf(jsonObject), Model.class);
                        GithubRepos.add(test);

                    }
                    Log.d("jeee", "evo");
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("Prvi error", "lose");
                }
            }
            }, error -> {
                error.printStackTrace();
                Log.d("Zadnji error", error.getMessage());
        }
        );*/
    }
}

