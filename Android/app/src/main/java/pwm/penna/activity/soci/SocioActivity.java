package pwm.penna.activity.soci;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pwm.penna.R;
import pwm.penna.model.soci.Socio;
import pwm.penna.util.DownloadProfiloTask;

public class SocioActivity extends AppCompatActivity {
    public static final String TAG = "SocioActivity";
    private static Socio socio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socio);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        socio = (Socio) getIntent().getSerializableExtra(TAG);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();

        ((TextView) findViewById(R.id.socio)).setText(socio.getProfilo().getNome() + " " + socio.getProfilo().getCognome());

        new DownloadProfiloTask(this, findViewById(R.id.profilo)).execute(socio.getProfilo().getEmail());

        ((TextView) findViewById(R.id.numeroCliente)).setText(getString(R.string.numeroCliente) + " #" + socio.getNumeroCliente());
        ((TextView) findViewById(R.id.punteggio)).setText(getString(R.string.punteggio) + ": " + socio.getPunteggio());
        ((TextView) findViewById(R.id.membroDal)).setText(getString(R.string.membroDal) + ": " + socio.getMembroDal());
        ((TextView) findViewById(R.id.email)).setText(getString(R.string.email) + ": " + socio.getProfilo().getEmail());
    }
}