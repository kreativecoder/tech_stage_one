package com.decagon.test;

import com.decagon.test.dto.PagedResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersService {
    @GET("api/article_users/search")
    Call<PagedResponse> getArticleUsers(@Query("page") int page);
}
