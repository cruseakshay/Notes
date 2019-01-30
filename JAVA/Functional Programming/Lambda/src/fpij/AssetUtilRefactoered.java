package fpij;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import fpij.Asset.AssetType;

public class AssetUtilRefactoered {
	public static int totalAssetValues(final List<Asset> assets, Predicate<Asset> assetSelector) {
		return assets.stream().filter(assetSelector).mapToInt(Asset::getValue).sum();
	}
	public static void main(String[] args) {
		List<Asset> assets = Arrays.asList(
			      new Asset(Asset.AssetType.BOND, 1000),
			      new Asset(Asset.AssetType.BOND, 2000),
			      new Asset(Asset.AssetType.STOCK, 3000),
			      new Asset(Asset.AssetType.STOCK, 4000)
			    );
		// open/closed principle: can easily change the selection criteria without changing the method
		System.out.println("Total of all assets: " + totalAssetValues(assets, asset -> true));
		System.out.println("Total of bonds : " + totalAssetValues(assets, asset -> asset.getType() == AssetType.BOND ? true : false));
		System.out.println("Total of stocks: " + totalAssetValues(assets, asset -> asset.getType() == AssetType.STOCK ? true : false));
	}
}
