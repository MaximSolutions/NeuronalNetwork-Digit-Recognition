package window;

public class Grid {

    public static int OFFSET_X = 50, OFFSET_Y = 50;
    public int width, height;
    public int cellWidth, cellHeight;
    public float[] grid;

    public Grid(int _width, int _height, int _cellWidth, int _cellHeight) {
        grid = new float[_width * _height];
        this.width = _width;
        this.height = _height;
        this.cellWidth = _cellWidth;
        this.cellHeight = _cellHeight;
    }


}
