//package za.ac.cput.vehicledealership.controller;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import za.ac.cput.vehicledealership.domain.Post;
//import za.ac.cput.vehicledealership.domain.WatchListPost;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class WatchListPostControllerTest {
//
//    private final String BASE_URL = "http://localhost:8080/watchListPost";
//
//    @Test
//    @Order(2)
//    void read() {
//        String url = BASE_URL + "/read/" + watchListPost.getWatchListPostId();
//        System.out.println("URL: " + url);
//        ResponseEntity<WatchListPost> getResponse = restTemplate.getForEntity(url, WatchListPostPost.class);
//        WatchListPost readWatchListPost = getResponse.getBody();
//        assertEquals(watchListPost.getWatchListPostId(), readPost.getWatchListPostId());
//
//        System.out.println("Read: " + readWatchListPost);
//    }
//    @Test
//    @Order(3)
//    void update() {
//        String url = BASE_URL + "/update";
//
//
//        Post updatePost = new WatchListPost.Builder()
//                .copy(watchListPost)
//                .setDescription("Car is in terrible condition. Behind on license")
//                .build();
//
//        System.out.println("URL: " + url);
//        System.out.println("POST data: " + updatePost);
//        ResponseEntity<Post> response = restTemplate.postForEntity(url, updatePost, Post.class);
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//        String url = BASE_URL + "/delete/" + watchListPost.getWatchListPostid();
//        System.out.println("URL: " + url);
//        restTemplate.delete(url);
//
//    }
//
//    @Test
//    @Order(4)
//    void getAll() {
//        String url = BASE_URL + "/all";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println("Show all");
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//
//}