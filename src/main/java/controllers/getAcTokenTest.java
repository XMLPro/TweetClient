package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//test get oauth
public class getAcTokenTest{
    static final String CONSUMER_KEY = "x5vM9P12NEMUqC2EdLAN0dFTV";
    static final String CONSUMER_KEY_SECRET = "81bKJP0PUsRH46DBpW7cHjLmMqyhbEqwp8nDX4T2qiFInphPEM";

    @FXML
    Button test;

    //create request token and post
    @FXML
    public void getAccessToken() throws TwitterException, IOException {
        //モーダルウィンドウの生成
        Stage verifierBox = new Stage();
        verifierBox.initModality(Modality.APPLICATION_MODAL);






        //再利用可スレッドセーフらしい
        Twitter twitter = TwitterFactory.getSingleton();
        //consumer key setting
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

        //create requestToken
        RequestToken requestToken = twitter.getOAuthRequestToken();
        System.out.println(requestToken);
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

/*
        twitter.updateStatus("test");
        File keyFile = new File("keyFile.txt");
        keyFile.createNewFile();
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("keyFile.txt")));
        pr.println(accessToken.getToken());
        pr.println(accessToken.getTokenSecret());
*/

    }



}
