package Codewars.Java;

import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    private List<I> collection = null;
    private int itemsPerPage = 0;
    private int dataSize = 0;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = Math.max(1, itemsPerPage);
        this.dataSize = collection.size();
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return dataSize;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (dataSize + itemsPerPage - 1) / itemsPerPage;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        int pc = pageCount();
        if (pageIndex < 0 || pageIndex >= pc) {
            return -1;
        }
        if (pageIndex == pc - 1) {
            if(dataSize%itemsPerPage==0) {
                return itemsPerPage;
            }else{
                 return this.itemCount()%itemsPerPage;
            }                               
        }
         return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        return itemIndex <0 || itemIndex >= this.dataSize ? -1 : itemIndex/itemsPerPage;
    }
}