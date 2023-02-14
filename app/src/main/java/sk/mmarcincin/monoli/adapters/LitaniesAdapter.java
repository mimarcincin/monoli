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
import sk.mmarcincin.monoli.interfaces.LitanyOnClickListener;
import sk.mmarcincin.monoli.models.Litany;

public class LitaniesAdapter extends RecyclerView.Adapter<LitaniesAdapter.LitaniesViewHolder> {
    private ArrayList<Litany> localDataSet;
    private Context context;
    private LitanyOnClickListener litanyOnClickListener;
    public LitaniesAdapter(ArrayList<Litany> localDataSet, Context context, LitanyOnClickListener litanyOnClickListener) {
        this.localDataSet = localDataSet;
        this.context = context;
        this.litanyOnClickListener = litanyOnClickListener;
    }

    @NonNull
    @Override
    public LitaniesAdapter.LitaniesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.text_row_item, parent, false);

        return new LitaniesAdapter.LitaniesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LitaniesAdapter.LitaniesViewHolder holder, int position) {
        holder.textView.setText(localDataSet.get(holder.getAdapterPosition()).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                litanyOnClickListener.onLitanyClick(localDataSet.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class LitaniesViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final View itemView;
        public LitaniesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            this.itemView = itemView;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
