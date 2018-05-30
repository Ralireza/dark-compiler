package ir.mrbug.darkcompiler;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;

import ir.mrbug.darkcompiler.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Bezet on 06/04/2017.
 */

public class AppController extends Application {




    @Override
    public void onCreate() {
        super.onCreate();


        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/pxl.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }




}
