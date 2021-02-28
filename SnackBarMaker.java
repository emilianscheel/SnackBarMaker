package de.pocket.listview.Account;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;

import de.pocket.listview.R;

import static com.google.android.material.snackbar.Snackbar.make;

public class SnackBarMaker {




    /*
    ------------------------------------

    Content-Table:

        .get

        .setMessage
        .setHowLong

        .setBackgroundColor
        .setBackgroundColor
        .setBackgroundDrawable

        .setTextColor
        .setTextColor
        .setFontFamily

        .setIconLeftDrawable
        .setIconRightDrawable
        .setIconTopDrawable
        .setIconBottomDrawable

        .setIconPaddingDp
        .setIconPaddingPixel

        .setAction
        .setActionText

        .show

    ------------------------------------

     */




    public static final int SHORT = 2;
    public static final int NORMAL = 3;
    public static final int LONG = 4;

    private static Context mContext;

    private String message;
    private Integer howLongInSeconds = 2;

    private int backgroundColor = -1;
    private int backgroundDrawable = -1;

    private int iconLeftDrawable = 0;
    private int iconTopDrawable = 0;
    private int iconRightDrawable = 0;
    private int iconBottomDrawable = 0;
    private int iconPadding = 0;

    private int textColor = -1;

    private View.OnClickListener onClickListener;
    private String actionText;
    private int actionTextColor = -1;

    private Typeface fontFamily;









    /** INITIALIZING with get **/

    public static SnackBarMaker get(Context context) {
        mContext = context;
        return new SnackBarMaker();
    }





    /** MESSAGE **/

    public SnackBarMaker setMessage(String message) {
        this.message = message;
        return this;
    }



    /** HOW LONG **/

    public SnackBarMaker setHowLongInSeconds(Integer howLongInSeconds) {
        this.howLongInSeconds = howLongInSeconds;
        return this;
    }



    /** BACKGROUND **/

    public SnackBarMaker setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public SnackBarMaker setBackgroundColor(String hexCode) {
        this.backgroundColor = Color.parseColor(hexCode);
        return this;
    }

    public SnackBarMaker setBackgroundDrawable(int backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
        return this;
    }



    /** TEXT COLOR **/

    public SnackBarMaker setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public SnackBarMaker setTextColor(@NonNull String hexCode) {
        this.textColor = Color.parseColor(hexCode);
        return this;
    }



    /** FONT FAMILY **/

    public SnackBarMaker setFontFamily(Typeface fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }



    /** ICON DRAWABLE **/

    public SnackBarMaker setIconLeftDrawable(int iconDrawable) {
        this.iconLeftDrawable = iconDrawable;
        return this;
    }

    public SnackBarMaker setIconRightDrawable(int iconDrawable) {
        this.iconRightDrawable = iconDrawable;
        return this;
    }

    public SnackBarMaker setIconTopDrawable(int iconDrawable) {
        this.iconTopDrawable = iconDrawable;
        return this;
    }

    public SnackBarMaker setIconBottomDrawable(int iconDrawable) {
        this.iconBottomDrawable = iconDrawable;
        return this;
    }



    /** ICON PADDING **/

    public SnackBarMaker setIconPaddingDp(int iconPadding) {

        Resources r = mContext.getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                iconPadding,
                r.getDisplayMetrics()
        );

        this.iconPadding = px;
        return this;
    }

    public SnackBarMaker setIconPaddingPixel(int iconPadding) {
        this.iconPadding = iconPadding;
        return this;
    }



    /** ACTION **/

    public SnackBarMaker setAction(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }


    public SnackBarMaker setActionText(String actionText) {
        this.actionText = actionText;
        return this;
    }


    public SnackBarMaker setActionTextColor(String hexCode) {
        this.actionTextColor = Color.parseColor(hexCode);
        return this;
    }


    public SnackBarMaker setActionTextColor(int actionTextColor) {
        this.actionTextColor = actionTextColor;
        return this;
    }









    /** SHOW **/

    public void show(View contextView) {

        Snackbar snackbar = make(contextView, message, 1000 * howLongInSeconds);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);



        if (actionTextColor != -1) {
            snackbar.setActionTextColor(actionTextColor);
        } else {
            Log.e("SnackBarMaker Error", "No parameter given! at actionTextColor");
        }


        if (onClickListener != null || actionText != null) {
            snackbar.setAction(actionText, onClickListener);
        } else {
            Log.e("SnackBarMaker Error", "No parameter given! at onClickListener or actionText");
        }


        if (fontFamily != null) {
            textView.setTypeface(fontFamily);
        } else {
            Log.e("SnackBarMaker Error", "No parameter given! at fontFamily");
        }


        if (textColor != -1) {
            textView.setTextColor(textColor);
        } else {
            Log.e("SnackBarMaker Error", "No parameter given! at textColor");
        }


        if (backgroundColor != -1) {
            sbView.setBackgroundColor(backgroundColor);
        } else {
            Log.e("SnackBarMaker Error", "No parameter given! at backgroundColor");
        }


        if (backgroundDrawable != -1) {
            sbView.setBackgroundResource(backgroundDrawable);
        } else {
            Log.e("SnackBarMaker Error", "No parameter given! at backgroundDrawable");
        }


        if (iconLeftDrawable != 0 || iconTopDrawable != 0 || iconRightDrawable != 0 || iconBottomDrawable != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(iconLeftDrawable, iconTopDrawable, iconRightDrawable, iconBottomDrawable);
            textView.setCompoundDrawablePadding(iconPadding);
        } else {
            Log.e("SnackBarMaker Error", "No parameter given! at iconDrawable");
        }





        snackbar.show();
    }
}
