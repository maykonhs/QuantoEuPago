package quantoeupago.com.quantoeupago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maykon on 14/12/16.
 */
public class ListaCustomizadaAdapter extends BaseAdapter {
    private Context context;
    private List<String> valor;
    private List<String> pessoas;

    public ListaCustomizadaAdapter(Context context, List<String> valor, List<String> pessoas) {
        this.context = context;
        this.valor = valor;
        this.pessoas = pessoas;
    }

    private class ViewHolder {
        TextView textoValor;
        TextView textoPessoas;
    }

    @Override
    public int getCount() {
        return valor.size();
    }

    @Override
    public Object getItem(int position) {
        return valor.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row, parent, false);
            holder = new ViewHolder();

            holder.textoValor = (TextView) convertView.findViewById(R.id.tvvalor);
            holder.textoPessoas = (TextView) convertView.findViewById(R.id.tvpessoas);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textoValor.setText(valor.get(position));
        holder.textoPessoas.setText(pessoas.get(position));

        return convertView;
    }

}
