package pwm.penna.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import java.util.ArrayList;

import pwm.penna.R;
import pwm.penna.model.sale.SalaGiochi;
import pwm.penna.model.sale.SalaGiochiJSONDAOImpl;
import pwm.penna.util.AsyncReq;

public class SaleGiochiActivity extends ListActivity implements AsyncActivity {
    private static final String TAG = "SaleGiochiActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ((TextView) findViewById(R.id.title)).setText(R.string.salegiochi);
    }

    @Override
    public void onResume() {
        super.onResume();

        AsyncReq.executeEndpoint(this, "SaleGiochi");
    }

    @Override
    public void setResult(JSONObject jsonObject) {
        SalaGiochiJSONDAOImpl saleJSON = new SalaGiochiJSONDAOImpl();
        ArrayList<SalaGiochi> sale = saleJSON.getSale(jsonObject);

        setListAdapter(new ArrayAdapter<>(this, R.layout.item_view, R.id.textView, sale));

        getListView().setOnItemClickListener((parent, view, position, id) -> {
            SalaGiochi s = (SalaGiochi) parent.getItemAtPosition(position);
            // splitto dopo il / perchè la stringa è tipo [1] RegCal Club / Via Universita, 25 - Reggio Calabria (89000)
            String indirizzo = s.toString().split(" / ")[1];

            Uri uri = Uri.parse("http://maps.google.com/maps?q=" + indirizzo);
            Intent mapsIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(mapsIntent);
        });
    }
}