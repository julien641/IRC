
package javafxchatclient;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LoginController implements Initializable {
    private Javafxchatclient client;
    private Stage stage;
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button submit;

    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("hello");
        submit.setOnAction(new LoginEvent(username, password));

    }
    public void setup(Stage stage,Javafxchatclient client){
        this.stage =stage;
        this.client =client;
    }


    private class LoginEvent implements EventHandler {

        private TextField usernamefield;
        private TextField passwordfield;


        public LoginEvent(TextField username, TextField password) {
            this.usernamefield = username;
            this.passwordfield = password;
        }

        @Override
        public void handle(Event event) {
            String username = this.usernamefield.getText();
            String password = this.passwordfield.getText();

            if (username.isEmpty() || password.isEmpty()) {
               /*
                 TODO

                */

                return;
            }
            try {
                JSONObject object = new JSONObject();
                object.put("username",username);
                object.put("password",password);
                HttpRequest request = HttpRequest.newBuilder()
                        .headers("Content-Type", "application/json;charset=UTF-8")
                        .uri(new URI("http://localhost:8080/api/signin"))
                        .POST(BodyPublishers.ofString(object.toJSONString()))
                        .build();
                HttpResponse<String> response = HttpClient.newBuilder()
                        .proxy(ProxySelector.getDefault())
                        .build()
                        .send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    JSONParser parser = new JSONParser();
                    JSONObject jsonobject = (JSONObject) parser.parse(response.body());
                    String token = jsonobject.get("token").toString();
                    String type = jsonobject.get("type").toString();
                    System.out.println(type + " " + token);
                    Javafxchatclient.setToken(token, type);
                    stage.close();
                    client.setupClient();
                }
            } catch (URISyntaxException | InterruptedException | IOException | ParseException e) {
                e.printStackTrace();
                /*
                    TODO Handle network exeptions

                   */
            }

        }
    }
}
