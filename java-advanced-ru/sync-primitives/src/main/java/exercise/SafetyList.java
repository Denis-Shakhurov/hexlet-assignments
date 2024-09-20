package exercise;

class SafetyList {
    // BEGIN
    private Integer[] elements;
    private int size;
    private int capacity;

    public SafetyList() {
        capacity = 10;
        size = 0;
        elements = new Integer[capacity];
    }

    public synchronized void add(int element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    public Integer get(int index) {
        return elements[index + 1];
    }

    public Integer getSize() {
        Integer size = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                size = i;
                break;
            }
        }
        return size;
    }

    private void grow() {
        capacity = capacity + capacity / 2;
        size = elements.length;
        Integer[] newElements = new Integer[capacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    // END
}
