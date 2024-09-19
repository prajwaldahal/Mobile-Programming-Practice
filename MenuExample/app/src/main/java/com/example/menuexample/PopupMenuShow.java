package com.example.menuexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuShow extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        btn=findViewById(R.id.btn);

        btn.setOnClickListener(v -> {

            PopupMenu popupMenu = new PopupMenu(this,btn);
            popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
            popupMenu.show();

            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(PopupMenuShow.this, "you clicked"+item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });
        });

    }
}