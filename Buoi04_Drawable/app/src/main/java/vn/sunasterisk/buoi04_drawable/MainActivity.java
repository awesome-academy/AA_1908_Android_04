package vn.sunasterisk.buoi04_drawable;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private ImageView imagePlayer;
    private ImageView imageHotGirl;

    private Button mButtonAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagePlayer = findViewById(R.id.image_player);
        imageHotGirl = findViewById(R.id.image_hot_girl);
        mButtonAnimation = findViewById(R.id.button_click_me_02);
        mButtonAnimation.setOnClickListener(this);

        AnimationDrawable animation =
                (AnimationDrawable) imagePlayer.getDrawable();
        animation.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_click_me_02:
                new AnimationAsync().execute();
                break;
            default:
                break;
        }
    }


    public class AnimationAsync extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 100; i <= 10000; i += 100) {
                publishProgress(i);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            imageHotGirl.setImageLevel(values[0]);
        }
    }

}
