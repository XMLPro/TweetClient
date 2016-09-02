package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.*;

//test get oauth
public class getAcTokenTest {
    static final String CONSUMER_KEY = "x5vM9P12NEMUqC2EdLAN0dFTV";
    static final String CONSUMER_KEY_SECRET = "81bKJP0PUsRH46DBpW7cHjLmMqyhbEqwp8nDX4T2qiFInphPEM";

    @FXML
    Button test;

    //create request token and post
    @FXML
    public void getAccessToken(ActionEvent event) throws Exception{
        //再利用可スレッドセーフらしい
        Twitter twitter = TwitterFactory.getSingleton();
        //consumer key setting
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

        //create requestToken
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken  = null;

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        while (null == accessToken){
            //Verifier
            String pin = br.readLine();

            try {
                if (pin.length() > 0){
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                }else {
                    accessToken = twitter.getOAuthAccessToken();
                }
            }catch (TwitterException te){
                if(401 == te.getStatusCode()){
                    System.out.println("Unable to get the access token.");
                }else {
                    te.printStackTrace();
                }
            }
        }
        File keyFile = new File("keyFile.txt");
        keyFile.createNewFile();
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(keyFile)));
        pr.println(accessToken.getToken());
        pr.println(accessToken.getTokenSecret());


    }
}
