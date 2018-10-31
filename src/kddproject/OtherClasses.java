package kddproject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OtherClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        HashSet<HashSet<String>> h = new HashSet<>();
        HashSet<HashSet<String>> h2 = new HashSet<>();
        HashSet<String>  sh = new HashSet<>();
        HashSet<String>  sh2 = new HashSet<>();
        sh.add("A1");
        sh.add("A2");
        sh.add("A3");
        h.add(sh);
        sh2.add("A1");
        sh2.add("C4");
        h2.add(sh2);
        System.out.println(h);
        System.out.println(h2);
        //System.out.println(multiply(h,h2));
        System.out.println(ensureDifferentAttributes(sh));
	}
	private static boolean ensureDifferentAttributes(HashSet<String> combinedKeys) {

		Iterator<String> itr = combinedKeys.iterator(); 
		for(int i = 0; i<combinedKeys.size(); i++){
			if(itr.hasNext()) {
				String str = itr.next();
				Iterator<String> itr1 = combinedKeys.iterator();
				for(int j = 0; j<combinedKeys.size(); j++){
					if(itr1.hasNext()) {
						String str1 = itr1.next();
						System.out.println(str+" "+str1);
					}
				}
				
			}
		}
		return false;
		
	}
	private static HashSet<HashSet<String>> multiply(HashSet<HashSet<String>> set1, HashSet<HashSet<String>> set2) {
		HashSet<HashSet<String>> set = new HashSet<HashSet<String>>();
		Iterator<HashSet<String>> itr1 = set1.iterator();
		System.out.println(itr1);
		for(int i=0; i<set1.size(); i++ ) {
			if(itr1.hasNext()) { 
				HashSet<String> smallerSet1 = itr1.next();
				System.out.println(smallerSet1);
				Iterator<String> itr2 = smallerSet1.iterator();
				for(int j=0; j<smallerSet1.size(); j++ ) {
					if(itr2.hasNext()) { 
						String attrVal = itr2.next();
						System.out.println(attrVal);
						Iterator<HashSet<String>> itr11 = set2.iterator();
						for(int i1=0; i1<set1.size(); i1++ ) {
							if(itr11.hasNext()) { 
								HashSet<String> smallerSet11 = itr11.next();
								//System.out.println(smallerSet11);
								Iterator<String> itr21 = smallerSet11.iterator();
								for(int j1=0; j1<smallerSet11.size(); j1++ ) {
									if(itr21.hasNext()) { 
										String attrVal1 = itr21.next();
										System.out.println(attrVal1);
									}
								}
							}	
				        }
					}
				}
			}	
        }
//		for(HashSet<String> hSet: set1.forEach(action); )
//		for(int i=0; i<set1.size(); i++ ) {
//			HashSet<String> smallerSet = new HashSet<>();
//			for(int j=0; i<set2.size(); i++ ) {
//				
//				System.out.println(set1.toArray()[i]);
//				
//				smallerSet.add(set1.toArray()[i].toString());
//				smallerSet.add(set2.toArray()[j].toString());
//			}
//			set.add(smallerSet);
//		}
		return set;
	}
	public static Set<Set<Object>> cartesianProduct(Set<?>... sets) {
	    if (sets.length < 2)
	        throw new IllegalArgumentException(
	                "Can't have a product of fewer than two sets (got " +
	                sets.length + ")");

	    return _cartesianProduct(0, sets);
	}

	private static Set<Set<Object>> _cartesianProduct(int index, Set<?>... sets) {
	    Set<Set<Object>> ret = new HashSet<Set<Object>>();
	    if (index == sets.length) {
	        ret.add(new HashSet<Object>());
	    } else {
	        for (Object obj : sets[index]) {
	            for (Set<Object> set : _cartesianProduct(index+1, sets)) {
	                set.add(obj);
	                ret.add(set);
	            }
	        }
	    }
	    return ret;
	}

}
