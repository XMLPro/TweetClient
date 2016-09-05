package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by wild on 16/09/04.
 */
public class GetAccessToken implements Initializable {
    //なんか別のファイルにまとめて置くかもしれないもの
    static final String CONSUMER_KEY = "x5vM9P12NEMUqC2EdLAN0dFTV";
    static final String CONSUMER_KEY_SECRET = "81bKJP0PUsRH46DBpW7cHjLmMqyhbEqwp8nDX4T2qiFInphPEM";

    //FXML status
    @FXML
    private TextField verifier;
    @FXML
    private Hyperlink requestURL;

    @FXML
    public void getVerifier() throws URISyntaxException {
        //Application app = null;
        //app.getHostServices().showDocument("http://google.com");
        /*
        Desktop open = Desktop.getDesktop();
        String url = requestURL.getText();
        try {
            URI uri = new URI(url);
            open.browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }


    @FXML
    public void getToken() {

    }


    //create OAuth request token
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

        try {
            RequestToken requestToken = twitter.getOAuthRequestToken();
            requestURL.setText(requestToken.getAuthorizationURL());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
