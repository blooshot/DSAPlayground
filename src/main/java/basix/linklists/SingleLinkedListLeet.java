package basix.linklists;

import java.util.List;

public class SingleLinkedListLeet {

    public int val;
    public SingleLinkedListLeet next;
    public SingleLinkedListLeet() {}
    public SingleLinkedListLeet(int val) { this.val = val; }
    public SingleLinkedListLeet(int val, SingleLinkedListLeet next) { this.val = val; this.next = next; }
}
