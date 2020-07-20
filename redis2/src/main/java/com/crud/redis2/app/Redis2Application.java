package com.crud.redis2.app;

import com.crud.redis2.model.Address;
import com.crud.redis2.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Redis2Application {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplate() {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:8080/redis/crud/";

	public static void main(String[] args) {
	    SpringApplication.run(Redis2Application.class, args);

        useRestTemp();
	}

    private static void useRestTemp() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        //getSingleUser(requestEntity);

        //getMultipleUsers(requestEntity);

        User u1 = new User("Srishti", "Gupta", new Address("456", "Karol Bagh", "New Delhi", "Delhi", 1238), new Address("437", "Punjabi Bagh", "New Delhi", "Delhi", 1362));
        requestEntity = new HttpEntity<>(u1, headers);
        addSingleUser(requestEntity);

        //List<User> newUsers = new ArrayList<>();
        //User u2 = new User("Rishab", "Mohindroo", new Address("3075", "Sector 15", "Gurugram", "Haryana", 2121), new Address("26", "Cyber Hub", "Gurugram", "Haryana", 2095));
        //User u3 = new User("Rimjhim", "Vaish", new Address("64C", "Rani Bagh", "New Delhi", "Delhi", 1590), new Address("45", "CP", "New Delhi", "Delhi", 1475));
        //User u4 = new User("Savita", "Sangwan", new Address("40D", "Dwarka", "New Delhi", "Delhi", 1980), new Address("594", "Punjabi Bagh", "New Delhi", "Delhi", 1343));
        //newUsers.add(u2);
        //newUsers.add(u3);
        //newUsers.add(u4);
        //requestEntity = new HttpEntity<>(newUsers, headers);
        //addMultipleUsers(requestEntity);

        //User u1 = new User("5f0b6f152762b83ce710567c", "Srishti", "Gupta", new Address("456", "Karol Bagh", "New Delhi", "Delhi", 1238), new Address("437", "Punjabi Bagh", "New Delhi", "Delhi", 1362));
        //requestEntity = new HttpEntity<>(u1, headers);
        //updateUser(requestEntity);

        //requestEntity = new HttpEntity<>(headers);
        //deleteUser(requestEntity);

    }

    private static void addSingleUser(HttpEntity<Object> requestEntity) {

        ResponseEntity<String> responseEntity = restTemplate.exchange( baseUrl + "addUser",
                HttpMethod.POST,
                requestEntity,
                String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("Status Code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("Response Body - " + userDetails);

    }

    private static void addMultipleUsers(HttpEntity<Object> requestEntity) {

        ResponseEntity<String> responseEntity = restTemplate.exchange( baseUrl + "addBulkUsers",
                HttpMethod.POST,
                requestEntity,
                String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("Status Code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("Response Body - " + userDetails);

    }

    private static void getSingleUser(HttpEntity<Object> requestEntity) {

        ResponseEntity<String> responseEntity = restTemplate.exchange( baseUrl + "findUser/5efbab6a27d3825179946452",
                HttpMethod.GET,
                requestEntity,
                String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("Status Code - " + statusCode);
        String user = responseEntity.getBody();
        System.out.println("Response Body - " + user);

    }

    private static void getMultipleUsers(HttpEntity<Object> requestEntity) {

        ResponseEntity<String> responseEntity = restTemplate.exchange( baseUrl + "findAllUsers",
                HttpMethod.GET,
                requestEntity,
                String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("Status Code - " + statusCode);
        String user = responseEntity.getBody();
        System.out.println("Response Body - " + user);

    }

    private static void updateUser(HttpEntity<Object> requestEntity) {

        ResponseEntity<String> responseEntity = restTemplate.exchange( baseUrl + "updateUser",
                HttpMethod.PUT,
                requestEntity,
                String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("Status Code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("Response Body - " + userDetails);

    }

    private static void deleteUser(HttpEntity<Object> requestEntity) {

        ResponseEntity<String> responseEntity = restTemplate.exchange( baseUrl + "deleteUser/5f0b79540a2f47324c553c66",
                HttpMethod.DELETE,
                requestEntity,
                String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("Status Code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("Response Body - " + userDetails);

    }

}
