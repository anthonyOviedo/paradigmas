// Succ.java (caso recursivo)
public final class Succ implements Nat {
    private final Nat predecessor;

    public Succ(Nat predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public Nat succ() {
        return new Succ(this);
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public Nat add(Nat other) {
        return new Succ(predecessor.add(other));
    }

    @Override
    public int toInt() {
        return 1 + predecessor.toInt();
    }

    @Override
    public String toString() {
        return Integer.toString(toInt());
    }
}
