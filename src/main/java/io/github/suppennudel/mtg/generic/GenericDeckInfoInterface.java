package io.github.suppennudel.mtg.generic;

import java.time.LocalDate;
import java.util.Map;

public interface GenericDeckInfoInterface {

	Map<String, Integer> getCombined();
	String getName();
	LocalDate getDate();
	String getUrl();
	String getSource();

}
