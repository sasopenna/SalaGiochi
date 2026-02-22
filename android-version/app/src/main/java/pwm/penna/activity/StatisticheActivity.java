package pwm.penna.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import java.util.List;

import pwm.penna.R;
import pwm.penna.model.soci.Socio;
import pwm.penna.model.statistiche.Statistiche;
import pwm.penna.model.statistiche.StatisticheJSONDAOImpl;
import pwm.penna.util.AsyncReq;

public class StatisticheActivity extends AppCompatActivity implements AsyncActivity {
    private static final String TAG = "StatisticheActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        AsyncReq.executeEndpoint(this, "Statistiche");
    }

    @Override
    public void setResult(JSONObject jsonObject) {
        StatisticheJSONDAOImpl statisticheJSON = new StatisticheJSONDAOImpl();
        Statistiche statistiche = statisticheJSON.getStatistiche(jsonObject);

        ((TextView) findViewById(R.id.donna_count)).setText(statistiche.getDonna() + "");
        ((TextView) findViewById(R.id.uomo_count)).setText(statistiche.getUomo() + "");

        ((TextView) findViewById(R.id.pc_count)).setText(statistiche.getPc() + "");
        ((TextView) findViewById(R.id.xbox_count)).setText(statistiche.getXbox() + "");
        ((TextView) findViewById(R.id.playstation_count)).setText(statistiche.getPlay() + "");

        List<Socio> array = statistiche.getTop5();
        if(array != null) {
            String[] top = new String[array.size()];
            for (int i = 0; i < top.length; i++) {
                Socio s = array.get(i);
                top[i] = (i + 1) + ". " + s.getProfilo().getNome() + " " + s.getProfilo().getCognome() + " (" + s.getPunteggio() + " Punti)";
            }
            ((ListView) findViewById(R.id.top_list)).setAdapter(new ArrayAdapter<>(this, R.layout.item_view, R.id.textView, top));
        }

        array = statistiche.getFedeli5();
        if(array != null) {
            String[] top = new String[array.size()];
            for (int i = 0; i < top.length; i++) {
                Socio s = array.get(i);
                top[i] = (i + 1) + ". " + s.getProfilo().getNome() + " " + s.getProfilo().getCognome() + " (Dal " + s.getMembroDal() + ")";
            }
            ((ListView) findViewById(R.id.fedeli_list)).setAdapter(new ArrayAdapter<>(this, R.layout.item_view, R.id.textView, top));
        }
    }
}