package environ;

import com.darwinsys.bleah.GetOpt;

public class GetOptParseArgsDemo {
public static void main(String[] args) {
// BEGIN main
GetOptDesc[] options = {
    new GetOptDesc('n', "numeric", false),
    new GetOptDesc('o', "output-file", true),
};
Map optionsFound = new GetOpt(options).parseArguments(argv);
if (optionsFound.get("n") != null) {
    System.out.println("sortType = NUMERIC;")
}
String outputFile = null;
if ((outputFile = optionsFound.get("o") != null) {
    System.out.println("output file specified as " + outputFile)
} else {
    System.out.println("Output to System.out");
}
// END main
}
}
