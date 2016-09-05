package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by wild on 16/09/04.
 * Get Access Token
 */
public class RequestAccessToken {
    /*---------- 認証のための新しいStageの作成 ----------*/
    @FXML
    public void requestToken() throws IOException {
        //fxml path
        String fxmlPath = "../scene/getAccessToken.fxml";

        //モーダルウィンドウの生成
        Stage requestStage = new Stage();
        Parent tmpScene = FXMLLoader.load(getClass().getResource(fxmlPath));
        requestStage.setScene(new Scene(tmpScene));
        requestStage.show();
    }
}
