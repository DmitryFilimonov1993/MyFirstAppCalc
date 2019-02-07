package com.example.user.myfirstapp.helpers;

import android.app.Activity;
import android.content.*;
import android.support.annotation.NonNull;

public class IntentsHelper {

    public static void startNewActivity(Context context,
                                        @NonNull Class<? extends Activity> activityClass) {

        if (context == null)
            return;
        
        Intent intent = new Intent(context, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
