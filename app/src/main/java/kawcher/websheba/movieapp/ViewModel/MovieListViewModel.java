package kawcher.websheba.movieapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import kawcher.websheba.movieapp.Service.Model.Result;
import kawcher.websheba.movieapp.Service.Repository.MovieRepository;

public class MovieListViewModel extends AndroidViewModel {

    private MovieRepository mRepo;
    public MovieListViewModel(@NonNull Application application) {
        super(application);
        mRepo=MovieRepository.getInstance(application);
    }

    public LiveData<List<Result>>getTopRatedMovieList()
    {
        return mRepo.getMovieList();
    }
}
