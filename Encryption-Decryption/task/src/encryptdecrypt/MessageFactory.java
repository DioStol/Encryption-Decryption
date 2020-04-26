package encryptdecrypt;

import java.util.Map;

/**
 * @author Dionysios Stolis 4/12/2020
 */
abstract class MessageFactory {

    abstract Message set(Map props);

    void build(Map props){
        Message message = set(props);
        if (message == null) {
            System.err.println(new NullPointerException().getMessage());
        }
        try {
            message.get();
            String response = "";
            switch (props.get("mode").toString()) {
                case "enc":
                    response = message.encrypt(props.get("data").toString());
                    break;
                case "dec":
                    response = message.decrypt(props.get("data").toString());
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            message.send(response);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
