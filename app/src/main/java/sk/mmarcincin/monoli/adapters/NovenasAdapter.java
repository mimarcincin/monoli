package sk.mmarcincin.monoli.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sk.mmarcincin.monoli.R;

public class NovenasAdapter extends RecyclerView.Adapter<NovenasAdapter.NovenasViewHolder> {
    private ArrayList<String> localDataSet ;
    private Context context;

    public NovenasAdapter(ArrayList<String> localDataSet, Context context) {
        this.localDataSet = localDataSet;
        this.context = context;
    }

    public static class NovenasViewHolder extends RecyclerView.ViewHolder{
            private final TextView textView;

            public NovenasViewHolder(@NonNull View view) {
                super(view);
                textView = (TextView) view.findViewById(R.id.textView);
            }

            public TextView getTextView() {
                return textView;
            }
        }

    @NonNull
    @Override
    public NovenasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //localDataSet = new String[]{"novena1", "novena2", "novena3"};
        View view = LayoutInflater.from(context)
                .inflate(R.layout.text_row_item, parent, false);

        return new NovenasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NovenasViewHolder holder, int position) {
        //localDataSet = new String[]{"novena1", "novena2", "novena3"};
        holder.textView.setText(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

}
