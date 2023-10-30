package io.github.suppennudel.mtg.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class MtgDeckInfo implements MtgDeckInfoInterface {

	public enum ListSection {
		MAIN, SIDEBOARD;
	}

	private Map<String, Integer> main = new HashMap<>();
	private Map<String, Integer> side = new HashMap<>();

	private Map<String, Integer> combined;

	private File file;
	private String url;
	private String name;
	private LocalDate date;
	private String source;

	public MtgDeckInfo(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", name, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MtgDeckInfo) {
			MtgDeckInfo other = (MtgDeckInfo) obj;
			boolean result = other.toString().equals(toString());
			return result;
		}
		return false;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public Map<String, Integer> getCombined() {
		if (combined == null) {
			combined = new HashMap<>(main);
			side.forEach((key, value) -> combined.merge(key, value, (v1, v2) -> v1 + v2));
		}
		return combined;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}
	@Override
	public String getName() {
		return name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Map<String, Integer> getMain() {
		return main;
	}
	public Map<String, Integer> getSide() {
		return side;
	}

	@Override
	public String getUrl() {
		return url;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String getSource() {
		return source;
	}

	public File getFile() {
		return file;
	}

	public abstract void parse(File file) throws IOException;

}
