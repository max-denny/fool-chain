import util.StringUtil;

import java.util.Date;


public class Block {

    public String hash;
    public String previousHash;
    private String data; //Simple message
    private long timeStamp; //# millisenconds since 1/1/1970

    //Block Constructor
    public Block(String data, String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    //Prevent tampering of previousHash, data, and timeStamp by applying helper method
    public String calculateHash(){
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );

        return calculatedhash;
    }

}
