package encryptdecrypt;

import encryptdecrypt.Message;

import java.util.Map;

/**
 * @author Dionysios Stolis 4/12/2020 <dstolis@b-open.com>
 */
class Alphabetic extends Message {

    private int key;

    Alphabetic (Map props){
        super(props);
        this.key = props.containsKey("key") ? Integer.parseInt(props.get("key").toString()) : 0;
    }

    @Override
    String encrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ' && character != '\n') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    String decrypt(String message) {
        StringBuilder result = new StringBuilder();
        int offset = 26 - (key % 26);
        for (char character : message.toCharArray()) {
            if (character != ' ' && character != '\n') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
