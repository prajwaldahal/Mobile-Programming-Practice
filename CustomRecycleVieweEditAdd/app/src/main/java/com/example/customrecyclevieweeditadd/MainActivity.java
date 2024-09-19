package com.example.customrecyclevieweeditadd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private RecyclerViewAdapter recyclerViewAdapter;
        private RecyclerView rvQuotes;
        private LinearLayoutManager layoutManager;
        private ArrayList<Quote> quotes;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            rvQuotes = findViewById(R.id.rv_quotes);

            layoutManager = new LinearLayoutManager(this);
            rvQuotes.setLayoutManager(layoutManager);

            quotes = generateQuotes();

            OnQuoteClickListener quoteClickListener = new OnQuoteClickListener() {
                @Override
                public void onQuoteClicked(Quote quote) {
                    Toast.makeText(MainActivity.this, "This is the quote from " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onQuoteLongClicked(int position, View item) {
                    PopupMenu popupMenu = new PopupMenu(MainActivity.this, item);
                    popupMenu.getMenuInflater().inflate(R.menu.recycler_view_context_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            int id = item.getItemId();
                            if (id == R.id.rv_edit) {
                                onEdit(position);
                            } else if (id == R.id.rv_delete) {
                                onDelete(position);
                            }

                            return true;
                        }
                    });
                    popupMenu.show();
                }
            };

            recyclerViewAdapter = new RecyclerViewAdapter(this, quoteClickListener, quotes);

            rvQuotes.setAdapter(recyclerViewAdapter);


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.recycler_view_context_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            onAdd();
            return true;
    }

    private void onAdd() {
            EditText url,author,quote;
            AppCompatButton add;
            Dialog dialog= new Dialog(this);
            dialog.setContentView(R.layout.add_quote_dialog);
            url=dialog.findViewById(R.id.url_add);
            author=dialog.findViewById(R.id.author_add);
            quote=dialog.findViewById(R.id.quote_add);

            add=dialog.findViewById(R.id.btn_add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        String urlv = url.getText().toString();
                        String quotev = quote.getText().toString();
                        String authorv = author.getText().toString();

                        if(!(urlv.isEmpty()||quotev.isEmpty()||authorv.isEmpty())){
                            Quote quote1=new Quote(quotes.size()+1,quotev,authorv,urlv);
                            quotes.add(quote1);
                            recyclerViewAdapter.notifyItemInserted(quotes.size()-1);
                            rvQuotes.scrollToPosition(quotes.size()-1);
                            dialog.dismiss();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "please fill all the fields", Toast.LENGTH_SHORT).show();
                        }
                }
            });
            dialog.show();


    }

    private ArrayList<Quote> generateQuotes() {
            ArrayList<Quote> quotes = new ArrayList<>();
            quotes.add(new Quote(1, "If user click other options rather than \"Simple Interest\", please show \"Custom Dialog\" which has message \"Coming Soon\" and \"Okay\" button. Clicking the okay button will close this dialog. Make it cancelable so that when user click on the outside dialog it will close the dialog.", "prajwal dahal", "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg"));
            quotes.add(new Quote(2, "If user click other options rather than \"Simple Interest\", please show \"Custom Dialog\" which has message \"Coming Soon\" and \"Okay\" button. Clicking the okay button will close this dialog. Make it cancelable so that when user click on the outside dialog it will close the dialog.", "prajwal dahal", "https://farm4.staticflickr.com/3852/14447103450_2d0ff8802b_z_d.jpg"));
            quotes.add(new Quote(3, "If user click other options rather than \"Simple Interest\", please show \"Custom Dialog\" which has message \"Coming Soon\" and \"Okay\" button. Clicking the okay button will close this dialog. Make it cancelable so that when user click on the outside dialog it will close the dialog.", "prajwal dahal", "https://farm2.staticflickr.com/1533/26541536141_41abe98db3_z_d.jpg"));
            quotes.add(new Quote(4, "If user click other options rather than \"Simple Interest\", please show \"Custom Dialog\" which has message \"Coming Soon\" and \"Okay\" button. Clicking the okay button will close this dialog. Make it cancelable so that when user click on the outside dialog it will close the dialog.", "prajwal dahal", "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg"));
            quotes.add(new Quote(5, "If user click other options rather than \"Simple Interest\", please show \"Custom Dialog\" which has message \"Coming Soon\" and \"Okay\" button. Clicking the okay button will close this dialog. Make it cancelable so that when user click on the outside dialog it will close the dialog.", "prajwal dahal", "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg"));
            quotes.add(new Quote(6, "If user click other options rather than \"Simple Interest\", please show \"Custom Dialog\" which has message \"Coming Soon\" and \"Okay\" button. Clicking the okay button will close this dialog. Make it cancelable so that when user click on the outside dialog it will close the dialog.", "prajwal dahal", "https://farm2.staticflickr.com/1533/26541536141_41abe98db3_z_d.jpg"));
            quotes.add(new Quote(7, "If user click other options rather than \"Simple Interest\", please show \"Custom Dialog\" which has message \"Coming Soon\" and \"Okay\" button. Clicking the okay button will close this dialog. Make it cancelable so that when user click on the outside dialog it will close the dialog.", "prajwal dahal", "https://farm2.staticflickr.com/1533/26541536141_41abe98db3_z_d.jpg"));
            quotes.add(new Quote(8, "If user click other options rather than \"Simple Interest\", please show \"Custom Dialog\" which has message \"Coming Soon\" and \"Okay\" button. Clicking the okay button will close this dialog. Make it cancelable so that when user click on the outside dialog it will close the dialog.", "prajwal dahal", "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg"));
            return quotes;
        }

        private void onEdit(int position) {
            EditText etQuote, etAuthor;
            Button btnUpdate;
            ImageView ivImage;

            Quote currentQuote = quotes.get(position);

            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.edit_quote_dialog);
            dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            etQuote = dialog.findViewById(R.id.et_quote);
            etAuthor = dialog.findViewById(R.id.et_author);
            btnUpdate = dialog.findViewById(R.id.btn_update);
            ivImage = dialog.findViewById(R.id.iv_et_image);

            etQuote.setText(currentQuote.getQuote());
            etAuthor.setText(currentQuote.getAuthor());

            Glide.with(this)
                    .load(currentQuote.getImage())
                    .into(ivImage);

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String quote, author;
                    quote = etQuote.getText().toString();
                    author = etAuthor.getText().toString();

                    if (quote.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Quotes must not be empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (author.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Author must not be empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    currentQuote.setQuote(quote);
                    currentQuote.setAuthor(author);
                    recyclerViewAdapter.notifyItemChanged(position);
                    dialog.dismiss();
                }
            });

            dialog.show();
        }

        private void onDelete(int position) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Are you sure?");
            builder.setMessage("Do you really want to delete this item?");
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    quotes.remove(position);
                    recyclerViewAdapter.notifyItemRemoved(position);
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.show();
        }

    }