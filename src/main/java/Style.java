public class Style {

    protected String color;

    public Style(String color) {
        this.color = color;
    }

    public Style() {
        this("white");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


}
