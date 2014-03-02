package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract syntax tree of the structures construct in the QL4 grammar
 * Contains an array list of structures
 * @author Sammie Katt
 *
 */
public class QL4Structures extends QLTree {
	
	/**
	 * A list of all the structures in 'structure'
	 */
	List<QLTree> structures = new ArrayList<QLTree>();
	
	/**
	 * Adds a structure to structures
	 * @param structure is the structure to be added in the list of structures
	 */
	public void addStructure(QLTree structure) {
		structures.add(structure);
	}
	
	/**
	 * Returns the content of structures in the form of a string
	 */
	public String toString() {
		String str = "Structure containing: \n";
		
		// for each structure in structures add its description to the string
		for (QLTree struct : structures) {
			str += struct.toString() + "\n";
		}
		
		return str;
	}
	
	
}
