package encryptdecrypt;


import java.util.HashMap;

public class Main {
    private static final String ERROR_MESSAGE = "Error";
    public static void main(String... args) {
        try {
            HashMap props = appendArguments(args);
            new MessageProvider().build(props);
        }catch (Exception e){
            System.out.println("Error");
        }

    }

    static HashMap appendArguments(String... args){
        HashMap<String, String> arguments = new HashMap<>();
        for (int i = 0; i < args.length-1; i+=2) {
            switch (args[i]) {
                case "-mode":
                    arguments.put("mode",args[i + 1]);
                    break;
                case "-key":
                    arguments.put("key", args[i + 1]);
                    break;
                case "-data":
                    arguments.put("data", args[i + 1]);
                    break;
                case "-in":
                    arguments.put("in", args[i + 1]);
                    break;
                case "-out":
                    arguments.put("out", args[i + 1]);
                    break;
                case "-alg":
                    arguments.put("alg", args[i +1]);
                    break;
                default:
                    System.out.println(ERROR_MESSAGE);
                    break;
            }
        }

        if(!arguments.containsKey("mode")){
            arguments.put("mode", "enc");
        }
        if(!arguments.containsKey("data") && arguments.containsKey("in")){
           arguments.put("data", "");
        }
        if(!arguments.containsKey("alg"))
            arguments.put("alg","shift");
        return arguments;
    }

}
