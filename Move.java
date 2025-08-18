/**
 * Lớp đại diện cho một nước đi trong trò chơi cờ vua.
 * Lưu thông tin quân cờ đã di chuyển, vị trí bắt đầu, kết thúc và quân bị ăn (nếu có).
 */
public class Move {
    private Piece movedPiece;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece killedPiece;

    /**
     * Constructor không có quân bị ăn.
     * @param startX tọa độ X ban đầu
     * @param startY tọa độ Y ban đầu
     * @param endX tọa độ X đích
     * @param endY tọa độ Y đích
     * @param movedPiece quân cờ đã di chuyển
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece) {
        this(startX, startY, endX, endY, movedPiece, null);
    }

    /**
     * Constructor có thể bao gồm quân bị ăn.
     * @param startX tọa độ X ban đầu
     * @param startY tọa độ Y ban đầu
     * @param endX tọa độ X đích
     * @param endY tọa độ Y đích
     * @param movedPiece quân cờ đã di chuyển
     * @param killedPiece quân cờ bị ăn (nếu có)
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * Trả về mô tả nước đi theo ký hiệu đại số.
     * Ví dụ: "white-Ra7" nghĩa là quân Xe trắng đi đến ô a7.
     * @return chuỗi mô tả nước đi
     */
    @Override
    public String toString() {
        char column = (char) ('a' + endX - 1);
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + column + endY;
    }
}
