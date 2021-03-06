package quantoeupago.com.quantoeupago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    //Declaração das variáveis dos componentes de tela
    EditText etValorTotal;
    EditText etQuantidadeDePessoas;
    Button btQuantoEuPago;

    //declaração das variáveis
    double valorTotal;
    int quantidadeDePessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //atribuição das variáveis aos componentes de tela
        etValorTotal = (EditText) findViewById(R.id.etvalortotal);
        etQuantidadeDePessoas = (EditText) findViewById(R.id.etqtddepessoas);
        btQuantoEuPago = (Button) findViewById(R.id.btquantoeupago);

        //ação do botão "Quanto eu pago"
        btQuantoEuPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etValorTotal != null && etQuantidadeDePessoas != null) {
                    valorTotal = Double.parseDouble(etValorTotal.getText().toString());
                    quantidadeDePessoas = Integer.parseInt(etQuantidadeDePessoas.getText().toString());

                    Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

                    intent.putExtra("ValorTotal", valorTotal);
                    intent.putExtra("Quantidade", quantidadeDePessoas);

                    startActivity(intent);
                }

            }
        });

    }
}
