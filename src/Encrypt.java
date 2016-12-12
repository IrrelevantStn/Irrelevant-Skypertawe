import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.math.BigInteger;
/**
 * Class which provides the ability to retrieve a securely generated Salt
 * for improving password protections, as well as both Hashing any Object
 * passed in (for creation of a hash) and regenerating a Hash from a given
 * input and previously generated Salt (For password verification)
 * @author Mathew Estienne
 */
public class Encrypt
{
    /**
     * Given a String (passwordToHash) and a previously generated array of
     * bytes (salt), generate a hash from the two inputs and return it
     * @param passwordToHash A string to be hashed with salt and returned
     * @param salt A previously computed byte array, to be combined with
     *             passwordToHash and returned
     * @return String
     */
    public static String hashString(String passwordToHash, byte[] salt){
        String generatedHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.digest(passwordToHash.getBytes());
            md.update(salt);
            generatedHash = new BigInteger(1, md.digest()).toString(m_BASE_SIZE);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedHash;
    }

    /**
     * Given any Object (objectToHash), attempt to retrieve a secure byte
     * array (salt), convert the Object to a String and pass them on to
     * hashString
     * @param objectToHash Any Object you wish to be represented as a Hash
     * @return String
     */
    public static String hashPrep(Object objectToHash) throws NoSuchAlgorithmException, NoSuchProviderException{
        return hashString(objectToHash.toString(), getSalt());
    }

    /**
     * Retrieve a securely generated byte array (salt) of length m_SALT_SIZE
     * and return it
     * @return byte[]
     */
    public static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        byte[] salt = new byte[m_SALT_SIZE];
        sr.nextBytes(salt);
        return salt;
    }

    final static int m_SALT_SIZE = 16;
    final static int m_BASE_SIZE = 16;
}