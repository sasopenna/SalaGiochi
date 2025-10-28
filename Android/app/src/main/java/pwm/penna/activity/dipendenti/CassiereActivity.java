package pwm.penna.activity.dipendenti;

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
import pwm.penna.model.dipendenti.DipendenteJSONDAOImpl;
import pwm.penna.model.dipendenti.pojo.Cassiere;
import pwm.penna.util.AsyncReq;

public class CassiereActivity extends ListActivity implements AsyncActivity {
    private static final String TAG = "CassiereActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ((TextView) findViewById(R.id.title)).setText(R.string.cassieri);
    }

    @Override
    public void onResume() {
        super.onResume();

        AsyncReq.executeEndpoint(this, "Dipendenti?q=cassieri");
    }

    @Override
    public void setResult(JSONObject jsonObject) {
        DipendenteJSONDAOImpl dipendenteJSON = new DipendenteJSONDAOImpl();
        ArrayList<Cassiere> dipendenti = dipendenteJSON.getCassieri(jsonObject);

        setListAdapter(new ArrayAdapter<>(this, R.layout.item_view, R.id.textView, dipendenti));

        getListView().setOnItemClickListener((parent, view, position, id) -> {
            Cassiere c = (Cassiere) parent.getItemAtPosition(position);

            Intent intent = new Intent(this, DipendenteActivity.class);
            intent.putExtra(DipendenteActivity.TAG, c);
            startActivity(intent);
        });
    }
}