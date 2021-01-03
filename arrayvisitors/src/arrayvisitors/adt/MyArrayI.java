package arrayvisitors.adt;

public interface MyArrayI {
    int ValidateSize(Integer[] mySet, int currentSize);
    Integer[] UpdateSetSize(Integer[] mySet, int currentSize);
    void AddElement(Integer[] mySet, int element, int location);
}
