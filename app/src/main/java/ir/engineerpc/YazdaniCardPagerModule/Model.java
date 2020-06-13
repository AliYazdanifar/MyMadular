package ir.engineerpc.YazdaniCardPagerModule;

public class Model {
    private int image;
    private String title;
    private String descr;

    public Model(int image, String title, String descr) {
        this.image = image;
        this.title = title;
        this.descr = descr;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescr() {
        return descr;
    }

}
