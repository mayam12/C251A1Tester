public class main {     
	public static void main(String[] args) {
	        // TODO:build the hash table and insert keys using the insertKeyArray function
			int N_TESTS = 13; 
			int grade = 0;
			
	        main m = new main();
	        // Test Chaining class
	        // hash function
	        grade += m.ChainTest1();
	        grade += m.ChainTest2();
	        // insert values into a hashmap
	        grade += m.insertChainTest1();
	        grade += m.insertChainTest2();
	        // hashfunction
	        grade += m.ProbeTest1();
	        grade += m.ProbeTest2();
//	        m.ProbeTest3();
	        // insert values into a hashmap
	        grade += m.insertProbeTest1();
	        grade += m.insertProbeTest2();
	        grade += m.insertProbeTest3();
	        // remove values from the hashmap
	        grade += m.removeProbeTest1();
	        grade += m.removeProbeTest2();
	        
//	        m.removeProbeTest3();
	        
	        grade += m.removeProbeTest4();
	        grade += m.removeProbeTest5();

//	        Open_Addressing o = new Open_Addressing(10, 0, -1);
//	        System.out.println(o.probe(1, 0));
//	        System.out.println(o.probe(1, 3));
	        
	        System.out.println("Passed " + grade + "/" + N_TESTS + " test.");

	    }

	    /**
	     * Given Chain Test
	     */
	    public int ChainTest1() {
	        Chaining c = new Chaining(10, 0, -1);
	        int hashValue = c.chain(1);
	        if (hashValue == 30) {
	            System.out.println("Chain Test 1 Passed");
	            return 1;
	        } else {
	            System.out.println(" Failed Chain Test 1: Problem in Chaining.chain");
	            return 0;
	        }
	    }

	    /**
	     * Random chain test
	     */
	    public int ChainTest2() {
	        Chaining c = new Chaining(10, 0, -1);
	        int hashValue = c.chain(36);
	        if (hashValue == 6) {
	            System.out.println("Chain Test 2 Passed");
	            return 1;
	        }
	        System.out.println("Chain Test 2 Failed");
	        return 0;
	    }

	    /**
	     * Test if you can insert into chaining table when there are no elements in the
	     * bucket
	     */
	    public int insertChainTest1() {
	        Chaining c = new Chaining(10, 0, -1);
	        int[] keyArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	        int collisions = c.insertKeyArray(keyArray);
	        if (collisions == 0) {
	            System.out.println("Insert Chain Test 1 Passed");
	            return 1;
	        } else {
	            System.out.println("There are multiple collisions in a table that should not have any collisions");
	            return 0;
	        }
	    }

	    /**
	     * Test if you can insert into chaining table when there are elements in the
	     * bucket and value that exceed the elements in the bucket
	     */
	    public int insertChainTest2() {
	        Chaining c = new Chaining(3, 0, -1);
	        int[] keyArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
	        int collisions = c.insertKeyArray(keyArray);
	        if (collisions == 0) {
	            System.out.println("You should have many collisions given the circumstances of this Table");
	            return 0;
	        } else {
	            System.out.println("Insert Chain Test 2 Passed");
	            return 1;
	        }
	    }

	    /**
	     * Check if probing works with i = 0
	     */
	    public int ProbeTest1() {
	        Open_Addressing p = new Open_Addressing(10, 0, -1);
	        int hash = p.probe(1, 0);
	        if (hash == 30) {
	            System.out.println("Probe Test 1 Passed");
	            return 1;
	        } else {
	            System.out.println("Probe Test 1 Failed");
	            return 0;
	        }
	    }

	    /**
	     * Check if probing works with m> i >0
	     */
	    public int ProbeTest2() {
	        Open_Addressing p = new Open_Addressing(10, 0, -1);
	        int hash = p.probe(1, 2);
	        if (hash == 0) {
	            System.out.println("Probe Test 2 Passed");
	            return 1;
	        } else {
	            System.out.println("Probe Test 2 Failed");
	            return 0;

	        }
	    }
	    /**
	     * insert with no conflicting probes
	     */
	    public int insertProbeTest1() {
	        Open_Addressing p = new Open_Addressing(10, 0, -1);
	        int[] keyArray = {1,2,3,4,5,6,7,8,9,10};
	        int jumps = p.insertKeyArray(keyArray);
	        if (jumps == 0) {
	            System.out.println("Insert Probe Test 1 Passed");
	            return 1;
	        } else {
	            System.out.println("Insert Probe Test 1 Failed");
	            return 0;
	        }
	    }

	    /**
	     * Conflicting probes
	     */
	    public int insertProbeTest2() {
	        Open_Addressing p = new Open_Addressing(3, 0, -1);
	        int[] keyArray = { 2, 2 };
	        int jumps = p.insertKeyArray(keyArray);
	        if  (jumps== 1){
	        System.out.println("Insert Probe Test 2 Passed");
	        return 1;
	        } else {
	        System.out.println("Insert Probe Test 2 Failed");
	        return 0;
	        }
	    }

	    /**
	     * Too many probes in the table to add any.
	     */
	    public int insertProbeTest3() {
	        Open_Addressing p = new Open_Addressing(2, 0, -1);
	        int[] keyArray = { 1, 2, 3 };
	        p.insertKeyArray(keyArray);
	        int jumps = p.insertKey(5);
	        if (jumps == 2){
	            System.out.println("Insert Probe Test 3 Passed");
	            return 1;
	        } else {
	            System.out.println("Insert Probe Test 3 Failed");
	            return 0;
	        }
	    }

	/**
	     * remove from when there are no jumps
	     */
	    
	    // EDIT : jumps should be equal to 1 and not 0 since it represents the number of values VISITED
	    // and not the number of collisions ! (https://piazza.com/class/kejdjsyfkol69g?cid=266)
	    public int removeProbeTest1(){
	        Open_Addressing p = new Open_Addressing(10, 0, -1);
	        int[] keyArray = {1,2,3,4,5,6,7,8,9,10};
	        p.insertKeyArray(keyArray);
	        int jumps = p.removeKey(1);
	        int removedVal = p.Table[p.probe(1,0)];
	        int jumpsTwo = p.removeKey(2);
	        int removedVal2 = p.Table[p.probe(2,0)];

	        if (    jumps == 1 &&
	                removedVal!= 1 &&
	                jumpsTwo == 1 &&
	                removedVal2 != 2 &&
	                p.Table[p.probe(3,0)] == 3)
	        {
	            System.out.println("Remove Probe Test 1 Passed");
	            return 1;
	        } else {
	            System.out.println("Remove Probe Test 1 Failed");
	            return 0;
	        }

	    }
	    /**
	     * Remove with some jumps
	     */


	    public int removeProbeTest2(){
	        Open_Addressing o = new Open_Addressing(2, 0, -1);
	        int[] keyArray = {1,2};
	        o.insertKeyArray(keyArray);
	        o.removeKey(2);
	        int removedVal = o.Table[o.probe(2,1)];
	        int keptVal = o.Table[o.probe(1,0)];

	        if ( removedVal != 2&& keptVal == 1)
	        {
	            System.out.println("Remove Probe Test 2 Passed");
	            return 1;
	        } else {
	            System.out.println("Remove Probe Test 2 Failed" );
	            return 0;
	        }
	    }
	    /**
	     * Remove when the key is is not in the table
	     * */
	    // number of value visited should't be >= o.m since only one visit will determine that no values
	    // have been inserted in the first place => should check jumps == 1
	    // implemented the logic in removeProbeTest4 and removeProbeTest5
//	    public void removeProbeTest3(){
//	            Open_Addressing o = new Open_Addressing(10, 0, -1);
//	            int jumps = o.removeKey(2);
//	            int removedVal = o.Table[o.probe(2,0)];
//	            if (removedVal != 2 && jumps >= o.m)
//	            {
//	                System.out.println("Remove Probe Test 3 Passed");
//	            }
//	            else{
//	                System.out.println("Remove Probe Test 3 Failed" );
//	            }
//
//
//	    }
	    
	    // Remove key not in table
	    // Upgrade compared to removeProbeTest3 : 
	    // checking the whole hashTable and one visit max since empty.
	    public int removeProbeTest4() {
	    	Open_Addressing o = new Open_Addressing(10, 0, -1);
	    	int collisions = o.removeKey(2);
	    	
	    	// should not have changed the hashTable since 2 not in it :
	    	for (int i = 0 ; i < o.m ; i++) {
	    		if (o.Table[i] != -1) {
	    			// Error : modified the hashTable
	    			System.out.println("Remove Probe Test 4 Failed - modified hashTable");
	    			return 0;
	    		}
	    	}
	    	
	    	if (collisions == 1) {
	    		System.out.println("Remove Probe Test 4 Passed");
	    		return 1;
	    	} else {
	    		// Error : Too many jumps
    			System.out.println("Remove Probe Test 4 Failed - too many entries visited");
    			return 1;
	    	}
	    	
	    }
	    
	    // remove a key that has been in the table but deleted
	    // # of jumps should be equal to 2
	    public int removeProbeTest5() {
	    	Open_Addressing o = new Open_Addressing(10, 0, -1);
	    	o.insertKey(2);
	    	o.removeKey(2);
	    	int jumps = o.removeKey(2);
	    	
	    	if (o.Table[o.probe(2, 0)] >= 0) {
    			System.out.println("Remove Probe Test 5 Failed - value not correctly deleted");
    			return 0;
    		}
	    	
	    	// should not have changed the hashTable since 2 not in it :
	    	for (int i = 0 ; i < o.m ; i++) {
	    		if (i == o.probe(2, 0)) {continue;}
	    		if (o.Table[i] != -1) {
	    			// Error : modified the hashTable
	    			System.out.println("Remove Probe Test 5 Failed - modified hashTable");
	    			return 0;
	    		}
	    	}
	    	
	    	if (jumps == 2) {
	    		System.out.println("Remove Probe Test 5 Passed");
	    		return 1;
	    	} else {
	    		// Error : Too many / few jumps
    			System.out.println("Remove Probe Test 5 Failed - not correct amount of jumps");
    			return 0;
	    	}
	    	
	    }
}