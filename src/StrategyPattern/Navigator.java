package StrategyPattern;

public class Navigator {
    private RouteStrategy routeStrategy;
    public Navigator(RouteStrategy routeStrategy){
        this.routeStrategy = routeStrategy;
    }

    public Route buildRoute(Point a,Point b){
        return routeStrategy.buildRoute(a,b);
    }

    public static void main(String[] args) {
       Navigator navigator1 = new Navigator(new RoadStrategy());
       Route route1 = navigator1.buildRoute(new Point(2), new Point(5000));

       Navigator navigator2 = new Navigator(new WalkingStrategy());
       Route route2 = navigator2.buildRoute(new Point(2),new Point(5000));
    }

}
