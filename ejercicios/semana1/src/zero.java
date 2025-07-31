// Zero.java (caso base)
public final class Zero implements Nat {

    @Override
    public Nat succ() {
        return new Succ(this);
    }

    @Override
    public boolean isZero() {
        return true;
    }

    @Override
    public Nat add(Nat other) {
        return other; // 0 + n = n
    }

    @Override
    public int toInt() {
        return 0;
    }

    @Override
    public String toString() {
        return "0";
    }
}
