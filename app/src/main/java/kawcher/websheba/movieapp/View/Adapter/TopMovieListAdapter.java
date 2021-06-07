package kawcher.websheba.movieapp.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import kawcher.websheba.movieapp.R;
import kawcher.websheba.movieapp.Service.Model.Result;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.MyViewHolder> {

    private Context context;
    private List<Result>mList;

    public TopMovieListAdapter(Context context, List<Result> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.movie_row_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleTV.setText(mList.get(position).getTitle());
        holder.rateTV.setText(mList.get(position).getVoteAverage()+"");
       holder.dateTV.setText(mList.get(position).getReleaseDate());

       Glide.with(context).load("https://image.tmdb.org/t/p/w500"+mList.get(position).getPosterPath()).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        if(this.mList!=null){
            return mList.size();
        }else
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView movieImage;;
        private TextView titleTV,rateTV,dateTV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV=itemView.findViewById(R.id.tv_title);
            rateTV=itemView.findViewById(R.id.tv_rating);
            dateTV=itemView.findViewById(R.id.tv_release_date);

            movieImage=itemView.findViewById(R.id.image);

        }
    }
}
