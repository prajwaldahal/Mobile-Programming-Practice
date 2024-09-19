package com.example.customrecyclevieweeditadd;

import android.view.View;

public interface OnQuoteClickListener {
    void onQuoteClicked(Quote quote);

    void onQuoteLongClicked(int position, View view);
}
