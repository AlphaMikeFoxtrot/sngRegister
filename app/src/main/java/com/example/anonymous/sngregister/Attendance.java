package com.example.anonymous.sngregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Attendance extends AppCompatActivity {

    ListView list;
    ArrayList<Item> cub = new ArrayList<>();
    Adapter cubAdapter;

    private RequestQueue requestQueue;
    private String url = "https://mobile-pages.000webhostapp.com/getMembers.php";
    private StringRequest request;
    JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        list = (ListView) findViewById(R.id.list);
        cubAdapter = new Adapter(getApplicationContext(), 0, cub);

        addMember();

        list.setAdapter(cubAdapter);

    }
    void addMember(){

        request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray jsonArray = jsonObj.getJSONArray("result");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject c = jsonArray.getJSONObject(i);

                                String name = c.getString("name");
                                String status = c.getString("status");

                                cubAdapter.add(new Item(name,status));

                                cubAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

        };

    }
}
