package br.com.collareda.business.domain.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class AmazonS3Service {
	private static final String BUCKET = "autosafeapp";
	private AWSCredentials credentials = new BasicAWSCredentials("AKIAX3EX66GWASA6FU5H",
			"hn7Rci5wCi37f6mU3rAHFOigkowJHedTWrP80/rL");

	private AmazonS3 s3client = AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.SA_EAST_1).build();

	public void putObjectAmazon(String key, InputStream is) {
		s3client.putObject(BUCKET, key, is, new ObjectMetadata());
	}
}
