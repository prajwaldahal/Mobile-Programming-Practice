package com.example.customrecyclevieweeditadd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private Context context;
    private ArrayList<Quote> quotes;

    private OnQuoteClickListener onQuoteClickListener;

    private int previousPosition = -1;

    RecyclerViewAdapter(Context context, OnQuoteClickListener onQuoteClickListener, ArrayList<Quote> quotes) {
        this.context = context;
        this.quotes = quotes;
        this.onQuoteClickListener = onQuoteClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(context).inflate(R.layout.quote_item, parent, false);
        return new RecyclerViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Quote quote = quotes.get(position);

        Glide.with(context)
                .load(quote.getImage())
                .into(holder.ivImage);

        holder.tvQuote.setText(quote.getQuote());
        holder.tvAuthor.setText(quote.getAuthor());

        animateItems(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    private void animateItems(View view, int position) {
        if (position > previousPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
            view.startAnimation(animation);
            previousPosition = position;
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private CardView cvQuote;
        private ImageView ivImage;
        private TextView tvQuote, tvAuthor;

        RecyclerViewHolder(View item) {
            super(item);
            cvQuote = item.findViewById(R.id.cv_quote);
            ivImage = item.findViewById(R.id.iv_image);
            tvQuote = item.findViewById(R.id.tv_quote);
            tvAuthor = item.findViewById(R.id.tv_author);


            cvQuote.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onQuoteClickListener.onQuoteClicked(quotes.get(position));
                }
            });

            cvQuote.setOnLongClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onQuoteClickListener.onQuoteLongClicked(position, cvQuote);
                }
                return true;
            });
        }
    }
}
