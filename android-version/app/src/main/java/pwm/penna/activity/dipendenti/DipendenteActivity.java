package pwm.penna.activity.dipendenti;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pwm.penna.R;
import pwm.penna.model.dipendenti.pojo.Cassiere;
import pwm.penna.model.dipendenti.pojo.Dipendente;
import pwm.penna.model.dipendenti.pojo.Dirigente;
import pwm.penna.model.dipendenti.pojo.Tecnico;
import pwm.penna.util.DownloadProfiloTask;

public class DipendenteActivity extends AppCompatActivity {
    public static final String TAG = "DipendenteActivity";
    private static Dipendente dipendente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dipendente);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dipendente = (Dipendente) getIntent().getSerializableExtra(TAG);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();

        ((TextView) findViewById(R.id.dipendente)).setText(dipendente.getProfilo().getNome() + " " + dipendente.getProfilo().getCognome());

        new DownloadProfiloTask(this, findViewById(R.id.profilo)).execute(dipendente.getProfilo().getEmail());

        ((TextView) findViewById(R.id.idDipendente)).setText(getString(R.string.idDipendente) + " #" + dipendente.getIdDipendente());

        ((TextView) findViewById(R.id.email)).setText(getString(R.string.email) + ": " + dipendente.getProfilo().getEmail());

        ((TextView) findViewById(R.id.salario)).setText(getString(R.string.salario) + ": " + dipendente.getSalario());
        ((TextView) findViewById(R.id.inizioTurno)).setText(getString(R.string.inizioTurno) + ": " + dipendente.getInizioTurno());
        ((TextView) findViewById(R.id.fineTurno)).setText(getString(R.string.fineTurno) + ": " + dipendente.getFineTurno());

        if(dipendente instanceof Dirigente) {
            findViewById(R.id.dirigente).setVisibility(View.VISIBLE);

            Dirigente d = (Dirigente) dipendente;

            ((TextView) findViewById(R.id.esperienza)).setText(getString(R.string.esperienza) + ": " + d.getEsperienza() + getString(R.string.anni));
            ((TextView) findViewById(R.id.periodo)).setText(getString(R.string.periodo) + ": " + d.getPeriodo() + getString(R.string.anni));

            ListView listView = findViewById(R.id.sale);
            listView.setAdapter(new ArrayAdapter<>(this, R.layout.item_view, R.id.textView, d.getSale()));
        } else if(dipendente instanceof Cassiere) {
            findViewById(R.id.cassiere).setVisibility(View.VISIBLE);

            Cassiere c = (Cassiere) dipendente;

            ((TextView) findViewById(R.id.salaGiochi)).setText(getString(R.string.salaGiochi) + ": " + c.getSalaGiochi().getNome());
            ((TextView) findViewById(R.id.sportello)).setText(getString(R.string.sportello) + ": " + c.getSportello());
        }  else if(dipendente instanceof Tecnico) {
            findViewById(R.id.tecnico).setVisibility(View.VISIBLE);

            Tecnico t = (Tecnico) dipendente;

            ((TextView) findViewById(R.id.specializzazione)).setText(getString(R.string.specializzazione) + ": " + t.getSpecializzazione());
        }
    }
}