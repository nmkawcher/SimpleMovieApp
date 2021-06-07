package kawcher.websheba.movieapp.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import kawcher.websheba.movieapp.Service.Model.MainResponse;
import kawcher.websheba.movieapp.Service.Model.Result;
import kawcher.websheba.movieapp.Service.Network.ApiService;
import kawcher.websheba.movieapp.Service.Network.RetrofitInstance;
import kawcher.websheba.movieapp.ViewModel.MovieListViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static Context Mcontext;
    private static MovieRepository instance;
    private MainResponse movieModel;
    private List<Result>mResult;
    private MutableLiveData mLiveData;

    public static MovieRepository getInstance(Context context){

        if(instance==null){
            Mcontext=context;
            instance=new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Result>>getMovieList(){

        if(mLiveData==null){
            mLiveData=new MutableLiveData();
        }

        ApiService apiService= RetrofitInstance.getInstance().create(ApiService.class);

       Call<MainResponse> call=apiService.getMovieList();

        call.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {


                movieModel=response.body();
                mResult=movieModel.getResults();
                mLiveData.postValue(mResult);
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {

            }
        });

        return mLiveData;
    }

}
