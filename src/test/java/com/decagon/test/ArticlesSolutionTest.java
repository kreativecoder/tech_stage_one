package com.decagon.test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test assertions used to verify correctness of implementation based on sample size.
 * A better implementation of the test will be to mock returning response to be able to guarantee
 * assertions in any environment.
 */
class ArticlesSolutionTest {

    @Test
    void testGetUsernames() throws IOException {
        List<String> usernames = new ArticlesSolution().getUsernames(5);
        assertEquals(5, usernames.size());
        assertTrue(usernames.contains("olalonde"));
    }

    @Test
    void testGetUsernameWithHighestCommentCount() throws IOException {
        assertEquals("guelo", new ArticlesSolution().getUsernameWithHighestCommentCount());
    }

    @Test
    void testGetUsernamesSortedByRecordDate() throws IOException {
        List<String> usernames = new ArticlesSolution().getUsernamesSortedByRecordDate(3);
        assertEquals(3, usernames.size());
        assertTrue(usernames.contains("coloneltcb"));
    }
}