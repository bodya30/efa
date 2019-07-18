package ua.efa.landscape.data;

import ua.efa.landscape.model.Plant;

import java.util.List;
import java.util.Objects;

public class PlantPageableData {
    private int pageNumber;
    private int pageSize;
    private long totalPageCount;
    private List<Plant> plants;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(long totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantPageableData that = (PlantPageableData) o;
        return pageNumber == that.pageNumber &&
                pageSize == that.pageSize &&
                totalPageCount == that.totalPageCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, pageSize, totalPageCount);
    }
}
