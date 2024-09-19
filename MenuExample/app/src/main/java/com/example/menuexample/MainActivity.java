package com.example.menuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.about_us:
                Toast.makeText(this, "you are going to about us activity....", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rate_us:
                Toast.makeText(this, "you are going to share  activity....", Toast.LENGTH_SHORT).show();
                break;

            case R.id.home:
                Toast.makeText(this, "you are going to home activity....", Toast.LENGTH_SHORT).show();
                break;

            case R.id.context_menu:
                Intent intent = new Intent(this,ContextMenu.class);
                startActivity(intent);
                break;

            case R.id.popup_menu:
                Intent intent2 = new Intent(this, PopupMenuShow.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}