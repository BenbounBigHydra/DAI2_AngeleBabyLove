package main.world;

public class Letter extends Item {

    private String content;

    public String getContent() {
        return content;
    }

    public Letter(String desc, String letterContent) {
        super(desc);
        this.content = letterContent;
    }

}
