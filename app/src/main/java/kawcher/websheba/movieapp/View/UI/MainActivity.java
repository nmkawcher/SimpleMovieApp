package kawcher.websheba.movieapp.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import kawcher.websheba.movieapp.R;
import kawcher.websheba.movieapp.Service.Model.MainResponse;
import kawcher.websheba.movieapp.Service.Model.Result;
import kawcher.websheba.movieapp.View.Adapter.TopMovieListAdapter;
import kawcher.websheba.movieapp.ViewModel.MovieListViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieListViewModel mViewModel;
    private TopMovieListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rv);
        mViewModel=new ViewModelProvider(this).get(MovieListViewModel.class);
        GridLayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);

        mViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                adapter=new TopMovieListAdapter(MainActivity.this,results);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}