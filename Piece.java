/**
 * Lớp trừu tượng đại diện cho một quân cờ trên bàn cờ vua.
 * Mỗi quân cờ có tọa độ (x, y) và màu sắc ("white" hoặc "black").
 */
public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Tạo quân cờ màu trắng tại vị trí (x, y).
     * @param x tọa độ X (cột)
     * @param y tọa độ Y (hàng)
     */
    public Piece(int x, int y) {
        this(x, y, "white");
    }

    /**
     * Tạo quân cờ với màu chỉ định tại vị trí (x, y).
     * @param x tọa độ X
     * @param y tọa độ Y
     * @param color màu quân cờ ("white" hoặc "black")
     */
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    /**
     * Lấy tọa độ X hiện tại của quân cờ.
     * @return giá trị X
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * Cập nhật tọa độ X của quân cờ.
     * @param x giá trị X mới
     */
    public void setCoordinatesX(int x) {
        this.coordinatesX = x;
    }

    /**
     * Lấy tọa độ Y hiện tại của quân cờ.
     * @return giá trị Y
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * Cập nhật tọa độ Y của quân cờ.
     * @param y giá trị Y mới
     */
    public void setCoordinatesY(int y) {
        this.coordinatesY = y;
    }

    /**
     * Lấy màu của quân cờ.
     * @return "white" hoặc "black"
     */
    public String getColor() {
        return color;
    }

    /**
     * Cập nhật màu quân cờ nếu hợp lệ.
     * @param color màu mới ("white" hoặc "black")
     */
    public void setColor(String color) {
        if (color.equals("black") || color.equals("white")) {
            this.color = color;
        }
    }

    /**
     * Kiểm tra xem vị trí hiện tại của quân cờ có nằm trong bàn cờ không.
     * @return true nếu tọa độ nằm trong phạm vi 1–8, ngược lại false
     */
    public boolean checkPosition() {
        return coordinatesX >= 1 && coordinatesX <= 8 && coordinatesY >= 1 && coordinatesY <= 8;
    }

    /**
     * Trả về ký hiệu đại diện cho quân cờ (ví dụ: "R" cho Xe).
     * @return ký hiệu quân cờ
     */
    public abstract String getSymbol();

    /**
     * Kiểm tra xem quân cờ có thể di chuyển đến vị trí (x, y) trên bàn cờ hay không.
     * @param board bàn cờ hiện tại
     * @param x tọa độ X đích
     * @param y tọa độ Y đích
     * @return true nếu nước đi hợp lệ, ngược lại false
     */
    public abstract boolean canMove(Board board, int x, int y);
}
