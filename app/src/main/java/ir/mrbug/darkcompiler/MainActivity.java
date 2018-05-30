package ir.mrbug.darkcompiler;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.io.FileNotFoundException;
import java.util.Random;

import ir.mrbug.darkcompiler.exceptions.AnalyzerException;
import ir.mrbug.darkcompiler.lexer.Lexer;
import ir.mrbug.darkcompiler.parser.Parser;
import ir.mrbug.darkcompiler.parser.Rule;
import ir.mrbug.darkcompiler.token.Token;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {


    private Parser parser;
    private MediaPlayer mediaPlayer;
    private EditText source;
    private View btnTokenize;
    private View btnParse;
    private TextView tvTokens;
    private TextView tvSrc;
    private Lexer lexer;
    private boolean haveError = false;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initalization();
        final Random rnd = new Random();
        YoYo.with(Techniques.Flash)
                .repeat(10)
                .interpolate(new AccelerateDecelerateInterpolator())
                .duration(500)
                .playOn(tvSrc);


        btnTokenize.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                tvTokens.setTextColor(getColor(R.color.green));
                lexer = new Lexer();
                YoYo.with(Techniques.Flash)
                        .duration(400)
                        .playOn(source);
                YoYo.with(Techniques.Pulse)
                        .duration(300)
                        .playOn(btnTokenize);


                try {
                    tvTokens.setText("");

                    lexer.tokenize(source.getText().toString());
//                    parser = Parser.getObj();
//                    parser.parse(Gramer.laws
//                            , lexer.getFilteredTokens());

                    if (haveError) {
                        tvTokens.setText("");
                    }
                    for (Token token :
                            lexer.getFilteredTokens()) {
                        tvTokens.append("\"" + token.getTokenType() + "\"     :     \"" + token.getTokenString() + "\"   \n");
                        tvTokens.setTextColor(getResources().getColor(R.color.green));

                    }

//                    for (Rule rule : parser.getSequenceOfAppliedRules()) {
//                        tvTokens.append(rule.toString() + "\n");
//                    }

                } catch (AnalyzerException e) {
                    tvTokens.setText(e.getMessage());
                    tvTokens.setTextColor(Color.RED);
                    haveError = true;

                } catch (IllegalArgumentException i) {
                    tvTokens.setText(i.getMessage());
                    tvTokens.setTextColor(Color.YELLOW);
                    haveError = true;
                } catch (RuntimeException r) {
                    tvTokens.setText(r.getMessage());
                    tvTokens.setTextColor(Color.WHITE);
                    haveError = true;
                }
            }
        });


        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTokens.setTextColor(getColor(R.color.green));
                lexer = new Lexer();
                YoYo.with(Techniques.Flash)
                        .duration(400)
                        .playOn(source);
                YoYo.with(Techniques.Pulse)
                        .duration(300)
                        .playOn(btnParse);


                try {
                    tvTokens.setText("");

                    lexer.tokenize(source.getText().toString());
                    parser = Parser.getObj();
                    parser.parse(Gramer.laws
                            , lexer.getFilteredTokens());

                    if (haveError) {
                        tvTokens.setText("");
                    }
//                    for (Token token :
//                            lexer.getFilteredTokens()) {
//                        tvTokens.append("\"" + token.getTokenType() + "\"     :     \"" + token.getTokenString() + "\"   \n");
//                        tvTokens.setTextColor(getResources().getColor(R.color.green));
//
//                    }

                    for (Rule rule : parser.getSequenceOfAppliedRules()) {
                        tvTokens.append(rule.toString() + "\n");
                    }

                } catch (AnalyzerException e) {
                    tvTokens.setText(e.getMessage());
                    tvTokens.setTextColor(Color.RED);
                    haveError = true;

                } catch (IllegalArgumentException i) {
                    tvTokens.setText(i.getMessage());
                    tvTokens.setTextColor(Color.YELLOW);
                    haveError = true;
                } catch (RuntimeException r) {
                    tvTokens.setText(r.getMessage());
                    tvTokens.setTextColor(Color.WHITE);
                    haveError = true;
                }
            }
        });

    }


    private void initalization() {
        source = findViewById(R.id.source_code);
        btnTokenize = findViewById(R.id.tokenize);
        btnParse = findViewById(R.id.parse);
        tvTokens = findViewById(R.id.tv_tokens);
        tvSrc = findViewById(R.id.tv_src);
        tvTokens.setMovementMethod(new ScrollingMovementMethod());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer
                .start();
        tvTokens.setTypeface(Typeface.createFromAsset(
                getApplication().getAssets(),
                "fonts/nim.otf"));
        source.setTypeface(Typeface.createFromAsset(
                getApplication().getAssets(),
                "fonts/nim.otf"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }


}
