package com.surtados.outbreak.Screens.CharacterSelection;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.*;
import com.surtados.outbreak.components.characterBox.CharacterBox;
import com.surtados.outbreak.components.TeamBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CharacterSelectionController implements Initializable {

    @FXML private Button btnAvancar, btnAdicionar;
    @FXML private GridPane gridPersonagens;
    @FXML private VBox lastColumn, characterInfo;
    @FXML Button addTeamButton;
    @FXML private HBox teamList;

    @FXML private CharacterBox alice, fadinha, gosminha, troll, arqueiro, pyromancer, gengah, mrcanhao;
    ArrayList<Personagem> personagens = new ArrayList<>();
    ArrayList<Item> conq = new ArrayList<>();

    @FXML private TeamBox actualCharacterBox;

    private Player ficticio = new Player("Felipe" , "aaa", "123", 1, 1, conq);
    private Guerreira guerreiraCh = new Guerreira("Alice", 1, ficticio);
    private Fadinha opheliaCh = new Fadinha("Ophelia", 2, ficticio);
    private Arqueiro arqueiroCh = new Arqueiro("Arqueiro", 3, ficticio);
    private Gengah gengahCh = new Gengah("Gengah", 4, ficticio);
    private Gosminha gosminhaCh = new Gosminha("Gosminha", 5, ficticio);
    private MrCanhao mrCanhaoCh = new MrCanhao("Mr. Canhão", 6, ficticio);
    private Pyromancer pyromancerCh = new Pyromancer("Pyromancer", 7, ficticio);
    private Troll trollCh = new Troll("Troll", 8, ficticio);

    @FXML Label playerName = new Label(ficticio.getNome());
    @FXML Label vitorias = new Label("" + ficticio.getVitorias()), derrotas = new Label("" + ficticio.getDerrotas());

    // Função para selecionar o personagem
    @FXML private void selectCharacter(MouseEvent event) {
        resetBorder();
        if (event.getSource() == alice) {
            alice.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            showCharacterInfo(guerreiraCh);
        }
        else if (event.getSource() == fadinha) {
            fadinha.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            showCharacterInfo(opheliaCh);
        }
        else if (event.getSource() == gengah) {
            gengah.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            showCharacterInfo(gengahCh);
        }
        else if (event.getSource() == troll) {
            troll.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            showCharacterInfo(trollCh);
        }
        else if (event.getSource() == mrcanhao) {
            mrcanhao.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            showCharacterInfo(mrCanhaoCh);
        }
        else if (event.getSource() == arqueiro) {
            arqueiro.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            showCharacterInfo(arqueiroCh);
        }
        else if (event.getSource() == pyromancer) {
            pyromancer.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            showCharacterInfo(pyromancerCh);
        }
        else if (event.getSource() == gosminha) {
            gosminha.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            showCharacterInfo(gosminhaCh);
        }

    }

    @FXML private void showCharacterInfo(Personagem character) {
        ObservableList<Node> cInfo = characterInfo.getChildren();
        cInfo.clear();
        character.setTeamBox(new TeamBox(character.sprite.getPath()));
        System.out.println(character.sprite.getPath());
        characterInfo.setStyle("    -fx-alignment: center;\n" +
                "    -fx-spacing: 10;\n" +
                "    -fx-border-style: solid;\n" +
                "    -fx-border-color: rgba(248, 255, 220, 0.5);\n" +
                "    -fx-border-width: 3px;\n" +
                "    -fx-border-radius: 22px;\n" +
                "    -fx-background-radius: 22px;\n" +
                "    -fx-background-color: rgba(166, 161, 161, 0.3);\n" +
                "    -fx-padding: 20;\n");
        Label characterName = new Label("Nome: " + character.getNome() + "\nDescrição:\n");
        Label characterDescription = new Label(character.descricao());
        characterName.setTextFill(Color.rgb(255, 255, 255));
        cInfo.add(characterName);
        characterDescription.setStyle("-fx-font-family: 'Roboto', cursive; -fx-font-size: 10px; -fx-text-fill: white;");
        cInfo.add(characterDescription);
        addTeamButton.setVisible(true);
        addTeamButton.setStyle("-fx-background-color: rgb(98, 245, 113); -fx-text-fill: white; -fx-min-height: 33; -fx-min-width: 143;");
        addTeamButton.setText("ADICIONAR");
        cInfo.add(addTeamButton);
        actualCharacterBox = character.getTeamBox();
    }

    @FXML private void addCharacterTeam(MouseEvent event) {
        if (event.getSource() == addTeamButton) {
            ObservableList<Node> team = teamList.getChildren();
            if (team.size() < Sistema.limitePersonagens) {
                team.add(actualCharacterBox);
                System.out.println(team.size());
                System.out.println(Sistema.limitePersonagens);
            }
        }
    }

    @FXML private void resetBorder() {
        alice.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px;");
        gosminha.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px;");
        troll.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px;");
        pyromancer.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px;");
        fadinha.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px;");
        arqueiro.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px;");
        mrcanhao.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px;");
        gengah.setStyle("-fx-border-color: transparent; -fx-border-radius: 0px; -fx-border-width: 0px;");
    }

    // Função para remover o personagem do time
    @FXML private void removeCharacterTeam() {}

    // Função para confirmar o time e ir para a próxima página
    @FXML private void confirmTeamNextPage() {}

    @FXML private void botaoAvancarConfig() {
        btnAvancar.setDisable(true);
    }

    @FXML private void criaGridPane() {
        playerName.setText(ficticio.getNome());
        vitorias.setText(""+ficticio.getVitorias());
        derrotas.setText("" + ficticio.getDerrotas());
        gridPersonagens.getColumnConstraints().addAll(setCC(), setCC());
        gridPersonagens.getRowConstraints().addAll(setRC(), setRC(), setRC(), setRC());
    }

    private RowConstraints setRC() {
        RowConstraints rc = new RowConstraints();
        rc.setFillHeight(true);
        return rc;
    }
    private ColumnConstraints setCC() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setFillWidth(true);
        return cc;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criaGridPane();
    }
}
