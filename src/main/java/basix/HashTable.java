package basix;

import java.util.HashMap;
import java.util.List;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public Node[] getDataMap() {
        return dataMap;
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        System.out.println("HashKey: " + index+" Key: "+key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            if (temp.key == key) {
                temp.value += value;
                return;
            }
            while (temp.next != null) {
                temp = temp.next;
                if (temp.key == key) {
                    temp.value += value;
                    return;
                }
            }
            temp.next = newNode;
        }
    }

    int get(String key){
        int hashedKey = hash(key);
        if(dataMap[hashedKey] != null){
            Node temp = dataMap[hashedKey];
            while(temp  !=  null){
                if(temp.key.equals(key)){
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        HashMap<String, List<String>> myMap = new HashMap<>();
       String[] strings =  new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

//            System.out.println(sorted);
        }


}//EC
