/*******************************************************************************
 * '
 * PathInfo.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represent the information that is returned by a shortest path 
 * algorithm with two dictionaries that have the distance and precedents 
 * information
 * 
 ******************************************************************************/
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
