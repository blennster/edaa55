import se.lth.cs.pt.window.SimpleWindow;
import java.awt.*;

public class Graphics {
    private SimpleWindow w;
    private int height, width, blockSize;
    public int getHeight() { return height; }
    public int getWidth() { return width; }

    public Graphics(int w, int h, int bs) {
       this.height = h;
       this.width = w;
       this.blockSize = bs;
       this.w = new SimpleWindow(w * bs, h * bs, "Digging");
    }

    public void square() {
        w.moveTo(10, 10);
        w.lineTo(10, 20);
        w.lineTo(20, 20);
        w.lineTo(20, 10);
        w.lineTo(10, 10);
    }

    // Ett block kommer ritas. Antal linjer: bs
    public void block (int x, int y, Color c) {
        w.setLineColor(c);
        int left = x * blockSize;
        int right = left + blockSize - 1;
        int top = y * blockSize;
        int bottom = top + blockSize - 1;
        for (int row = top; row <= bottom; row++) {
            w.moveTo(left, row);
            w.lineTo(right, row);
        }
    }

    public void rectangle(int x, int y, int w, int h, Color c) {
        for(int yy = y; yy < y + h; yy++) {
            for(int xx = x; xx < x + w; xx++) {
                block(xx, yy, c);
            }
        }
    }

    public char waitForKey() {
        return w.waitForKey();
    }
}
