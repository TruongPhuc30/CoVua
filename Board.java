import java.util.ArrayList;

/**
 * Lớp đại diện cho bàn cờ vua 8x8.
 * Quản lý các quân cờ và cung cấp các phương thức thao tác trên bàn cờ.
 */
public class Board {
    /** Chiều rộng bàn cờ (số cột) */
    public static final int WIDTH = 8;

    /** Chiều cao bàn cờ (số hàng) */
    public static final int HEIGHT = 8;

    /** Danh sách các quân cờ đang có trên bàn */
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Kiểm tra xem tọa độ (x, y) có nằm trong phạm vi bàn cờ không.
     * @param x tọa độ X (cột)
     * @param y tọa độ Y (hàng)
     * @return true nếu hợp lệ, false nếu nằm ngoài bàn cờ
     */
    public boolean validate(int x, int y) {
        return x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT;
    }

    /**
     * Thêm quân cờ vào bàn nếu vị trí hợp lệ và chưa có quân nào tại đó.
     * @param piece quân cờ cần thêm
     */
    public void addPiece(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();
        if (validate(x, y) && getAt(x, y) == null) {
            pieces.add(piece);
        }
    }

    /**
     * Trả về quân cờ tại vị trí (x, y), hoặc null nếu không có quân nào.
     * @param x tọa độ X
     * @param y tọa độ Y
     * @return quân cờ tại vị trí hoặc null
     */
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
                return p;
            }
        }
        return null;
    }

    /**
     * Xóa quân cờ tại vị trí (x, y) nếu có.
     * @param x tọa độ X
     * @param y tọa độ Y
     */
    public void removeAt(int x, int y) {
        pieces.removeIf(p -> p.getCoordinatesX() == x && p.getCoordinatesY() == y);
    }

    /**
     * In trạng thái bàn cờ ra màn hình console.
     * Quân trắng được in bằng chữ hoa, quân đen bằng chữ thường.
     * Các ô trống được hiển thị bằng dấu chấm (.).
     */
    public void printBoard() {
        System.out.println("  A B C D E F G H");
        for (int y = HEIGHT; y >= 1; y--) {
            System.out.print(y + " ");
            for (int x = 1; x <= WIDTH; x++) {
                Piece p = getAt(x, y);
                if (p == null) {
                    System.out.print(". ");
                } else {
                    String symbol = p.getSymbol();
                    if (p.getColor().equals("black")) {
                        symbol = symbol.toLowerCase(); // quân đen: chữ thường
                    }
                    System.out.print(symbol + " ");
                }
            }
            System.out.println();
        }
    }
}
