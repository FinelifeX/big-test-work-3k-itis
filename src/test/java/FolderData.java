import java.util.UUID;

public class FolderData {

    private String name;

    public FolderData() {
        this.name = "Hello" + UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
