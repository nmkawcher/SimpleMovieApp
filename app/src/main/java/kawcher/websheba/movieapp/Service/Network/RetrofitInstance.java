package kawcher.websheba.movieapp.Service.Network;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static String BASE_URL="https://api.themoviedb.org/";

    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if(retrofit==null){
            retrofit=
                    new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
