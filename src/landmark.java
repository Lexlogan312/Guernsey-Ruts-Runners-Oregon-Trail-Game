public class landmark extends map {
    private String name;
    private int distance;
    private String description;
    private String historicalInfo;
    private boolean hasRiver;
    private boolean isTradePost;

    public landmark(String name, int distance, String description, String historicalInfo, boolean hasRiver, boolean isTradePost) {
        this.name = name;
        this.distance = distance;
        this.description = description;
        this.historicalInfo = historicalInfo;
        this.hasRiver = hasRiver;
        this.isTradePost = isTradePost;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getDescription() {
        return description;
    }

    public String getHistoricalInfo() {
        return historicalInfo;
    }

    public boolean hasRiver() {
        return hasRiver;
    }

    public boolean isTradePost() {
        return isTradePost;
    }
}
}