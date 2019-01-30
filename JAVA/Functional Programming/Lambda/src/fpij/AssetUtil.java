package fpij;

import java.util.Arrays;
import java.util.List;

import fpij.Asset.AssetType;

public class AssetUtil {
	// Design separation of concerns: 
	//	List concerns
	// 1. The iteration: how to iterate
	// 2. what to total[this changes for 3 methods listed below]
	// 3. how to total
	
	// to total the values of all the assets
	public static int totalAssetValue(final List<Asset> assets) {
		return assets.stream().mapToInt(Asset::getValue).sum();
	}

	public static int totalBondValues(final List<Asset> assets) {
		return assets.stream().filter(asset -> asset.getType() == AssetType.BOND ? true : false)
				.mapToInt(Asset::getValue).sum();
	}

	public static int totalStockValues(final List<Asset> assets) {
		return assets.stream().mapToInt(asset -> asset.getType() == AssetType.STOCK ? asset.getValue() : 0).sum();
	}

	public static void main(String[] args) {
		final List<Asset> assets = Arrays.asList(new Asset(AssetType.BOND, 1000), new Asset(AssetType.BOND, 2000),
				new Asset(AssetType.STOCK, 3000), new Asset(AssetType.STOCK, 4000));

		System.out.println("Total of all assets: " + totalAssetValue(assets));
		System.out.println("Total of BONDs : " + totalBondValues(assets));
		System.out.println("Total of Stocks : " + totalStockValues(assets));
	}
}
