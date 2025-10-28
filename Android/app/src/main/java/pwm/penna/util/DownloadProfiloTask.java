package pwm.penna.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.InputStream;

import pwm.penna.R;

public class DownloadProfiloTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView imageView;
    private Activity activity;

    public DownloadProfiloTask(Activity activity, ImageView imageView) {
        this.activity = activity;
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String imageUrl = activity.getString(R.string.profilo) + params[0] + ".jpg";
        Bitmap bitmap = null;
        try {
            InputStream inputStream = new java.net.URL(imageUrl).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(result);
                }
            });
        }
    }
}
