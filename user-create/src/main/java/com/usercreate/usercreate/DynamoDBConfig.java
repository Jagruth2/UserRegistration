package com.usercreate.usercreate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.usercreate.usercreate.model.Customer;

@Configuration
public class DynamoDBConfig {

    @Value("AKIAIEW3H45MMTT54FXQ")
    private String awsAccessKey;

    @Value("KVBQDziwJ2g7f8N1RngOqnnpwmqeVkyhbp9vbpe1")
    private String awsSecretKey;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
                .withRegion(Regions.US_EAST_1).build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT);
        init(dynamoDBMapper, client);
        return dynamoDBMapper;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    }

    public void init(DynamoDBMapper dynamoDBMapper, AmazonDynamoDB client) {

        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Customer.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

        if (TableUtils.createTableIfNotExists(client, tableRequest)) {
            System.out.println("Table created");
        }

    }

}
