package data;

public abstract class Movement {
    private int x;
    private int y;
    private boolean isOnMap = false;

    public Movement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setIsOnMap(boolean isOnMap) {
        this.isOnMap = isOnMap;
    }

    public boolean getIsOnMap() {
        return isOnMap;
    }
}
