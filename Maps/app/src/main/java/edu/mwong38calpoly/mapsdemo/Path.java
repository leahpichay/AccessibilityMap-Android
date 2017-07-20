package edu.mwong38calpoly.mapsdemo;

import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bokumura on 12/0/16? <- heehee.
 */

public class Path {
    public LatLng p1;
    public LatLng p2;
    int type;
    /*
    0 == everyone
    1 == meh.  Might be unreachable by some
    2 = Nope.  stairs suck.
     */

    /*Ranking can be changed later.*/
    public Path (LatLng p1, LatLng p2, int type) {
        this.p1 = p1;
        this.p2 = p2;
        this.type = type;
    }

/* ==================================================================*/
     /*PROOF OF CONCEPT FROM HERE DOWN*/
    /*Good luck with this:  bokumura@calpoly.edu*/
/* ==================================================================*/

    /* Super greedy.  Need to fix H and G weights for a more realistic path*/
    /*I also assume that the whole graph is connected.
    * IF IT ISN"T, GOOD LUCK WITH THE INFINITE LOOP :3 */

    public void main(GoogleMap map){
        ArrayList<Node> g = createGraph();
        ArrayList<Node> answer= aStar(g,g.get(0), g.get(6));
        System.out.println("ANSWER");

        PolylineOptions plo = new PolylineOptions().width(5).color(Color.RED);
        for (Node n : answer) {
            System.out.println(n.name);
            plo.add(n.coord);
        }

        Polyline line = map.addPolyline(plo);

    }

    public ArrayList<Node> createGraph() {
        /*Small area around campus*/
        /*Navigates from about dexter lawn to the rec center*/
        Node a = new Node("A",new LatLng(35.300240, -120.664044));
        Node b = new Node("B", new LatLng(35.300507, -120.662660));
        Node c = new Node("C", new LatLng(35.301178, -120.661493));
        Node d = new Node("D", new LatLng(35.299337, -120.663785));
        Node e = new Node("E", new LatLng(35.299600, -120.662385));
        Node f = new Node("F", new LatLng(35.299811, -120.660627));
        Node g = new Node("G", new LatLng(35.298988, -120.660368));
        a.connections = new ArrayList<Node>(Arrays.asList(b,d));
        b.connections = new ArrayList<Node>(Arrays.asList(a,c,e));
        c.connections = new ArrayList<Node>(Arrays.asList(b,f));
        d.connections = new ArrayList<Node>(Arrays.asList(a,e));
        e.connections = new ArrayList<Node>(Arrays.asList(d,b,f));
        f.connections = new ArrayList<Node>(Arrays.asList(c,e,g));
        g.connections = new ArrayList<Node>(Arrays.asList(f));

        ArrayList<Node> graph = new ArrayList<Node>(Arrays.asList(a,b,c,d,e,f,g));
        return graph;
    }

    /*A* search algorithm*/
    public ArrayList<Node> aStar(ArrayList<Node> graph, Node start, Node target){
        ArrayList<Node> openList = new ArrayList<Node>();
        ArrayList<Node> closedList = new ArrayList<Node>();
        Node current = null;
        boolean found = false;

        current = start;
        while(!openList.contains(target)){
            openList.addAll(allNodes(current,target));
            closedList.add(current);
            openList.remove(current);
            /*THE GREED IS REAL!*/
            current = pickBest(openList);
            if(current.totalCost == 0)
                break;
        }
        ArrayList<Node> solution = new ArrayList<Node>();
        while(current != null){
            solution.add(current);
            current = current.parent;
        }
        Collections.reverse(solution);
        return solution;
    }

    public ArrayList<Node> allNodes(Node n, Node target){
        ArrayList<Node> temp = new ArrayList<Node>();
        for(Node t: n.connections){
            Node x = new Node(t);
            x.totalCost = getDist(t,target) + g();
            x.parent = n;
            temp.add(x);
        }
        return temp;
    }

    public double getDist(Node n1, Node n2){
        return SphericalUtil.computeDistanceBetween(n1.coord, n2.coord);
    }

    /*TODO: weight differently*/
    public int g(){
        return 0; //NO PATH COST lol
    }

    public Node pickBest(ArrayList<Node> l){
        Node temp = l.get(0);
        for(Node n:l){
            if(n.totalCost < temp.totalCost)
                temp = n;
        }
        return temp;
    }

    public class Node{
        public Node(String name, LatLng coord){
            this.name = name;
            this.coord = coord;
        }
        public Node (Node n){
            this.name = n.name;
            this.coord = n.coord;
            this.connections = n.connections;
        }
        int h_heuristic = 0;
        int g_movementCost = 0;
        double totalCost = 0;
        Node parent=null;

        String name;
        LatLng coord;
        public List<Node> connections;
    }


}
