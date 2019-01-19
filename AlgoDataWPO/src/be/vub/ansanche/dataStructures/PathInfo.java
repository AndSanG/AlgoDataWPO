package be.vub.ansanche.dataStructures;

public class PathInfo {
	private DictionaryTree distances;
	private DictionaryTree precedents;
	public PathInfo(DictionaryTree distances, DictionaryTree precedents) {
		super();
		this.distances = distances;
		this.precedents = precedents;
	}
	public DictionaryTree getDistances() {
		return distances;
	}
	public DictionaryTree getPrecedents() {
		return precedents;
	}
	
}
