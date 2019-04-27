package DES;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea inputTxt;

    @FXML
    private TextField key1Txt;
    @FXML
    private TextField key2Txt;
    @FXML
    private TextField key3Txt;
    @FXML
    private TextField key4Txt;
    @FXML
    private TextField key5Txt;
    @FXML
    private TextField key6Txt;
    @FXML
    private TextField key7Txt;
    @FXML
    private TextField key8Txt;

    @FXML
    private Label cipherTxt;
    @FXML
    private Label hexCipherTxt;
    @FXML
    private Label strCipherTxt;

    @FXML
    private Label errLbl;


    public void encrypt(){
        Des des = new Des();
        String key = key1Txt.getText()
                .concat(key2Txt.getText()
                        .concat(key3Txt.getText()
                                .concat(key4Txt.getText()
                                        .concat(key5Txt.getText()
                                                .concat(key6Txt.getText()
                                                        .concat(key7Txt.getText()
                                                                .concat(key8Txt.getText())))))));
        String plain = inputTxt.getText();

        if (des.checkParity(key)){
            errLbl.setText("");
            String cipher = "";

            String hexPlain = des.strToHex(plain);

            System.out.println("hex: " + hexPlain);

            String binaryPlain = des.hexToBinary(hexPlain);

            binaryPlain = des.setData(binaryPlain);

            String[] keys = des.getKeys(key);

            System.out.println("plain: "+binaryPlain);

            for (int i = 0; i < binaryPlain.length(); i+=64) {
                String data = binaryPlain.substring(i, i+64);
                cipher += des.encrypt(data, keys);
            }

            cipherTxt.setText(cipher);
            String hexCipher = des.binaryToHex(cipher);
            hexCipherTxt.setText(hexCipher);
            strCipherTxt.setText(des.hexToStr(hexCipher));
            System.out.println("cipher "+ des.hexToStr(hexCipher));
        }else {
            errLbl.setText("WEEK KEY!");
        }
    }

    public void decrypt() {
        Des des = new Des();
        String key = key1Txt.getText()
                .concat(key2Txt.getText()
                        .concat(key3Txt.getText()
                                .concat(key4Txt.getText()
                                        .concat(key5Txt.getText()
                                                .concat(key6Txt.getText()
                                                        .concat(key7Txt.getText()
                                                                .concat(key8Txt.getText())))))));
        String cipher = inputTxt.getText();

        if (des.checkParity(key)){
            errLbl.setText("");

            String binaryCipher = des.hexToBinary(cipher);

            String plain = "";
            binaryCipher = des.setData(binaryCipher);

            String[] keys = des.getKeys(key);

            for (int i = 0; i < binaryCipher.length(); i+=64) {
                String data = binaryCipher.substring(i, i+64);
                plain += des.decrypt(data, keys);
            }

            cipherTxt.setText(plain);
            String hexPlain = des.binaryToHex(plain);
            hexCipherTxt.setText(hexPlain);
            strCipherTxt.setText(des.hexToStr(hexPlain));
            System.out.println("plain "+plain);
        }else {
            errLbl.setText("WEEK KEY!");
        }
    }
}