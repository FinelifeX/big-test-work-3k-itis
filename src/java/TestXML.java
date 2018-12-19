import java.io.*;

public class TestXML {
    public static void main(String[] args) throws IOException {

        File xml = new File("D:\\IdeaProjects\\big-test-work-3k-itis\\src\\java\\settings.xml");

        Reader reader = new FileReader(xml);
        BufferedReader bufferedReader = new BufferedReader(reader);

        StringBuilder builder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            builder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        String result = builder.toString();
        System.out.println(result);
    }
}
