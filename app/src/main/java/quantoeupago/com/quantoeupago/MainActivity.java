package quantoeupago.com.quantoeupago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etValorTotal;
    EditText etQuantidadeDePessoas;
    Button btQuantoEuPago;

    int valorTotal = 0;
    int quantidadeDePessoas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValorTotal = (EditText) findViewById(R.id.etvalortotal);
        etQuantidadeDePessoas = (EditText) findViewById(R.id.etqtddepessoas);
        btQuantoEuPago = (Button) findViewById(R.id.btquantoeupago);

        btQuantoEuPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valorTotal = Integer.parseInt(etValorTotal.getText().toString());
                quantidadeDePessoas = Integer.parseInt(etQuantidadeDePessoas.getText().toString());

                Bundle bundle = getIntent().getExtras();

                bundle.putInt("ValorTotal", valorTotal);
                bundle.putInt("Quantidade", quantidadeDePessoas);

                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
