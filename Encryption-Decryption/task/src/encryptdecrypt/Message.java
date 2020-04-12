package encryptdecrypt;

import java.io.*;
import java.util.Map;

/**
 * @author Dionysios Stolis 4/10/2020 <dstolis@b-open.com>
 */
abstract class Message {

    private Map props;

    public Message(Map props) {
        this.props = props;
    }

    abstract String encrypt(String message);

    abstract String decrypt(String message);

    void get(){
        try {
            if (props.containsKey("in")) {
                FileInputStream file = new FileInputStream(props.get("in").toString());
                props.put("data", readFile(file));
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    void send(String message){
        if(props.containsKey("out")){
            writeFile(props.get("out").toString(), message);
        }else {
            System.out.println(message);
        }
    }

    private static String readFile(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    private static void writeFile(String filename, String data){
        try(FileOutputStream out = new FileOutputStream(filename)) {
            byte[] bytes = data.getBytes();
            out.write(bytes);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
