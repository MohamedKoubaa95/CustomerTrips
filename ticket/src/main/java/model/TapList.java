package model;

import java.util.List;

public class TapList {
	private List<Tap> taps;

	public List<Tap> getTaps() {
		return taps;
	}

	public void setTaps(List<Tap> taps) {
		this.taps = taps;
	}

	@Override
	public String toString() {
		return "tapList{"+ "taps='" + taps + '}';
	}
	
	
}
