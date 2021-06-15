package com.surtados.outbreak.Screens.CharacterSelection;

import com.surtados.outbreak.Core.Sistema;
import com.surtados.outbreak.Models.*;
import com.surtados.outbreak.components.characterBox.CharacterBox;
import com.surtados.outbreak.components.TeamBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
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

    private Guerreira guerreiraCh = new Guerreira("Alice", 1, Sistema.players.get(Sistema.rodada));
    private Fadinha opheliaCh = new Fadinha("Ophelia", 2, Sistema.players.get(Sistema.rodada));
    private Arqueiro arqueiroCh = new Arqueiro("Arqueiro", 3, Sistema.players.get(Sistema.rodada));
    private Gengah gengahCh = new Gengah("Gengah", 4, Sistema.players.get(Sistema.rodada));
    private Gosminha gosminhaCh = new Gosminha("Gosminha", 5, Sistema.players.get(Sistema.rodada));
    private MrCanhao mrCanhaoCh = new MrCanhao("Mr. Canhão", 6, Sistema.players.get(Sistema.rodada));
    private Pyromancer pyromancerCh = new Pyromancer("Pyromancer", 7, Sistema.players.get(Sistema.rodada));
    private Troll trollCh = new Troll("Troll", 8, Sistema.players.get(Sistema.rodada));
    private Personagem personagemGenerico;

    @FXML Label playerName = new Label(Sistema.players.get(Sistema.rodada).getNome());
    @FXML Label vitorias = new Label("" + Sistema.players.get(Sistema.rodada).getVitorias()), derrotas = new Label("" + Sistema.players.get(Sistema.rodada).getDerrotas());

    // Função para selecionar o personagem
    @FXML private void selectCharacter(MouseEvent event) {
        resetBorder();
        if (event.getSource() == alice) {
            alice.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            personagemGenerico = new Guerreira("Alice", 1, Sistema.players.get(Sistema.rodada));
            showCharacterInfo(guerreiraCh);
        }
        else if (event.getSource() == fadinha) {
            fadinha.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            personagemGenerico = new Fadinha("Ophelia", 2, Sistema.players.get(Sistema.rodada));
            showCharacterInfo(opheliaCh);
        }
        else if (event.getSource() == gengah) {
            gengah.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            personagemGenerico = new Gengah("Gengah", 4, Sistema.players.get(Sistema.rodada));
            showCharacterInfo(gengahCh);
        }
        else if (event.getSource() == troll) {
            troll.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            personagemGenerico = new Troll("Troll", 8, Sistema.players.get(Sistema.rodada));
            showCharacterInfo(trollCh);
        }
        else if (event.getSource() == mrcanhao) {
            mrcanhao.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            personagemGenerico = new MrCanhao("Mr. Canhão", 6, Sistema.players.get(Sistema.rodada));
            showCharacterInfo(mrCanhaoCh);
        }
        else if (event.getSource() == arqueiro) {
            arqueiro.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            personagemGenerico = new Arqueiro("Arqueiro", 3, Sistema.players.get(Sistema.rodada));
            showCharacterInfo(arqueiroCh);
        }
        else if (event.getSource() == pyromancer) {
            pyromancer.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            personagemGenerico = new Pyromancer("Pyromancer", 7, Sistema.players.get(Sistema.rodada));
            showCharacterInfo(pyromancerCh);
        }
        else if (event.getSource() == gosminha) {
            gosminha.setStyle("-fx-border-color: rgb(10, 255, 10); -fx-border-radius: 10px; -fx-border-width: 3px;");
            personagemGenerico = new Gosminha("Gosminha", 5, Sistema.players.get(Sistema.rodada));
            showCharacterInfo(gosminhaCh);
        }

    }

    @FXML private void showCharacterInfo(Personagem character) {
        actualCharacterBox = new TeamBox("");
        characterInfo.setVisible(true);
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
            ObservableList<Node> cInfo = characterInfo.getChildren();
            ObservableList<Node> team = teamList.getChildren();
            if (team.size() < Sistema.limitePersonagens) {
                actualCharacterBox.setOnMouseClicked(event1 -> {
                    removeCharacterTeam(event1);
                });
                team.add(actualCharacterBox);
                Sistema.players.get(Sistema.rodada).time.add(personagemGenerico);
                cInfo.clear();
                characterInfo.setVisible(false);
                System.out.println(team.size());
                System.out.println(Sistema.limitePersonagens);
                if (team.size() == Sistema.limitePersonagens) {
                    btnAvancar.setDisable(false);
                    btnAvancar.setStyle("-fx-background-color: rgb(234, 85, 85);");
                }
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
    @FXML private void removeCharacterTeam(MouseEvent event) {
        System.out.println("Entrei na função");
        Object selecionado = event.getSource();
        if (teamList.getChildren().contains(selecionado)) {
            System.out.println("REMOVI");
            if (teamList.getChildren().size() == Sistema.limitePersonagens) {
                btnAvancar.setDisable(true);
            }
            teamList.getChildren().remove(selecionado);
                TeamBox temp = (TeamBox) selecionado;
                for (int i=0; i<Sistema.players.get(Sistema.rodada).time.size(); i++) {
                    if (temp.background.equals(Sistema.players.get(Sistema.rodada).time.get(i).sprite.getPath())) {
                        Sistema.players.get(Sistema.rodada).time.remove(i);
                        System.out.println(Sistema.players.get(Sistema.rodada).time.size());
                        return;
                    }
                }
        }

    }

    // Função para confirmar o time e ir para a próxima página
    @FXML private void pageSelectItems(MouseEvent event) throws IOException {
        if (event.getSource() == btnAvancar) {
            Stage stage = null;
            Parent root = null;

            if (Sistema.rodada == 0) {
                Sistema.rodada++;

                stage = null;
                root = null;

                String characterSelectionCSS = getClass().getResource("../CharacterSelection/characterSelecion.css").toExternalForm();

                if(event.getSource()==btnAvancar){
                    stage = (Stage) btnAvancar.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("../CharacterSelection/characterSelection.fxml"));
                }
                Scene cena = new Scene(root);
                teamList.getChildren().clear();
                characterInfo.getChildren().clear();
                cena.getStylesheets().add(characterSelectionCSS);
                stage.setScene(cena);
                stage.show();


            } else {
                Sistema.rodada = 0;
                if (Sistema.players.get(Sistema.rodada).conquistas.size() > 0) {
                    String itemPageCSS = getClass().getResource("../ItemSelection/item.css").toExternalForm();

                    if(event.getSource()==btnAvancar){
                        stage = (Stage) btnAvancar.getScene().getWindow();
                        root = FXMLLoader.load(getClass().getResource("../ItemSelection/item.fxml"));
                    }
                    Scene cena = new Scene(root);
                    cena.getStylesheets().add(itemPageCSS);
                    stage.setScene(cena);
                    stage.show();
                } else {
                    Sistema.rodada ++;
                    String itemPageCSS = getClass().getResource("../ItemSelection/item.css").toExternalForm();

                    if(event.getSource()==btnAvancar){
                        stage = (Stage) btnAvancar.getScene().getWindow();
                        root = FXMLLoader.load(getClass().getResource("../ItemSelection/item.fxml"));
                    }
                    Scene cena = new Scene(root);
                    cena.getStylesheets().add(itemPageCSS);
                    stage.setScene(cena);
                    stage.show();

                }
            }


        }
    }

    @FXML private void criaGridPane() {
        playerName.setText(Sistema.players.get(Sistema.rodada).getNome());
        vitorias.setText(""+Sistema.players.get(Sistema.rodada).getVitorias());
        derrotas.setText("" + Sistema.players.get(Sistema.rodada).getDerrotas());
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
        btnAvancar.setDisable(true);
    }
}
