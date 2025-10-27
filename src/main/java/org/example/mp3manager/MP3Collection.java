package org.example.mp3manager;
import java.io.File;
import java.util.Comparator;

public class MP3Collection {

    private Object[] Mp3Library;
    private Comparator<Mp3File> comp;
    private int number;

    /**
     * Creates an empty collection.
     */
    public MP3Collection() {
        Mp3Library = new Mp3File[20];
    }

    /**
     * Creates a collection containing files in the specified directory.
     * The collection includes only files with the .mp3 extension.
     * @param directoryPathname the path name of the directory to scan
     */
    public MP3Collection(String directoryPathname) {
        File folder = new File(directoryPathname);
        File[] list = folder.listFiles();

        SimpleArrayList<Mp3File> mp3List = new SimpleArrayList<Mp3File>();

        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].getAbsolutePath().endsWith(".mp3")) {
                    Mp3File a = new Mp3File(list[i].getAbsolutePath());
                    mp3List.add(a);
                }
            }
        }
        Mp3Library = mp3List.toArray();
    }

    /**
     * Sorts the collection according to a given comparator.
     * @param c the comparator for Mp3File elements
     */
    public void sort(Comparator<Mp3File> c) {
        comp = c;
        number = Mp3Library.length;
        quicksort(0, number - 1);
    }

    /**
     * Internal quicksort.
     * @param left left index
     * @param right right index
     */
    private void quicksort(int left, int right) {
        int i = left, j = right;
        Object pivot = Mp3Library[left + (right - left) / 2];

        while (i <= j) {
            while (comp.compare((Mp3File) Mp3Library[i], (Mp3File) pivot) < 0) {
                i++;
            }
            while (comp.compare((Mp3File) Mp3Library[j], (Mp3File) pivot) > 0) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (left < j) quicksort(left, j);
        if (i < right) quicksort(i, right);
    }

    /**
     * Internal swap used by quicksort.
     * @param i first index
     * @param j second index
     */
    private void exchange(int i, int j) {
        Object temp = Mp3Library[i];
        Mp3Library[i] = Mp3Library[j];
        Mp3Library[j] = temp;
    }

    /**
     * Searches for a given Mp3File using the given comparator.
     * Returns the index of the file in the collection or -1 if not found.
     * @param file the Mp3File to search for
     * @param comp the comparator consistent with the sort order
     * @return index of the file or -1 if not found
     */
    public int search(Mp3File file, Comparator<Mp3File> comp) {
        int left = 0;
        int right = Mp3Library.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (comp.compare((Mp3File) Mp3Library[mid], file) < 0)
                left = mid + 1;
            else if (comp.compare((Mp3File) Mp3Library[mid], file) > 0)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Returns the size of the collection.
     * @return size of the collection
     */
    public int size() {
        return Mp3Library.length;
    }

    /**
     * Returns an Mp3File at the given index.
     * @param index the index in the array
     * @return the Mp3File at the given index
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public Mp3File getFile(int index) throws IndexOutOfBoundsException {
        return (Mp3File) Mp3Library[index];
    }

    /**
     * Plays an Mp3File at the given index.
     * @param index the index in the array
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public void play(int index) throws IndexOutOfBoundsException {
        MP3Player player = new MP3Player();
        player.play(((Mp3File) Mp3Library[index]).getPath());
    }
}