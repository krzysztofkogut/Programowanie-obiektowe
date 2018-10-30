package cryptographer;

public interface Algorithm {
    public abstract String crypt(String in);
    public abstract String decrypt(String in);
}