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
import sk.mmarcincin.monoli.models.Prayer;

public class PrayersAdapter extends RecyclerView.Adapter<PrayersAdapter.PrayersViewHolder> {
    private ArrayList<Prayer> localDataSet;
    private Context context;

    public PrayersAdapter(ArrayList<Prayer> localDataSet, Context context) {
        this.localDataSet = localDataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public PrayersAdapter.PrayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.text_row_item, parent, false);

        return new PrayersAdapter.PrayersViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PrayersAdapter.PrayersViewHolder holder, int position) {
        holder.textView.setText(localDataSet.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class PrayersViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public PrayersViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
