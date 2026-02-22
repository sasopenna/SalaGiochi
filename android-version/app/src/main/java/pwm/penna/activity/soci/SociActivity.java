package pwm.penna.activity.soci;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import java.util.ArrayList;

import pwm.penna.R;
import pwm.penna.activity.AsyncActivity;
import pwm.penna.model.soci.Socio;
import pwm.penna.model.soci.SocioJSONDAOImpl;
import pwm.penna.util.AsyncReq;

public class SociActivity extends ListActivity implements AsyncActivity {
    private static final String TAG = "SociActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ((TextView) findViewById(R.id.title)).setText(R.string.soci);
    }

    @Override
    public void onResume() {
        super.onResume();

        AsyncReq.executeEndpoint(this, "Soci");
    }

    @Override
    public void setResult(JSONObject jsonObject) {
        SocioJSONDAOImpl sociJSON = new SocioJSONDAOImpl();
        ArrayList<Socio> soci = sociJSON.getSoci(jsonObject);

        setListAdapter(new ArrayAdapter<>(this, R.layout.item_view, R.id.textView, soci));

        getListView().setOnItemClickListener((parent, view, position, id) -> {
            Socio socio = (Socio) parent.getItemAtPosition(position);

            Intent intent = new Intent(this, SocioActivity.class);
            intent.putExtra(SocioActivity.TAG, socio);
            startActivity(intent);
        });
    }
}