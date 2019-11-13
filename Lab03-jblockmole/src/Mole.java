
public class Mole {
    private Graphics g = new Graphics(30,50,10);
    private int skyLevel = 20;
    private int grassHeight = 1;
    private int soilLevel = skyLevel + grassHeight;

    public static void main(String[] args) {
        Mole m = new Mole();
        m.drawWorld();
        m.dig();
    }

    public void drawWorld() {
        //g.square();
        //g.block(2, 5, Colors.MOLE);
        g.rectangle(0, 0, g.getWidth(), skyLevel, Colors.SKY);
        g.rectangle(0, skyLevel, g.getWidth(), skyLevel + grassHeight, Colors.GRASS);
        g.rectangle(0, soilLevel, g.getWidth(), g.getHeight() - skyLevel - grassHeight, Colors.SOIL);
    }

    public void dig() {
        int x = g.getWidth() / 2; // Börja från mitten
        int y = g.getHeight() / 2;
        while (true) {
            g.block(x, y, Colors.MOLE);
            char key = g.waitForKey();

            if (y >= soilLevel) {
                g.block(x, y, Colors.TUNNEL);
            }
            else {
                g.block(x, y, Colors.GRASS);
            }

            switch (key) {
                case 'w': y -= 1; break;
                case 's': y += 1; break;
                case 'a': x -= 1; break;
                case 'd': x += 1; break;
            }

            // Begränsa till skärmen och ytan av jorden
            x = MathUtils.clamp(x, 0, g.getWidth() - 1);
            y = MathUtils.clamp(y,  soilLevel - 1, g.getHeight() - 1);
        }
    }

}
