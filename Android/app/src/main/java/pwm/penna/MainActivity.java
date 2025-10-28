package pwm.penna;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import pwm.penna.activity.AsyncActivity;
import pwm.penna.activity.SaleGiochiActivity;
import pwm.penna.activity.StatisticheActivity;
import pwm.penna.activity.dipendenti.CassiereActivity;
import pwm.penna.activity.dipendenti.DirigenteActivity;
import pwm.penna.activity.dipendenti.TecnicoActivity;
import pwm.penna.activity.soci.SociActivity;
import pwm.penna.model.home.Home;
import pwm.penna.model.home.HomeJSONDAOImpl;
import pwm.penna.util.AsyncReq;

public class MainActivity extends AppCompatActivity implements AsyncActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.sale_button).setOnClickListener(v -> openActivity(SaleGiochiActivity.class));
        findViewById(R.id.soci_button).setOnClickListener(v -> openActivity(SociActivity.class));
        findViewById(R.id.stats_button).setOnClickListener(v -> openActivity(StatisticheActivity.class));
        findViewById(R.id.dirigenti_button).setOnClickListener(v -> openActivity(DirigenteActivity.class));
        findViewById(R.id.cassieri_button).setOnClickListener(v -> openActivity(CassiereActivity.class));
        findViewById(R.id.tecnici_button).setOnClickListener(v -> openActivity(TecnicoActivity.class));
    }

    @Override
    public void onResume() {
        super.onResume();

        AsyncReq.executeEndpoint(this, "Home");
    }

    public void openActivity(Class classe) {
        Intent intent = new Intent(this, classe);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    public void setResult(JSONObject jsonObject) {
        HomeJSONDAOImpl homeJSON = new HomeJSONDAOImpl();
        Home home = homeJSON.getHome(jsonObject);

        ((TextView) findViewById(R.id.cassieri)).setText(home.getCassieri() + "");
        ((TextView) findViewById(R.id.dipendenti)).setText(home.getDipendenti() + "");
        ((TextView) findViewById(R.id.dirigenti)).setText(home.getDirigenti() + "");
        ((TextView) findViewById(R.id.sale)).setText(home.getSale() + "");
        ((TextView) findViewById(R.id.soci)).setText(home.getSoci() + "");
        ((TextView) findViewById(R.id.tecnici)).setText(home.getTecnici() + "");
    }
}