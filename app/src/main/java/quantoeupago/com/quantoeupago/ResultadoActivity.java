package quantoeupago.com.quantoeupago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ResultadoActivity extends AppCompatActivity {

    ListView lvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        lvResultado = (ListView) findViewById(R.id.lvresultado);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            int valorTotal = bundle.getInt("ValorTotal");
            int quantidadeDePessoas = bundle.getInt("Quantidade");
        }

    }
}
