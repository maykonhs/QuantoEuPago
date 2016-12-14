package quantoeupago.com.quantoeupago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ResultadoActivity extends AppCompatActivity {

    ListView lvResultado;

    public void quantoEuPago(int qtd, double valorTotal) {
        double valorPorPessoa = valorTotal / qtd;
        double[] valores = new double[qtd];

        for (int i=0; i<qtd; i++) {
            valores[i] = valorPorPessoa * (i+1);
        }
        geraLista(valores);
        return ;
    }

    public void geraLista(double[] valores) {
        String[] valoresLista = new String[valores.length];
        for (int i=0; i<valores.length; i++) {
            valoresLista[i] = String.valueOf(valores[i]);
        }
        ArrayAdapter<String> valuesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, valoresLista);
        lvResultado.setAdapter(valuesAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        lvResultado = (ListView) findViewById(R.id.lvresultado);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        double valorTotal = bundle.getDouble("ValorTotal");
        int quantidadeDePessoas = bundle.getInt("Quantidade");

        quantoEuPago(quantidadeDePessoas, valorTotal);


    }
}
