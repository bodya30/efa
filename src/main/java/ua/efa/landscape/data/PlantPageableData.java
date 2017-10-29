package ua.efa.landscape.data;

import ua.efa.landscape.model.Plant;

import java.util.List;

public class PlantPageableData {
    private int pageNumber;
    private int pageSize;
    private long totalPageCount;
    private List<Plant> plantsInPage;

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

    public List<Plant> getPlantsInPage() {
        return plantsInPage;
    }

    public void setPlantsInPage(List<Plant> plantsInPage) {
        this.plantsInPage = plantsInPage;
    }
}
