public class Tool {
    private String type,name,fileType1,fileType2;

    public Tool(String type, String name, String fileType1, String fileType2) {
        this.type = type;
        this.name = name;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
    }

    String getType() {
        return type;
    }

    String getName() {
        return name;
    }

    String getFileType1() {
        return fileType1;
    }

    String getFileType2() {
        return fileType2;
    }
}
