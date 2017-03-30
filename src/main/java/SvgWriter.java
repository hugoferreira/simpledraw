import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class SvgWriter extends PrintWriter {
    public SvgWriter(Writer out) throws IOException {
        super(out);
        writeHeader();
    }

    private void writeHeader() throws IOException {
        String header = "<?xml version=\"1.0\"?>\n" +
        "\n" +
        "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.0//EN\"\n" +
        "              \"http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd\">\n" +
        "\n" +
        "<svg xmlns=\"http://www.w3.org/2000/svg\">\n" +
        "\n";

        out.write(header);
    }

    void print(Shape s) throws IOException {
        out.write(s.toSvg());
    }

    @Override
    public void close()  {
        try {
            out.write("\n</svg>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.close();
    }
}
