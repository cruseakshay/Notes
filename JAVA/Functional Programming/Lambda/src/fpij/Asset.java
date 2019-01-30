package fpij;

public class Asset {

	//	Asset is a simple JavaBean with two properties: type and value.
	public enum AssetType {BOND, STOCK};
	private final AssetType type;
	private final int value;
	
	public Asset(AssetType type, int value) {
		super();
		this.type = type;
		this.value = value;
	}
	public AssetType getType() {
		return type;
	}
	public int getValue() {
		return value;
	}
	
}
