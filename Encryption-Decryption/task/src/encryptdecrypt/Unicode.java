package encryptdecrypt;

import java.util.Map;

/**
 * @author Dionysios Stolis 4/12/2020
 */
class Unicode extends Message {

    private int key;
    Unicode (Map props){
        super(props);
        key = props.containsKey("key") ? Integer.parseInt(props.get("key").toString()) : 0;
    }

    @Override
    String encrypt(String message) {
        if(message.isEmpty())
            return message;
        char[] chars = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            chars[i] = (char) (message.charAt(i) + key);
        }
        return new String(chars);
    }

    @Override
    String decrypt(String message) {
        if (message.isEmpty())
            return message;
        char[] chars = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            chars[i] = (char) (message.charAt(i)-key);
        }
        return new String(chars);
    }
}
