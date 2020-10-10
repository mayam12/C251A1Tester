public class main {
    public static void main(String[] args) {
        // TODO:build the hash table and insert keys using the insertKeyArray function

        main m = new main();
        // Test Chaining class
        // hash function
        m.ChainTest1();
        m.ChainTest2();
        // insert values into a hashmap
        m.insertChainTest1();
        m.insertChainTest2();
        // hashfunction
        m.ProbeTest1();
        m.ProbeTest2();
        m.ProbeTest3();
        // insert values into a hashmap
        m.insertProbeTest1();
        m.insertProbeTest2();
        m.insertProbeTest3();
        // remove values from the hashmap
        m.removeProbeTest1();
        m.removeProbeTest2();
        m.removeProbeTest3();

        Open_Addressing o = new Open_Addressing(10, 0, -1);
        System.out.println(o.probe(1, 0));
        System.out.println(o.probe(1, 3));

    }

    /**
     * Given Chain Test
     */
    public void ChainTest1() {
        Chaining c = new Chaining(10, 0, -1);
        int hashValue = c.chain(1);
        if (hashValue == 30) {
            System.out.println("Chain Test 1 Passed");
        } else {
            System.out.println(" Failed Chain Test 1: Problem in Chaining.chain");
        }
    }

    /**
     * Random chain test
     */
    public void ChainTest2() {
        Chaining c = new Chaining(10, 0, -1);
        int hashValue = c.chain(36);
        if (hashValue == 6) {
            System.out.println("Chain Test 2 Passed");
        }
    }

    /**
     * Test if you can insert into chaining table when there are no elements in the
     * bucket
     */
    public void insertChainTest1() {
        Chaining c = new Chaining(10, 0, -1);
        int[] keyArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int collisions = c.insertKeyArray(keyArray);
        if (collisions == 0) {
            System.out.println("Insert Chain Test 1 Passed");
        } else {
            System.out.println("There are multiple collisions in a table that should not have any collisions");
        }
    }

    /**
     * Test if you can insert into chaining table when there are elements in the
     * bucket and value that exceed the elements in the bucket
     */
    public void insertChainTest2() {
        Chaining c = new Chaining(3, 0, -1);
        int[] keyArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
        int collisions = c.insertKeyArray(keyArray);
        if (collisions == 0) {
            System.out.println("You should have many collisions given the circumstances of this Table");
        } else {
            System.out.println("Insert Chain Test 2 Passed");
        }
    }

    /**
     * Check if probing works with i = 0
     */
    public void ProbeTest1() {
        Open_Addressing p = new Open_Addressing(10, 0, -1);
        int hash = p.probe(1, 0);
        if (hash == 30) {
            System.out.println("Probe Test 1 Passed");
        } else {
            System.out.println("Probe Test 1 Failed");
        }
    }

    /**
     * Check if probing works with m> i >0
     */
    public void ProbeTest2() {
        Open_Addressing p = new Open_Addressing(10, 0, -1);
        int hash = p.probe(1, 2);
        if (hash == 0) {
            System.out.println("Probe Test 2 Passed");
        } else {
            System.out.println("Probe Test 2 Failed");

        }
    }

    /**
     * Check if probing works with m =< i
     */
    public void ProbeTest3() {
        Open_Addressing p = new Open_Addressing(10, 0, -1);
        int hash2 = p.probe(1, 33);
        if (hash2 == -1) {
            System.out.println("Probe Test 3 Passed");
        } else {
            System.out.println("Probe Test 3 Failed");

        }
    }

    /**
     * insert with no conflicting probes
     */
    public void insertProbeTest1() {
        Open_Addressing p = new Open_Addressing(10, 0, -1);
        int[] keyArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
        int jumps = p.insertKeyArray(keyArray);
        if (jumps == 0) {
            System.out.println("Insert Probe Test 1 Passed");
        }
    }

    /**
     * Conflicting probes
     */
    public void insertProbeTest2() {
        Open_Addressing p = new Open_Addressing(3, 0, -1);
        int[] keyArray = { 1, 2, 2 };
        int jumps = p.insertKeyArray(keyArray);
        System.out.println(jumps);
        assert jumps == 1;
        if (jumps == 1) {
            System.out.println("Insert Probe Test 2 Passed");
        }
    }

    /**
     * Too many probes in the table to add any.
     */
    public void insertProbeTest3() {

    }

    /**
     * insert with i = 0
     */
    public void removeProbeTest1() {

    }

    /**
     * insert with m>i > 0
     */

    public void removeProbeTest2() {

    }

    /**
     * Remove value that is not there at all
     */
    public void removeProbeTest3() {

    }

}