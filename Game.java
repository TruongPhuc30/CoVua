import java.util.ArrayList;

/**
 * Lớp quản lý toàn bộ trò chơi cờ vua.
 * Bao gồm bàn cờ, lịch sử nước đi và logic di chuyển quân cờ.
 */
public class Game {
    /** Bàn cờ hiện tại */
    private Board board;

    /** Lịch sử các nước đi đã thực hiện */
    private ArrayList<Move> moveHistory;

    /**
     * Tạo một trò chơi mới với bàn cờ đã cho.
     * @param board bàn cờ khởi tạo
     */
    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<>();
    }

    /**
     * Lấy bàn cờ hiện tại.
     * @return đối tượng Board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Cập nhật bàn cờ mới.
     * @param board bàn cờ cần gán
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Lấy danh sách lịch sử nước đi.
     * @return danh sách các đối tượng Move
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * Di chuyển quân cờ đến vị trí mới nếu nước đi hợp lệ.
     * Nếu có quân bị ăn, sẽ xóa khỏi bàn cờ.
     * Nước đi được lưu vào lịch sử.
     *
     * @param piece quân cờ cần di chuyển
     * @param toX tọa độ X đích
     * @param toY tọa độ Y đích
     * @return true nếu di chuyển thành công, false nếu không hợp lệ
     */
    public boolean movePiece(Piece piece, int toX, int toY) {
        int fromX = piece.getCoordinatesX();
        int fromY = piece.getCoordinatesY();

        // Kiểm tra nước đi có hợp lệ không
        if (!board.validate(toX, toY) || !piece.canMove(board, toX, toY)) {
            return false;
        }

        // Kiểm tra có quân bị ăn không
        Piece captured = board.getAt(toX, toY);
        if (captured != null) {
            board.removeAt(toX, toY);
        }

        // Cập nhật vị trí quân cờ
        piece.setCoordinatesX(toX);
        piece.setCoordinatesY(toY);

        // Ghi lại nước đi
        Move move = new Move(fromX, fromY, toX, toY, piece, captured);
        moveHistory.add(move);

        return true;
    }

    /**
     * In toàn bộ lịch sử nước đi ra màn hình console.
     * Mỗi dòng hiển thị thứ tự và mô tả nước đi.
     */
    public void printHistory() {
        System.out.println("Lịch sử nước đi:");
        for (int i = 0; i < moveHistory.size(); i++) {
            System.out.println((i + 1) + ". " + moveHistory.get(i));
        }
    }
}
