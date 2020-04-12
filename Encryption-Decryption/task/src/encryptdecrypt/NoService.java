package encryptdecrypt;

import java.util.Map;

/**
 * @author Dionysios Stolis 4/13/2020 <dstolis@b-open.com>
 */
public class NoService extends Message {

    NoService(Map props){
        super(props);
    }

    @Override
    String encrypt(String message) {
        return "Wrong service name";
    }

    @Override
    String decrypt(String message) {
        return "Wrong service name";
    }
}
