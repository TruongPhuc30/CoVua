/**
 * Lớp Bishop đại diện cho quân Tượng trong trò chơi cờ vua.
 * Quân Tượng di chuyển theo đường chéo và không thể nhảy qua quân khác.
 */
public class Bishop extends Piece {

    /**
     * Khởi tạo một quân Tượng với tọa độ ban đầu.
     *
     * @param x Tọa độ X ban đầu.
     * @param y Tọa độ Y ban đầu.
     */
    public Bishop(int x, int y) {
        super(x, y);
    }

    /**
     * Khởi tạo một quân Tượng với tọa độ ban đầu và màu sắc.
     *
     * @param x     Tọa độ X ban đầu.
     * @param y     Tọa độ Y ban đầu.
     * @param color Màu sắc của quân cờ ("white" hoặc "black").
     */
    public Bishop(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * Trả về ký hiệu đại diện cho quân Tượng.
     *
     * @return Chuỗi ký hiệu "B".
     */
    @Override
    public String getSymbol() {
        return "B";
    }

    /**
     * Kiểm tra xem quân Tượng có thể di chuyển đến vị trí (x, y) trên bàn cờ hay không.
     * Quân Tượng chỉ có thể di chuyển theo đường chéo và không được vượt qua quân cờ khác.
     *
     * @param board Bàn cờ hiện tại.
     * @param x     Tọa độ X đích.
     * @param y     Tọa độ Y đích.
     * @return true nếu có thể di chuyển, false nếu không.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        int currentX = getCoordinatesX();
        int currentY = getCoordinatesY();

        // Kiểm tra tọa độ hợp lệ
        if (!board.validate(x, y)) {
            return false;
        }

        // Kiểm tra có phải đi chéo không
        if (Math.abs(currentX - x) != Math.abs(currentY - y)) {
            return false;
        }

        // Kiểm tra đường đi có bị chặn không
        int stepX = (x > currentX) ? 1 : -1;
        int stepY = (y > currentY) ? 1 : -1;

        int i = currentX + stepX;
        int j = currentY + stepY;
        while (i != x && j != y) {
            if (board.getAt(i, j) != null) {
                return false;
            }
            i += stepX;
            j += stepY;
        }

        // Kiểm tra ô đích: nếu là ô trống hoặc có quân khác màu
        Piece destinationPiece = board.getAt(x, y);
        return destinationPiece == null || !destinationPiece.getColor().equals(this.getColor());
    }
}
