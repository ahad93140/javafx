package appli.todolistjx;

import appli.todolistjx.repository.UtilisateurRepository;
import javafx.scene.control.Label;

private class InscriptionController {

    private UtilisateurRepository utilisateurRepository;
    private Label labelErreur;

    public InscriptionController(UtilisateurRepository utilisateurRepository, Label labelErreur) {
        this.utilisateurRepository = utilisateurRepository;
        this.labelErreur = labelErreur;
    }

    public void inscrireUtilisateur(String nom, String prenom, String email, String motDePasse, String motDePasseConfirmation) {
        if (isEmpty(nom) || isEmpty(prenom) || isEmpty(email) || isEmpty(motDePasse) || isEmpty(motDePasseConfirmation)) {
            labelErreur.setText("Tous les champs doivent être remplis !");
            return;
        }

        if (!motDePasse.equals(motDePasseConfirmation)) {
            labelErreur.setText("Erreur, les mots de passe ne coïncident pas !");
            return;
        }

        Utilisateur utilisateur = new Utilisateur(nom, prenom, email, motDePasse);
        boolean inscrit = utilisateurRepository.inscription(utilisateur);

        if (inscrit) {
            labelErreur.setText("Utilisateur bien ajouté !");
        } else {
            labelErreur.setText("Erreur lors de l'ajout !");
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
