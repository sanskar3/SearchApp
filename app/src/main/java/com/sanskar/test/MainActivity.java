package com.sanskar.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String Tag = "myApp";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText1);
        button = findViewById(R.id.button1);

        String message = editText.getText().toString();

        RequestQueue requestQueue;

        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.github.com/search/repositories?sort=stars&order=desc&q=java",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    Log.d(Tag, "the response is" + response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(Tag, "Something went wrong ");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


}