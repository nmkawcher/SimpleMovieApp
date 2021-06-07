package kawcher.websheba.movieapp.Service.Network;

import android.graphics.Movie;

import kawcher.websheba.movieapp.Service.Model.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/3/movie/top_rated?api_key=8418cc336877c4cd56567a9971b184ac")
    Call<MainResponse> getMovieList();
}
