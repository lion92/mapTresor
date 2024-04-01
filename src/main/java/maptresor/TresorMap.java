package maptresor;

import java.util.ArrayList;
import java.util.List;

public record TresorMap(String dimensionCard) {

    public List<PositionMap> getAllPostionMap() {
        int widthMap = Integer.parseInt(dimensionCard.split("-")[1].trim());
        int lengthMap = Integer.parseInt(dimensionCard.split("-")[2].trim());
        List<PositionMap> positionMaps = new ArrayList<PositionMap>();
        for (int length = 0; length <= lengthMap-1; length++) {
            for (int width = 0; width <= widthMap-1; width++) {
                if (width == widthMap-1 && length != lengthMap-1) {
                    positionMaps.add(new PositionMap(width, length, " . \n"));
                } else if (width == widthMap-1 && length == lengthMap-1) {
                    positionMaps.add(new PositionMap(width, length, " . "));

                } else {
                    positionMaps.add(new PositionMap(width, length, " . -"));
                }
            }
        }

        return positionMaps;
    }

    public String getGraph(List<PositionMap> possitionMaps) {
        StringBuilder str = new StringBuilder();
        for (PositionMap positionMap : possitionMaps) {
            str.append(positionMap.getItem());
        }
        return str.toString();
    }

    public List<PositionMap> putTresors(List<PositionMap> positionMaps, List<PointTresor> pointTresors) {
        positionMaps.forEach(positionMap -> {
            pointTresors.forEach(pointTresor -> {
                if (positionMap.getX() == pointTresor.x() && pointTresor.y() == positionMap.getY()) {
                    positionMap.setItem(positionMap.getItem().replaceAll("\\.", "T"));
                }
            });
        });

        return positionMaps;
    }

    public List<PositionMap> putMontains(List<PositionMap> positionMaps, List<MontainsPoint> montains) {
        positionMaps.forEach(positionMap -> montains.forEach(montainsPoint -> {
            if (positionMap.getX() == montainsPoint.x() && montainsPoint.y() == positionMap.getY()) {
                positionMap.setItem(positionMap.getItem().replaceAll( "[.]|[T]", "M"));
            }
        }));

        return positionMaps;
    }

    public List<PositionMap> putAdventurer(List<PositionMap> positionMaps, List<AvanturerMapTresor> adventurers) {
        positionMaps.forEach(positionMap -> {
            for (int i = 0; i < adventurers.size(); i++) {
                PointAdventurer adventurer = adventurers.get(i).getPointAdventurer();
                if (positionMap.getX() == adventurer.x() && adventurer.y() == positionMap.getY()) {
                    positionMap.setItem(positionMap.getItem().replaceAll("[.]|[T]", "("+i+")"));
                }
            }
        });

        return positionMaps;
    }



    public List<PositionMap> putAdventurer(List<PositionMap> allPostionMap, List<AvanturerMapTresor> historiqueDeplacementApresCommand, AvanturerMapTresor avanturerMapTresor ) {
        List<PositionMap> mapTresors = putTresors(allPostionMap, avanturerMapTresor.getPointTresorList());
        List<PositionMap> mapTresorsMontains = putMontains(mapTresors, avanturerMapTresor.getMontainsPoints());

        return putAdventurer(mapTresorsMontains, historiqueDeplacementApresCommand);

    }
}
