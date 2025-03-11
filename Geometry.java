class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) {
                // Print top and bottom borders
                for (int j = 0; j < width; j++) {
                    System.out.print("* ");
                }
            } else {
                // Print sides with spaces in between
                System.out.print("* ");
                for (int j = 0; j < width - 2; j++) {
                    System.out.print("  ");
                }
                if (width > 1) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class Geometry {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 5);
        Rectangle r2 = new Rectangle(6, 8);

        r1.draw();
        r2.draw();
    }
}
