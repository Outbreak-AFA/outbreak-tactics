package com.surtados.outbreak.components.characterBox;

import com.surtados.outbreak.Models.Personagem;
import javafx.scene.layout.HBox;

public class CharacterBox extends HBox {

    public Personagem personagem;

    public CharacterBox() {
        setMinHeight(95);
        setMinWidth(95);
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
