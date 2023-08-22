package com.gluonhq.richtextarea.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Alert;

import java.util.Objects;
public class ActionCmdInsertUnicode implements ActionCmd {
    private final String codeString;

    public ActionCmdInsertUnicode(String codeString) {
        this.codeString = codeString;
    }

    @Override
    public void apply(RichTextAreaViewModel viewModel) {
        String content = "";
        if (!codeString.isEmpty()) {
            int codeNum = 0;
            if (codeString.charAt(0) == 'x') {
                //convert hex string to decimal set codeNum
                String numString = codeString.substring(1);
                try {
                    codeNum = Integer.valueOf(numString, 16);
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Entry Problem");
                    alert.setHeaderText(null);
                    alert.setContentText("I do not recognize '" + numString + "' as a representation of a hexidecimal numer.");
                    alert.showAndWait();
                }
            } else if (codeString.charAt(0) == '#') {
                //convert decimal string, set codeNum
                String numString = codeString.substring(1);
                try {
                    codeNum = Integer.valueOf(numString);
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Entry Problem");
                    alert.setHeaderText(null);
                    alert.setContentText("I do not recognize '" + numString + "' as a representation of a decimal number.");
                    alert.showAndWait();
                }
            } else {
                //popup message "character string must begin with with '#' or 'x'
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Entry Problem");
                alert.setHeaderText(null);
                alert.setContentText("Begin decimal with '#' and hexidecimal with 'x'.");
                alert.showAndWait();
            }
            if (codeNum > 1114111) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Entry Problem");
                alert.setHeaderText(null);
                alert.setContentText("'" + codeString + "' does not fall within the unicode codeNum points.");
                alert.showAndWait();
                return;
            }

            char[] chars = Character.toChars(codeNum);
            content = new String(chars);
        }

        if (viewModel.isEditable()) {
            String text;
            if (Objects.requireNonNull(viewModel).getDecorationAtParagraph() != null &&
                    viewModel.getDecorationAtParagraph().hasTableDecoration()) {
                text = content.replace("\n", "");
            } else {
                text = content;
            }
            if (!text.isEmpty()) {
                viewModel.getCommandManager().execute(new InsertCmd(text));
            }
        }
    }

    @Override
    public BooleanBinding getDisabledBinding(RichTextAreaViewModel viewModel) {
        return viewModel.editableProperty().not();
    }


}
