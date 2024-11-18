package appli.todolistjx;

import appli.todolistjx.repository.UtilisateurRepository;
import javafx.scene.control.Label;

package appli.accueil;

import appli.SceneController;
import appli.model.repository.RepositoryUser;
import appli.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    private TextField mail_insert;
    @FXML
    private PasswordField mdp_insert;
    @FXML
    private TextField name_insert;
    @FXML
    private TextField firstname_insert;
    @FXML
    private PasswordField mdp_confirm_insert;


    @FXML
    public void register(ActionEvent event) throws SQLException, IOException {

        if (!mdp_insert.getText().equals(mdp_confirm_insert.getText())) {
            showAlert("Erreur", "Les mots de passe ne correspondent pas.", AlertType.ERROR);
            return;
        }


        int successRegister = RepositoryUser.register(mail_insert.getText(), mdp_insert.getText(),
                name_insert.getText(), firstname_insert.getText(), mdp_confirm_insert.getText());


        if (successRegister == 0) {
            showAlert("Erreur", "L'inscription a échoué. Veuillez réessayer.", AlertType.ERROR);
        } else {

            User user = RepositoryUser.login(mail_insert.getText(), mdp_insert.getText());
            RepositoryUser.userConnected = user;

            if (successRegister == 1) {
                SceneController scene = new SceneController();
                scene.switchView("home-view.fxml", event);
            }
        }
    }


    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
