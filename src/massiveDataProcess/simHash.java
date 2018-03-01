/**
 * 
 */
package massiveDataProcess;

/**
 * @author Agnostic
 * 算法思想:simhash过程如下：
1. 首先基于传统的IR方法，将文章转换为一组加权的特征值构成的向量。
2.初始化一个f维的向量V，其中每一个元素初始值为0。
3.对于文章的特征向量集中的每一个特征，做如下计算：
利用传统的hash算法映射到一个f-bit的签名。对于这个f- bit的签名，如果签名的第i位上为1，则对向量V中第i维加上这个特征的权值，否则对向量的第i维减去该特征的权值。
4.对整个特征向量集合迭代上述运算后，根据V中每一维向量的符号来确定生成的f-bit指纹的值，如果V的第i维为正数，则生成f-bit指纹的第i维为1，否则为0。
 */
import java.math.BigInteger;
import java.util.StringTokenizer;
public class simHash {
    private String tokens;//签名
    private BigInteger strSimHash;//指纹
    private int hashbits = 128;//128位的hash码
    public simHash(String tokens) {
        this.tokens = tokens;
        this.strSimHash = this.simHash();
    }
    public simHash(String tokens, int hashbits) {
        this.tokens = tokens;
        this.hashbits = hashbits;
        this.strSimHash = this.simHash();
    }
    public BigInteger simHash() {//生成指纹
        int[] v = new int[this.hashbits];
        StringTokenizer stringTokens = new StringTokenizer(this.tokens);
        while (stringTokens.hasMoreTokens()) {
            String temp = stringTokens.nextToken();
            BigInteger t = this.hash(temp);
            for (int i = 0; i < this.hashbits; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                 if (t.and(bitmask).signum() != 0) {
                    v[i] += 1;
                } else {
                    v[i] -= 1;
                }
            }
        }
        BigInteger fingerprint = new BigInteger("0");//每一位初始化位0
        for (int i = 0; i < this.hashbits; i++) {
            if (v[i] >= 0) {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
            }
        }
        return fingerprint;//
    }
    private BigInteger hash(String source) {//生成hash码
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(this.hashbits).subtract(
                    new BigInteger("1"));
            for (char item : sourceArray) {
                BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }
            return x;
        }
    }
    public int hammingDistance(simHash other) {//计算海明距离，海明权值算法
        BigInteger m = new BigInteger("1").shiftLeft(this.hashbits).subtract(
                new BigInteger("1"));
        BigInteger x = this.strSimHash.xor(other.strSimHash).and(m);
        int tot = 0;
         while (x.signum() != 0) {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }
    public static void main(String[] args) {
        String s = "This is a test string for testing";
        simHash hash1 = new simHash(s, 128);
        System.out.println(hash1.strSimHash + "  " + hash1.strSimHash.bitLength());
        s = "This is a test string for testing also";
        simHash hash2 = new simHash(s, 128);
        System.out.println(hash2.strSimHash+ "  " + hash2.strSimHash.bitCount());
        s = "This is a test string for testing als";
        simHash hash3 = new simHash(s, 128);
        System.out.println(hash3.strSimHash+ "  " + hash3.strSimHash.bitCount());
        System.out.println("============================");
        System.out.println(hash1.hammingDistance(hash2));
        System.out.println(hash1.hammingDistance(hash3));
    }
}
