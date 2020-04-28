package com.decagon.test;

import com.decagon.test.dto.PagedResponse;
import com.decagon.test.dto.User;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;

/**
 * This implementation assumes small sample size, will definitely change for a larger sample (i.e more authors)
 */
public class ArticlesSolution {

    UsersService usersService;
    int totalPages = Integer.MAX_VALUE;

    public ArticlesSolution() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonmock.hackerrank.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        usersService = retrofit.create(UsersService.class);
    }

    /**
     * Retrieves the names of the most active authors according to a set threshold.
     * I defined most active to be by the total submitted articles, could be replaced with any other definition.
     */
    public List<String> getUsernames(int threshold) throws IOException {
        List<String> usernames = getAllUsers().stream().sorted(comparingInt(User::getSubmitted).reversed())
            .limit(threshold)
            .map(user -> user.getUsername())
            .collect(Collectors.toList());

        return usernames;
    }

    /**
     * Retrieves the the name of the author with the highest comment count.
     */
    public String getUsernameWithHighestCommentCount() throws IOException {
        Optional<User> user = getAllUsers().stream().max(comparingInt(User::getCommentCount));
        return user.isPresent() ? user.get().getUsername() : null;
    }

    /**
     * Retrieves usernames of authors sorted by when their record was created according to a set threshold.
     */
    public List<String> getUsernamesSortedByRecordDate(int threshold) throws IOException {
        List<String> usernames = getAllUsers().stream().sorted(comparingLong(User::getCreatedAt))
            .limit(threshold)
            .map(user -> user.getUsername())
            .collect(Collectors.toList());

        return usernames;
    }

    private List<User> getAllUsers() throws IOException {
        int page = 1;
        List<User> users = new ArrayList<>();

        while (page <= totalPages) {
            users.addAll(getUsers(page));
            page++;
        }

        return users;
    }

    private List<User> getUsers(int page) throws IOException {
        Call<PagedResponse> callSync = usersService.getArticleUsers(page);
        Response<PagedResponse> response = callSync.execute();
        if (response.isSuccessful()) {
            PagedResponse pagedResponse = response.body();
            totalPages = pagedResponse.getTotalPages();
            return pagedResponse.getUsers();
        }

        return Collections.emptyList();
    }


}
