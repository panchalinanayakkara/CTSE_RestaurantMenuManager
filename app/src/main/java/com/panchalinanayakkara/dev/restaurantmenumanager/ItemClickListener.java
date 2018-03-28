package com.panchalinanayakkara.dev.restaurantmenumanager;

import android.view.View;

public interface ItemClickListener{

    void onClick(View view, int position, boolean isLongClick);
}
