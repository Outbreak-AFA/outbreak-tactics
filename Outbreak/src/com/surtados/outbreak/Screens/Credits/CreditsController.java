package com.surtados.outbreak.Screens.Credits;

import com.surtados.outbreak.components.DevBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CreditsController {

    @FXML
    DevBox mandy, felipe, antonio;
    Hyperlink gitAntonio = new Hyperlink("https://github.com/DhellionFena"), gitMandy = new Hyperlink("https://github.com/AmandaRigaud"), gitFelipe = new Hyperlink("https://github.com/feliper2002");

    public static void openWebpage(String url) throws IOException {
        try {
            URI uri = new URI(url);
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    @FXML private void onLinkClick(MouseEvent event) throws IOException{

        if (event.getSource() == mandy) {
            openWebpage(gitMandy.getText());
        }
        if (event.getSource() == antonio) {
            openWebpage(gitAntonio.getText());
        }
        if (event.getSource() == felipe) {
            openWebpage(gitFelipe.getText());
        }
    }
}
