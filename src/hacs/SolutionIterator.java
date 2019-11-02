package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class SolutionIterator implements Iterator<Solution> {
	SolutionList solutionList;

	/// currentSolutionNumber: point to the location before the first element
	int currentSolutionNumber = -1;

	public SolutionIterator() {
	}

	public SolutionIterator(SolutionList thesolutionList) {
		solutionList = thesolutionList;
		MoveToHead();
	}

	public void MoveToHead() {
		/// currentSolutionNumber: point to the location before the first element
		currentSolutionNumber = -1;
	}

	public boolean hasNext() {
		/** @todo: Implement this java.util.Iterator method */
		if (currentSolutionNumber >= solutionList.size() - 1)
			return false;
		else
			return true;
//    throw new java.lang.UnsupportedOperationException("Method hasNext() not yet implemented.");
	}

	public Solution next() {
		/** @todo: Implement this java.util.Iterator method */
		if (hasNext() == true) {
			currentSolutionNumber++;
			return solutionList.get(currentSolutionNumber);
		} else {
			return null;
		}
		// throw new java.lang.UnsupportedOperationException("Method next() not yet
		// implemented.");
	}

	/// get the next Solution that fits the Username;
	public Solution next(String userName) {
		Solution theSolution;
		theSolution = (Solution) next();
		while (theSolution != null) {
			if (userName.compareTo(theSolution.theAuthor) == 0) {
				return theSolution;
			}
			theSolution = (Solution) next();
		}
		return null;
	}

	public void remove() {
		currentSolutionNumber++;
		solutionList.remove(currentSolutionNumber);
	}

}