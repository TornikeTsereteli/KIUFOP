package StrategyPattern;

public class RoadStrategy implements RouteStrategy{
    @Override
    public Route buildRoute(Point a, Point b) {
        int distance  = b.a - a.a;
        return new Route(distance,distance/80);
    }
}
