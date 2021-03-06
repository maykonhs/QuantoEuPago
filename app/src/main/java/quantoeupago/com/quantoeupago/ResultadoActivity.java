package quantoeupago.com.quantoeupago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ResultadoActivity extends AppCompatActivity {

    ListView lvResultado;
    ListaCustomizadaAdapter adapter;

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

        geraListaIndividual(valoresLista);
    }

    public void geraListaIndividual(String[] listaDeValores) {
        List<String> listaValor = new ArrayList<>();
        List<String> listaPosicao = new ArrayList<>();

        for (int i=0; i<listaDeValores.length; i++) {
            listaValor.add("R$ " + listaDeValores[i]);

            if (i>=1) {
                listaPosicao.add((i+1) + " Pessoas");
            } else {
                listaPosicao.add((i+1) + " Pessoa");
            }

            ListaCustomizadaAdapter adapter = new ListaCustomizadaAdapter(this, listaValor, listaPosicao);
            lvResultado.setAdapter(adapter);
        }


        return;
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
