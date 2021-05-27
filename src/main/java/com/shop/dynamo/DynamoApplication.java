package com.shop.dynamo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "com.shop.dynamo.repo")
public class DynamoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamoApplication.class, args);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB(@Value("${aws.access-key}") String accessKey,
                                         @Value("${aws.secret-key}") String secretKey,
                                         @Value("${aws.dynamodb.endpoint}") String endpoint) {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, "us-east-1"))
                .build();
    }
}
