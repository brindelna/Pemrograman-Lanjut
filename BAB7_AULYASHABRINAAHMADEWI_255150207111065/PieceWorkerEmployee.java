package Praktikum_Pemrograman_Lanjut.BAB7_AULYASHABRINAAHMADEWI_255150207111065;

public class PieceWorkerEmployee extends Employee {
    private double wagePerPiece; 
    private int pieces;          

    public PieceWorkerEmployee(String name, String noKTP, double wagePerPiece, int pieces) {
        super(name, noKTP);
        setWagePerPiece(wagePerPiece);
        setPieces(pieces);
    }

    public void setWagePerPiece(double wagePerPiece) {
        this.wagePerPiece = wagePerPiece;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public double getWagePerPiece() {
        return wagePerPiece;
    }

    public int getPieces() {
        return pieces;
    }

    @Override
    public double earnings() {
        return getPieces() * getWagePerPiece();
    }

    @Override
    public String toString() {
        return String.format(
            "Piece-worker employee: %s\nupah per barang: $%,.2f\nbanyak barang diproduksi: %d",
            super.toString(), getWagePerPiece(), getPieces()
        );
    }
}