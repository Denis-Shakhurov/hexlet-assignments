package exercise;

// BEGIN
public class Segment {
  private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public Point getBeginPoint() {
        return point1;
    }
    public Point getEndPoint() {
        return point2;
    }
    public Point getMidPoint() {
        int xBegin = getBeginPoint().getX();
        int xEnd = getEndPoint().getX();
        int yBegin = getBeginPoint().getY();
        int yEnd = getEndPoint().getY();
        return new Point((xBegin + xEnd) / 2, (yBegin + yEnd) / 2);
    }
}
// END
