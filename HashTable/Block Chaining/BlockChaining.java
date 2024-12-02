package BlockChainHashing;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

class Block{
	private String transactionDetails;
	private String previousHash;
	private String blockHash;
	
	
	public Block(String transactionDetails, String previousHash){
		this.transactionDetails=transactionDetails;
		this.previousHash=previousHash;
		this.blockHash=generateBlockHash();
	}
	
	public String generateBlockHash(){
		String dataToHash=transactionDetails+previousHash;
		String blockHash=BlockchainHashing.generateHash(dataToHash);
		
		return blockHash;
	}
	
	public String getBlockHash(){
		return blockHash;
	}
	public String getPreviousHash(){
		return previousHash;
	}
	
	@Override
	public String toString(){
		String blockData="Block{ transactionDetails= "+transactionDetails+"--,previousHash= "
						  +previousHash+"--,blockHash= "+blockHash+"}.";	
		return blockData;
	}
}

class BlockchainHashing{
	public static String generateHash(String blockData){
		try{
			MessageDigest dig=MessageDigest.getInstance("SHA-256");
			byte[] hashbytes=dig.digest(blockData.getBytes());
			
			StringBuilder hexDecimalString =new StringBuilder();
			
			for(byte b:hashbytes){
				String hexValue=Integer.toHexString(0xff & b);
				
				if(hexValue.length()==1){
					hexDecimalString.append('0');
				}
				
				hexDecimalString.append(hexValue);
			}
			return hexDecimalString.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
			return null;
		}
	}
}

public class BlockChaining{
	private LinkedList<Block> blockChain;
	
	public BlockChaining(){
		blockChain=new LinkedList<>();
		blockChain.add(new Block("Genesis Block","0"));
	}
	
	public void addBlock(String transactionDetails){
		String previousHash=blockChain.getLast().getBlockHash();
		Block block=new Block(transactionDetails,previousHash);
		blockChain.add(block);
	}
	
	public void displayBlockchain(){
		for(Block b:blockChain){
			System.out.println(b);
		}
	}
	
	public static void main(String[] args) {
		BlockChaining bc=new BlockChaining();
		bc.addBlock("Ahsan pays Ali $10");
		bc.addBlock("Ali pays Ahmed $50");
		bc.displayBlockchain();
	}
}
