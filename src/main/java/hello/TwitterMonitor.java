package hello;


import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwitterMonitor {

    public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("KQaKxb5Cs08GA2iTNva0P22tm")
                .setOAuthConsumerSecret("is0QLjpocfHzUAvTXyLZpqeWqCCuZwCuV2YqwilW4TgLXBDA8j")
                .setOAuthAccessToken("962234033244696577-DyYWAKXt46IMt8dmWJ9yC6luTUASiAP")
                .setOAuthAccessTokenSecret("oyooFMdr1oTVb9I2aZZ9E9bahB6YMBCHVc0dnMNj7t3LK");
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        StatusListener listener = new StatusListener() {


            @Override
            public void onException(Exception e) {

            }

            @Override
            public void onStatus(Status status) {
                String content = status.getText();
                System.out.println(content +"\n");

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int i) {

            }

            @Override
            public void onScrubGeo(long l, long l1) {

            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {

            }
        };
        FilterQuery fq = new FilterQuery();

        String keywords[] = {"#ireland"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);
        while (true);

    }

}
