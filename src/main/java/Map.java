public record Map(String dimensionCard) {

    public String getMap() {
        int widthMap = Integer.parseInt(dimensionCard.split("-")[1].trim());
        int lengthMap = Integer.parseInt(dimensionCard.split("-")[2].trim());
        String map = "";
        for (int length = 1; length <= lengthMap; length++) {
            for (int width = 1; width <= widthMap; width++) {
                if (width==widthMap && length!=lengthMap) {
                    map += " X \n";
                } else if(width==widthMap && length==lengthMap){
                    map+=" X ";
                }
                else {
                    map += " X -";
                }
            }
        }

        return map;
    }
}
