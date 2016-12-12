package quantoeupago.com.quantoeupago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etValorTotal;
    EditText etQuantidadeDePessoas;
    Button btQuantoEuPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValorTotal = (EditText) findViewById(R.id.etvalortotal);
        etQuantidadeDePessoas = (EditText) findViewById(R.id.etqtddepessoas);
        btQuantoEuPago = (Button) findViewById(R.id.btquantoeupago);

    }
}
