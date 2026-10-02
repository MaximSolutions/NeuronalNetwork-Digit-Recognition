package window;

public class Grid {

    public static int OFFSET_X = 100, OFFSET_Y = 100;
    public int width, height;
    public int cellWidth, cellHeight;
    public int[] grid;

    public Grid(int _width, int _height, int _cellWidth, int _cellHeight) {
        this.width = _width;
        this.height = _height;
        this.cellWidth = _cellWidth;
        this.cellHeight = _cellHeight;
    }


}
