package encryptdecrypt;
import java.util.Map;

/**
 * @author Dionysios Stolis 4/12/2020 <dstolis@b-open.com>
 */
class MessageProvider extends MessageFactory {

    @Override
    Message set(Map props) {
        switch (props.get("alg").toString()){
            case "shift":
                return new Alphabetic(props);
            case "unicode":
                return new Unicode(props);
            default:
                return new NoService(props);
        }
    }
}
