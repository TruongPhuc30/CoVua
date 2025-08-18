/**
 * Lớp đại diện cho quân Xe trong trò chơi cờ vua.
 * Quân Xe có thể di chuyển theo chiều ngang hoặc dọc nếu không bị chặn.
 */
public class Rook extends Piece {

    /**
     * Tạo quân Xe màu trắng tại vị trí (x, y).
     * @param x tọa độ X
     * @param y tọa độ Y
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * Tạo quân Xe với màu chỉ định tại vị trí (x, y).
     * @param x tọa độ X
     * @param y tọa độ Y
     * @param color màu quân cờ ("white" hoặc "black")
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * Trả về ký hiệu đại diện cho quân Xe.
     * @return chuỗi "R"
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Kiểm tra xem quân Xe có thể di chuyển đến vị trí (x, y) hay không.
     * Quân Xe chỉ được đi thẳng hàng hoặc thẳng cột, không bị chặn bởi quân khác.
     * Có thể ăn quân khác màu tại ô đích.
     *
     * @param board bàn cờ hiện tại
     * @param x tọa độ X đích
     * @param y tọa độ Y đích
     * @return true nếu nước đi hợp lệ, ngược lại false
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        int currentX = getCoordinatesX();
        int currentY = getCoordinatesY();

        // Kiểm tra tọa độ hợp lệ
        if (!board.validate(x, y)) {
            return false;
        }

        // Không đi cùng hàng hoặc cùng cột thì không hợp lệ
        if (currentX != x && currentY != y) {
            return false;
        }

        // Kiểm tra đường đi có bị chặn không
        if (currentX == x) {
            // Di chuyển theo chiều dọc
            int step = (y > currentY) ? 1 : -1;
            for (int i = currentY + step; i != y; i += step) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
        } else {
            // Di chuyển theo chiều ngang
            int step = (x > currentX) ? 1 : -1;
            for (int i = currentX + step; i != x; i += step) {
                if (board.getAt(i, currentY) != null) {
                    return false;
                }
            }
        }

        // Kiểm tra ô đích: nếu là ô trống hoặc có quân khác màu
        Piece destinationPiece = board.getAt(x, y);
        return destinationPiece == null || !destinationPiece.getColor().equals(this.getColor());
    }
}
