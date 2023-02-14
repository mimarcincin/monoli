package sk.mmarcincin.monoli.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sk.mmarcincin.monoli.R;
import sk.mmarcincin.monoli.interfaces.NovenaOnClickListener;
import sk.mmarcincin.monoli.models.Novena;

public class NovenasAdapter extends RecyclerView.Adapter<NovenasAdapter.NovenasViewHolder> {
    private ArrayList<Novena> localDataSet ;
    private Context context;

    private NovenaOnClickListener novenaOnClickListener;

    public NovenasAdapter(ArrayList<Novena> localDataSet, Context context, NovenaOnClickListener novenaOnClickListener) {
        this.localDataSet = localDataSet;
        this.context = context;
        this.novenaOnClickListener = novenaOnClickListener;
    }

    public static class NovenasViewHolder extends RecyclerView.ViewHolder{
            private final TextView textView;
            private final View itemView;
            public NovenasViewHolder(@NonNull View view) {
                super(view);
                textView = (TextView) view.findViewById(R.id.textView);
                this.itemView = view;
            }

            public TextView getTextView() {
                return textView;
            }
        }

    @NonNull
    @Override
    public NovenasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.text_row_item, parent, false);

        return new NovenasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NovenasViewHolder holder, int position) {
        holder.textView.setText(localDataSet.get(holder.getAdapterPosition()).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novenaOnClickListener.onNovenaClick(localDataSet.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

}
