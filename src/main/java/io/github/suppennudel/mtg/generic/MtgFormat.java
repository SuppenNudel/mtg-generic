package io.github.suppennudel.mtg.generic;

public enum MtgFormat {

	STANDARD("Standard"),
	PIONEER("Pioneer"),
	MODERN("Modern"),
	LEGACY("Legacy");

	private String string;

	private MtgFormat(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return string;
	}

	public static MtgFormat reverseConvert(String formatString) {
		for(MtgFormat format : MtgFormat.values()) {
			if(format.toString().equals(formatString)) {
				return format;
			}
		}
		throw new UnsupportedOperationException(formatString + " is not supported");
	}

}
